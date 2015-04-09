package com.otgenasis.virtualwar.plateau;

public class Plateau {
	
	Cellule[][] plateau;
	
	public Plateau(){
		plateau = new Cellule[10][10];
	}
	
	public Plateau(int longueur, int largeur){
		plateau = new Cellule[longueur][largeur];
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
	
	public static void main(String[] args) {
		Plateau p = new Plateau();
		System.out.println(p.toString());
	}
}
