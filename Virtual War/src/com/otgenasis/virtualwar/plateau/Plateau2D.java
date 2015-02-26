package com.otgenasis.virtualwar.plateau;

<<<<<<< HEAD
import com.otganasis.virtualwar.unites.Base;
import com.otganasis.virtualwar.unites.Tireur;
import com.otganasis.virtualwar.unites.Unite;
=======
import com.otgenasis.virtualwar.unites.Unite;
>>>>>>> origin/master

public class Plateau2D {

	private Unite[][] map; 
	private int longueur = 10;
	private int largeur = 15;
	
	public Plateau2D(){
		map = new Unite[longueur][largeur];
	}
	
	public Plateau2D(int longueur, int largeur){
		this.setLongueur(longueur);
		this.setLargeur(largeur);
	}
	
	public Unite[][] setBases(Unite[] t1, Unite[] t2){
		Base u1 = new Base(10, 10, 10);
		Base u2 = new Base(10, 10, 10);
		u1.setUnites(t1);
		u2.setUnites(t2);
		map[0][0] = u1;
		map[map.length-1][map[0].length-1] = u2;
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
	
	public String toString(){
		String str = "";
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				str = str + "["+ map[i][j] + "]";
			}
			str = str + "\n";
		}
		return str;
	}
}
