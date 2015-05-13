package com.otgenasis.virtualwar.plateau;

import com.otgenasis.virtualwar.robot.Robot;

public class Case extends Cellule {


	/**
	 * numero de l'equipe de la mine présente sur la case (-1 si il n'y en a
	 * pas)
	 */
	protected int mine = -1;
	
	/**
	 * est un obstacle
	 */
	protected boolean obstacle = false;
	
	/**
	 * créer une case en x, y
	 * 
	 * @param x
	 * @param y
	 */
	public Case(int x, int y) {
		super(x, y);
	}

	/**
	 * deplace un robot sur la case
	 */
	@Override
	public void deplaceSur(Robot r) {
		robot = r;
	}

	/**
	 * non utiliser, ne fait rien
	 */
	@Override
	public void ajoute(int equipe) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void setObstacle(boolean obstacle) {
		this.obstacle = obstacle;
	}

	@Override
	public boolean isObstacle() {
		return obstacle;
	}
	
	/**
	 * renvoie l'equipe qui a poser la mine, -1 si il n'y en a pas
	 * 
	 * @return -1 || equipe de la mine
	 */
	public int getMine() {
		return mine;
	}

	/**
	 * place une mine avec le numero de l'equipe ou la retirer avec -1
	 * 
	 * @param mine
	 */
	public void setMine(int mine) {
		this.mine = mine;
	}

	/**
	 * retire un robot de la case
	 */
	@Override
	public void videCase(Robot r) {
		if (robot.equals(r))
			robot = null;
	}

}
