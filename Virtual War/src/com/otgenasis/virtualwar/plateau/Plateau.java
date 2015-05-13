package com.otgenasis.virtualwar.plateau;

import java.awt.Point;
import java.util.Random;

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

	public Plateau(int largeur, int hauteur, int obstacles) {
		plateau = new Cellule[largeur][hauteur];
		for (int i = 0; i < plateau.length; i++)
			for (int j = 0; j < plateau[0].length; j++)
				plateau[i][j] = new Case(i, j);
		plateau[0][0] = new Base(0, 0);
		plateau[largeur - 1][hauteur - 1] = new Base(0, 0);
		plateau[0][0].ajoute(0);
		plateau[largeur - 1][hauteur - 1].ajoute(1);

		int nbrObtacle = largeur * hauteur * obstacles / 100;
		nbrObtacle = (nbrObtacle > (largeur * hauteur)
				- (2 * largeur + 2 * hauteur) + 4) ? (largeur * hauteur)
				- (2 * largeur + 2 * hauteur) + 4 : nbrObtacle;
		
		int i = 0;
		Random r = new Random();
		while (i < nbrObtacle) {
			Point p = new Point(r.nextInt(largeur), r.nextInt(hauteur));
			if (p.x != 0 && p.x != largeur - 1 && p.y != 0 && p.y != hauteur - 1 && !plateau[p.x][p.y].isObstacle()) {
				plateau[p.x][p.y].setObstacle(true);
				i ++;
			}
				
		}
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
	 * 
	 * @return cellule[][]
	 */
	public Cellule[][] getPlateau() {
		return plateau;
	}
}
