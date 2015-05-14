package com.otgenasis.virtualwar.vue;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.plateau.Base;
import com.otgenasis.virtualwar.plateau.Case;
import com.otgenasis.virtualwar.plateau.Cellule;
import com.otgenasis.virtualwar.plateau.Plateau;
import com.otgenasis.virtualwar.robot.Robot;

public class Vue {

	/***
	 * plateau de jeu
	 */
	private Plateau plateau;

	/**
	 * equipe de la vue
	 */
	private int equipe;

	/**
	 * créer la vue de l'equipe avec le plateau de jeu
	 * 
	 * @param plateau
	 * @param equipe
	 */
	public Vue(Plateau plateau, int equipe) {
		this.plateau = plateau;
		this.equipe = equipe;
	}

	/**
	 * Affichage du plateau pour l'equipe
	 */
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
					else if (cas.getMine() == equipe)
						vue += "X";
					else
						vue += " ";
				} else
					vue += " ";
				vue += "]";
			}
			vue += "\n";
		}

		vue += "\nBase :\n" + getBase(equipe).getUnites().toString() + "\n";

		for (int i = 0; i < cellules.length; i++) {
			for (int j = 0; j < cellules[0].length; j++) {
				if (cellules[i][j] instanceof Case) {
					Case cas = (Case) cellules[i][j];
					if (cas.getContenu() != null
							&& cas.getContenu().getEquipe() == equipe)
						vue += cas.getContenu();
				}
			}
		}

		return vue;
	}

	/**
	 * renvoie la base de l'equipe
	 * 
	 * @param equipe
	 * @return base
	 */
	public Base getBase(int equipe) {
		Cellule[][] cellules = plateau.getPlateau();
		for (int i = 0; i < cellules.length; i++) {
			for (int j = 0; j < cellules[0].length; j++) {
				if (cellules[i][j] instanceof Base) {
					Base base = (Base) cellules[i][j];
					if (base.getEquipe() == equipe)
						return base;
				}
			}
		}
		return null;
	}

	/**
	 * renvoie le robot de la position
	 * 
	 * @param coord
	 * @return robot
	 */
	public Robot getUnite(Coordonnees coord) {
		Cellule cellule = plateau.getPlateau()[coord.getX()][coord.getY()];
		if (cellule instanceof Case) {
			Case vCase = (Case) cellule;
			return vCase.getContenu();
		}
		return null;
	}

	/**
	 * bouge le robot present a une autre position
	 * 
	 * @param coord
	 * @param newCoord
	 * @param robot
	 */
	public void move(Coordonnees coord, Coordonnees newCoord, Robot robot) {
		plateau.getPlateau()[coord.getX()][coord.getY()].videCase(robot);
		if (plateau.getPlateau()[newCoord.getX()][newCoord.getY()] instanceof Case) {
			if (((Case) plateau.getPlateau()[newCoord.getX()][newCoord.getY()])
					.getMine() != -1) {
				robot.setEnergie(robot.getEnergie() - robot.getCoutAction());
				((Case) plateau.getPlateau()[newCoord.getX()][newCoord.getY()])
						.setMine(-1);
			}
		}
		plateau.getPlateau()[newCoord.getX()][newCoord.getY()]
				.deplaceSur(robot);
	}

	/**
	 * tue le robot prensent a la position
	 * 
	 * @param robot
	 * @param coord
	 */
	public void kill(Robot robot, Coordonnees coord) {
		plateau.getPlateau()[coord.getX()][coord.getY()].videCase(robot);
	}

	/**
	 * renvoie si le robot peut se deplacer a la position demander
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean canMove(int i, int j) {
		if (i >= 0 && j >= 0 && i < plateau.getPlateau().length
				&& j < plateau.getPlateau()[0].length) {
			if (plateau.getPlateau()[i][j] instanceof Base)
				return (((Base) plateau.getPlateau()[i][j]).getEquipe() == equipe);
			else
				return (plateau.getPlateau()[i][j].getContenu() == null && !plateau
						.getPlateau()[i][j].isObstacle());
		}
		return false;
	}

	/**
	 * renvoie un robot en fonction de l'id
	 * 
	 * @param parseInt
	 * @return
	 */
	public Robot getRobot(int parseInt) {
		if (getBase(equipe).getUnites().size() > parseInt)
			return getBase(equipe).getUnites().get(parseInt);
		else
			parseInt -= getBase(equipe).getUnites().size();

		Cellule[][] cellules = plateau.getPlateau();

		for (int i = 0; i < cellules.length; i++) {
			for (int j = 0; j < cellules[0].length; j++) {
				if (cellules[i][j] instanceof Case) {
					Case cas = (Case) cellules[i][j];
					if (cas.getContenu() != null
							&& cas.getContenu().getEquipe() == equipe) {
						if (parseInt == 0)
							return cas.getContenu();
						else
							parseInt--;
					}
				}
			}
		}
		return null;
	}

	/**
	 * renvoie si l'equipe a au moins 1 robot hors de la base
	 * 
	 * @return boolean
	 */
	public boolean hasRobotOutOfBase() {
		Cellule[][] cellules = plateau.getPlateau();
		for (int i = 0; i < cellules.length; i++) {
			for (int j = 0; j < cellules[0].length; j++) {
				if (cellules[i][j] instanceof Case) {
					Case cas = (Case) cellules[i][j];
					if (cas.getContenu() != null
							&& cas.getContenu().getEquipe() == equipe) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * rajoute 2 energies aux robot hors de la base
	 */
	public void heal() {
		for (Robot robot : (getBase(equipe).getUnites())) {
			robot.setEnergie(robot.getEnergie() + 2);
			robot.setMines(10);
		}
	}

	/**
	 * pose une mine en coordonnees
	 * 
	 * @param coordonnees
	 * @return mine êut etre poser
	 */
	public boolean mine(Coordonnees coordonnees) {
		if (!canMove(coordonnees.getX(), coordonnees.getY())
				|| plateau.getPlateau()[coordonnees.getX()][coordonnees.getY()] instanceof Base)
			return false;
		((Case) plateau.getPlateau()[coordonnees.getX()][coordonnees.getY()])
				.setMine(equipe);
		return true;
	}

	public int getEquipe() {
		return equipe;
	}

	public Plateau getPlateau() {
		return plateau;
	}
}
