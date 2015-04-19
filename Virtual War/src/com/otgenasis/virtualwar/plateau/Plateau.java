package com.otgenasis.virtualwar.plateau;

import com.otgenasis.virtualwar.robot.Char;
import com.otgenasis.virtualwar.robot.Piegeur;
import com.otgenasis.virtualwar.robot.Tireur;
import com.otgenasis.virtualwar.vue.Vue;

public class Plateau {

	/**
	 * tableau des cellule du plateau
	 */
	Cellule[][] plateau;

	/**
	 * Créer un plateau de taille 10
	 */
	public Plateau() {
		plateau = new Cellule[10][10];
		for (int i = 0; i < plateau.length; i++)
			for (int j = 0; j < plateau[0].length; j++)
				plateau[i][j] = new Case(i, j);
		plateau[0][0] = new Base(0, 0);
		plateau[9][9] = new Base(0, 0);
		plateau[0][0].ajoute(0);
		plateau[9][9].ajoute(1);
	}

	/**
	 * Créer un tableau de taille x, y
	 * 
	 * @param longueur
	 * @param largeur
	 */
	public Plateau(int longueur, int largeur) {
		plateau = new Cellule[longueur][largeur];
		for (int i = 0; i < plateau.length; i++)
			for (int j = 0; j < plateau[0].length; j++)
				plateau[i][j] = new Case(i, j);
		plateau[0][0] = new Base(0, 0);
		plateau[longueur - 1][largeur - 1] = new Base(0, 0);
		plateau[0][0].ajoute(0);
		plateau[longueur - 1][largeur - 1].ajoute(1);
	}

	public String toString() {
		String res = "";
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				res += "[" + plateau[j].toString() + "]";
			}
			res += "\n";
		}
		return res;
	}

	/**
	 * renvoie un tableau des cellules
	 * @return cellule[][]
	 */
	public Cellule[][] getPlateau() {
		return plateau;
	}
}
