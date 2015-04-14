package com.otgenasis.virtualwar.action;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.robot.Robot;

public class Attaque extends Action {

	public Attaque(Robot robot, Coordonnees c) {
		super(robot, c);
	}

	@Override
	public boolean agit() {
		robot.setEnergie(robot.getEnergie() - robot.getCoutTir());
		if(robot.peutTirer() && !robot.estSurBase() && robot.getVue().getUnite(c) != null) {
			Robot enemy = robot.getVue().getUnite(c);
			enemy.setEnergie(enemy.getEnergie() - enemy.getCoutAction());
			return true;
		}
		return false;
	}

}
