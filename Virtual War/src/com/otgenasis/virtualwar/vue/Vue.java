package com.otgenasis.virtualwar.vue;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.plateau.Base;
import com.otgenasis.virtualwar.plateau.Case;
import com.otgenasis.virtualwar.plateau.Cellule;
import com.otgenasis.virtualwar.plateau.Plateau;

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
					vue += base.getEquipe();
				} else if (cellules[i][j] instanceof Case) {
					Case cas = (Case) cellules[i][j];
					if (cas.getContenu() != null
							&& cas.getContenu().getEquipe() == equipe)
						vue += cas.getContenu().toString().substring(0, 1);
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
					if(base.getEquipe() == equipe)
						return base.getCoordonnees();
				}
			}
		}
		return null;
	}
}
