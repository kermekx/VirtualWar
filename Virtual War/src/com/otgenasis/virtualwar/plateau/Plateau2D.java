package com.otgenasis.virtualwar.plateau;

import com.otgenasis.virtualwar.unites.Unite;

public class Plateau2D {

	private Unite[][] map; 
	private int longueur = 10;
	private int largeur = 10;
	
	public Plateau2D(){
		map = new Unite[longueur][largeur];
	}
	
	public Plateau2D(int longueur, int largeur){
		this.setLongueur(longueur);
		this.setLargeur(largeur);
	}
	
	public Unite[][] setBases(){
		return map;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	
}
