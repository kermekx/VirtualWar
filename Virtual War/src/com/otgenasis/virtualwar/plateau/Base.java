package com.otgenasis.virtualwar.plateau;

import java.util.ArrayList;
import java.util.List;

import com.otgenasis.virtualwar.robot.Robot;

public class Base extends Cellule {
	
	private List<Robot> robots;
	public Base(int x, int y) {
		super(x, y);
		robots = new ArrayList<Robot>();
	}

	private int equipe = 0;
	
	public int getEquipe(){
		return this.equipe;
	}
	
	@Override
	public void deplaceSur(Robot r) {
		robots.add(r);
	}

	@Override
	public void ajoute(int equipe) {
		this.equipe = equipe;
	}

	@Override
	public void videCase(Robot r) {
		robots.remove(r);
	}

	public List<Robot> getUnites() {
		return robots;
	}

}
