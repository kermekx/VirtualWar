package com.otgenasis.virtualwar.action;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.robot.Robot;

public class Deplacement extends Action {

	/**
	 * Cr�e une action de type deplacement (ne la fait pas)
	 * 
	 * @param robot
	 *            qui doit ce deplacer
	 * @param c
	 *            position voulue
	 */
	public Deplacement(Robot robot, Coordonnees c) {
		super(robot, c);
	}

	/**
	 * d�place le robot
	 */
	@Override
	public boolean agit() {
		if (this.robot.setCoord(this.getDirection())) {
			robot.setEnergie(robot.getEnergie() - robot.getCoutDep());
			return true;
		}
		return false;
	}

}
