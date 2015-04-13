package com.otgenasis.virtualwar.action;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.robot.Robot;

public class Deplacement extends Action {
	
	public Deplacement(Robot robot, Coordonnees c) {
		super(robot, c);
	}

	@Override
	public
	void agit() {
		this.robot.setCoord(this.getDirection());
	}

}
