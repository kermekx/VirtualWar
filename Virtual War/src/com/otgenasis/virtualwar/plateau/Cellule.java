package com.otgenasis.virtualwar.plateau;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.robot.Robot;

public abstract class Cellule {

	protected int mine = 0;
	protected int base = 0;
	String image;
	Coordonnees c;
	protected Robot robot;
	
	public Cellule(int x, int y){
		c = new Coordonnees(x, y);
	}
	
	public int contientMine(){
		return this.mine > 0 ? 1 : 0;
	}
	
	public int estBase(){
		return this.base > 0 ? 1 : 0;
	}
	
	public Coordonnees getCoordonnees(){
		return this.c;
	}
	
	public Robot getContenu(){
		return robot;
	}
	
	public String toString(){
		return "Cellule aux coordonnees (" + c.getX() + "," + c.getY() + ")";
	}
	
	public abstract void deplaceSur(Robot r);
	public abstract void ajoute(int equipe);
	public abstract void videCase(Robot r);
	
}
