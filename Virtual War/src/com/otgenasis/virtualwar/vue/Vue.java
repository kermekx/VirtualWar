package com.otgenasis.virtualwar.vue;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.plateau.Base;
import com.otgenasis.virtualwar.plateau.Case;
import com.otgenasis.virtualwar.plateau.Cellule;
import com.otgenasis.virtualwar.plateau.Plateau;
import com.otgenasis.virtualwar.robot.Robot;

public class Vue {

	private Plateau plateau;
	private int equipe;

	public Vue(Plateau plateau, int equipe) {
		this.plateau = plateau;
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		String vue = "";
		Cellule[][] cellules = plateau.getPlateau();
		for (int i = 0; i < cellules.length; i++) {
			for (int j = 0; j < cellules[0].length; j++) {
				vue += "[";
				if (cellules[i][j] instanceof Base) {
					Base base = (Base) cellules[i][j];
					vue += (base.getEquipe() == equipe) ? "B" : "b";
				} else if (cellules[i][j] instanceof Case) {
					Case cas = (Case) cellules[i][j];
					if (cas.getContenu() != null)
						vue += (cas.getContenu().getEquipe() == equipe) ? cas
								.getContenu().getType().substring(0, 1) : cas
								.getContenu().getType().substring(0, 1)
								.toLowerCase();
					else
						vue += " ";
				} else
					vue += " ";
				vue += "]";
			}
			vue += "\n";
		}
		return vue;
	}

	public Coordonnees getBase(int equipe) {
		Cellule[][] cellules = plateau.getPlateau();
		for (int i = 0; i < cellules.length; i++) {
			for (int j = 0; j < cellules[0].length; j++) {
				if (cellules[i][j] instanceof Base) {
					Base base = (Base) cellules[i][j];
					if (base.getEquipe() == equipe)
						return base.getCoordonnees();
				}
			}
		}
		return null;
	}

	public Robot getUnite(Coordonnees coord) {
		Cellule cellule = plateau.getPlateau()[coord.getX()][coord.getY()];
		if (cellule instanceof Case) {
			Case vCase = (Case) cellule;
			return vCase.getContenu();
		}
		return null;
	}

	public void move(Coordonnees coord, Coordonnees newCoord, Robot robot) {
		plateau.getPlateau()[coord.getX()][coord.getY()].videCase(robot);
		plateau.getPlateau()[newCoord.getX()][newCoord.getY()].deplaceSur(robot);
	}
}
