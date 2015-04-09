package com.otgenasis.virtualwar.action;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.robot.Char;
import com.otgenasis.virtualwar.robot.Piegeur;
import com.otgenasis.virtualwar.robot.Robot;
import com.otgenasis.virtualwar.robot.Tireur;

public class Attaque extends Action {

	public Attaque(Robot robot, Coordonnees c) {
		super(robot, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	void agit() {
		if(this.robot instanceof Tireur) {
			this.robot.setEnergie(this.robot.getEnergie()-2);
			
		} else if (this.robot instanceof Piegeur) {
			this.robot.setEnergie(this.robot.getEnergie()-2);
			
		} else if (this.robot instanceof Char) {
			this.robot.setEnergie(this.robot.getEnergie()-1);
			
		}
	}

}
