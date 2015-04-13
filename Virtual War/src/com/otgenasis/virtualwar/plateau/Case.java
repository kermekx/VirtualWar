package com.otgenasis.virtualwar.plateau;

import com.otgenasis.virtualwar.robot.Robot;

public class Case extends Cellule {
	
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

	@Override
	public void videCase(Robot r) {
		if(robot.equals(r))
			robot = null;
	}

}
