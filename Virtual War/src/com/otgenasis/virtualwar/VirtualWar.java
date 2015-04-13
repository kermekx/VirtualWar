package com.otgenasis.virtualwar;

import java.util.ArrayList;
import java.util.List;

import com.otgenasis.virtualwar.plateau.Plateau;
import com.otgenasis.virtualwar.robot.Char;
import com.otgenasis.virtualwar.robot.Piegeur;
import com.otgenasis.virtualwar.robot.Tireur;
import com.otgenasis.virtualwar.vue.Vue;

public class VirtualWar {
	
	public static String INFO = "T : tireur alie  | y : tireur enemie\n"
							  + "P : piegeur alie | p : piegeur enemie\n"
							  + "C : char alie    | c : char enemi\n"
							  + "B : Base alie    | b : base enemi\n"
							  + "X : mine alie    | (invisible) : mine enemi\n";
	
	private List<Vue> vues;
	private Plateau plateau;
	private int joueur;
	
	public static void main(String[] args) {
		VirtualWar vw = new VirtualWar();
		while (!vw.finished())
			vw.turn();
	}

	public VirtualWar() {
		vues = new ArrayList<Vue>();
		plateau = new Plateau();
		vues.add(new Vue(plateau, 0));
		vues.add(new Vue(plateau, 1));
		plateau.getPlateau()[0][0].deplaceSur(new Tireur(vues.get(0), 0, 0, 0));
		plateau.getPlateau()[0][0].deplaceSur(new Tireur(vues.get(0), 0, 0, 0));
		plateau.getPlateau()[0][0].deplaceSur(new Piegeur(vues.get(0), 0, 0, 0));
		plateau.getPlateau()[0][0].deplaceSur(new Char(vues.get(0), 0, 0, 0));
		plateau.getPlateau()[0][0].deplaceSur(new Char(vues.get(0), 0, 0, 0));
		plateau.getPlateau()[9][9].deplaceSur(new Tireur(vues.get(1), 9, 9, 1));
		plateau.getPlateau()[9][9].deplaceSur(new Tireur(vues.get(1), 9, 9, 1));
		plateau.getPlateau()[9][9].deplaceSur(new Piegeur(vues.get(1), 9, 9, 1));
		plateau.getPlateau()[9][9].deplaceSur(new Char(vues.get(1), 9, 9, 1));
		plateau.getPlateau()[9][9].deplaceSur(new Char(vues.get(1), 9, 9, 1));
		joueur = 0;
	}
	
	@Override
	public String toString() {
		return "Joueur : " + joueur + "\n\n"
				+ INFO + "\n\n" + vues.get(joueur);
	}
	
	private void turn() {
		System.out.println(this);
		joueur = (joueur + 1) % 2;
	}

	private boolean finished() {
		return false;
	}
	

}
