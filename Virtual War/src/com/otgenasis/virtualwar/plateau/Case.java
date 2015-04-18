package com.otgenasis.virtualwar.plateau;

import com.otgenasis.virtualwar.robot.Robot;

public class Case extends Cellule {
	
	private int mine = -1;
	
	public Case(int x, int y) {
		super(x, y);
	}

	@Override
	public void deplaceSur(Robot r) {
		robot = r;
	}

	@Override
	public void ajoute(int equipe) {
		// TODO Auto-generated method stub
		
	}
	
	public int getMine() {
		return mine;
	}
	
	public void setMine(int mine) {
		this.mine = mine;
	}

	@Override
	public void videCase(Robot r) {
		if(robot.equals(r))
			robot = null;
	}

}
