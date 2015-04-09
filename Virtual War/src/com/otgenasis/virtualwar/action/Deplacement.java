package com.otgenasis.virtualwar.action;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.robot.Robot;
import com.otgenasis.virtualwar.robot.Tireur;

public class Deplacement extends Action {
	
	public Deplacement(Robot robot, Coordonnees c) {
		super(robot, c);
	}

	@Override
	void agit() {
		this.robot.setCoord(this.getDirection());
	}

}
