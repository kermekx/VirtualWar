package com.otgenasis.virtualwar.plateau;

import java.util.ArrayList;
import java.util.List;

import com.otgenasis.virtualwar.robot.Robot;

public class Base extends Cellule {

	/**
	 * liste des robots dans la base
	 */
	private List<Robot> robots;

	/**
	 * cr�er une base en x, y
	 * 
	 * @param x
	 * @param y
	 */
	public Base(int x, int y) {
		super(x, y);
		robots = new ArrayList<Robot>();
	}

	/**
	 * numero de l'quipe
	 */
	private int equipe = 0;

	/**
	 * renvoie l'equipe de la base
	 * 
	 * @return numero d'�quipe
	 */
	public int getEquipe() {
		return this.equipe;
	}

	/**
	 * ajoute un robot sur la base
	 */
	@Override
	public void deplaceSur(Robot r) {
		robots.add(r);
	}

	/**
	 * change l'equipe de la base
	 */
	@Override
	public void ajoute(int equipe) {
		this.equipe = equipe;
	}

	/**
	 * retire un robot de la base
	 */
	@Override
	public void videCase(Robot r) {
		robots.remove(r);
	}

	/**
	 * renvoies toutes les unit�es dans la base
	 * 
	 * @return liste des unit�es
	 */
	public List<Robot> getUnites() {
		return robots;
	}

}
