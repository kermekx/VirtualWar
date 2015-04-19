package com.otgenasis.virtualwar.action;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.robot.Robot;

public abstract class Action {

	/**
	 * Robot qui doit agir
	 */
	Robot robot;
	
	/**
	 * lieu de l'action
	 */
	Coordonnees c;
	
	/**
	 * crée l'action (ne la fait pas)
	 * @param robot robot qui doit agir
	 * @param c lieu de l'action
	 */
	public Action(Robot robot,  Coordonnees c){
		this.robot = robot;
		this.c = c;
	}
	
	/**
	 * renvoie le robot de l'action
	 * @return robot
	 */
	public Robot getRobot(){
		return robot;
	}
	
	/**
	 * TODO
	 * renvoie la direction
	 * @return direction
	 */
	public Coordonnees getDirection(){
		return c;	
	}
	
	/**
	 * renvoie la lieu de l'action
	 * @return position
	 */
	public Coordonnees getObjectif(){
		return c;
	}
	
	/**
	 * le robot agit
	 * @return succes de l'action
	 */
	public abstract boolean agit();
	
}
