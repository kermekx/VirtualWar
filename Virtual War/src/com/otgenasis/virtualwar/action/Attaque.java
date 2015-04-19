package com.otgenasis.virtualwar.action;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.robot.Robot;

public class Attaque extends Action {

	/**
	 * crée l'action de type attaque (ne la fait pas)
	 * 
	 * @param robot
	 *            robot qui doit attaquer
	 * @param c
	 *            position de la cible
	 */
	public Attaque(Robot robot, Coordonnees c) {
		super(robot, c);
	}

	/**
	 * le robot attaque
	 */
	@Override
	public boolean agit() {
		robot.setEnergie(robot.getEnergie() - robot.getCoutTir());
		if (robot.peutTirer() && !robot.estSurBase()
				&& robot.getVue().getUnite(c) != null) {
			Robot enemy = robot.getVue().getUnite(c);
			enemy.setEnergie(enemy.getEnergie() - enemy.getCoutAction());
			return true;
		}
		return false;
	}

}
