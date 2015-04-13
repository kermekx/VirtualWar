package com.otgenasis.virtualwar.action;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.robot.Robot;

public abstract class Action {

	Robot robot;
	Coordonnees c;
	
	public Action(Robot robot,  Coordonnees c){
		this.robot = robot;
		this.c = c;
	}
	
	public Robot getRobot(){
		return robot;
	}
	
	public Coordonnees getDirection(){
		return c;	
	}
	
	public Coordonnees getObjectif(){
		return c;
	}
	
	abstract void agit();
	
}
