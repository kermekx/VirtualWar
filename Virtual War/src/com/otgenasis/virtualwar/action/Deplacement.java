package com.otgenasis.virtualwar.action;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.robot.Robot;

public class Deplacement extends Action {
	
	public Deplacement(Robot robot, Coordonnees c) {
		super(robot, c);
	}

	@Override
	public boolean agit() {
		if (this.robot.setCoord(this.getDirection())) {
			robot.setEnergie(robot.getEnergie() - robot.getCoutDep());
			return true;
		}
		return false;
	}

}
