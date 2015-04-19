package com.otgenasis.virtualwar.plateau;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.robot.Robot;

public abstract class Cellule {

	/**
	 * coordonnees de la cellule
	 */
	private Coordonnees c;

	/**
	 * robot sur la case
	 */
	protected Robot robot;

	/**
	 * Créer une cellule en x, y
	 * 
	 * @param x
	 * @param y
	 */
	public Cellule(int x, int y) {
		c = new Coordonnees(x, y);
	}

	/**
	 * renvoie la position de la cellule
	 * 
	 * @return coordonnees de la cellule
	 */
	public Coordonnees getCoordonnees() {
		return this.c;
	}

	/**
	 * renvoie le robot présent sur la cellule
	 * @return robot
	 */
	public Robot getContenu() {
		return robot;
	}

	public String toString() {
		return "Cellule aux coordonnees (" + c.getX() + "," + c.getY() + ")";
	}

	public abstract void deplaceSur(Robot r);

	public abstract void ajoute(int equipe);

	public abstract void videCase(Robot r);

}
