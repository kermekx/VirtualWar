package com.otgenasis.virtualwar.plateau;

import com.otgenasis.virtualwar.robot.Char;
import com.otgenasis.virtualwar.robot.Piegeur;
import com.otgenasis.virtualwar.robot.Tireur;
import com.otgenasis.virtualwar.vue.Vue;

public class Plateau {
	
	Cellule[][] plateau;
	
	public Plateau(){
		plateau = new Cellule[10][10];
		for (int i = 0; i < plateau.length; i++)
			for (int j = 0; j < plateau[0].length; j++)
				plateau[i][j] = new Case(i, j);
		plateau[0][0] = new Base(0, 0);
		plateau[9][9] = new Base(0, 0);
		plateau[0][0].ajoute(1);
		plateau[9][9].ajoute(2);
	}
	
	public Plateau(int longueur, int largeur){
		plateau = new Cellule[longueur][largeur];
		for (int i = 0; i < plateau.length; i++)
			for (int j = 0; j < plateau[0].length; j++)
				plateau[i][j] = new Case(i, j);
		plateau[0][0] = new Base(0, 0);
		plateau[longueur-1][largeur-1] = new Base(0, 0);
		plateau[0][0].ajoute(1);
		plateau[longueur-1][largeur-1].ajoute(2);
	}
	
	public String toString(){
		String res = "";
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				res += "[" + plateau[j].toString() + "]";
			}
			res += "\n";
		}
		return res;
	}
	
	public Cellule[][] getPlateau() {
		return plateau;
	}
	
	public static void main(String[] args) {
		Plateau p = new Plateau();
		Vue vue = new Vue(p, 1);
		p.getPlateau()[3][3].deplaceSur(new Tireur(vue, 3, 3, 1));
		p.getPlateau()[4][4].deplaceSur(new Tireur(vue, 4, 4, 2));
		p.getPlateau()[4][3].deplaceSur(new Piegeur(vue, 4, 3, 1));
		p.getPlateau()[5][4].deplaceSur(new Piegeur(vue, 5, 4, 2));
		p.getPlateau()[8][3].deplaceSur(new Char(vue, 8, 3, 1));
		p.getPlateau()[8][4].deplaceSur(new Char(vue, 9, 4, 2));
		System.out.println(vue.toString());
	}
}
