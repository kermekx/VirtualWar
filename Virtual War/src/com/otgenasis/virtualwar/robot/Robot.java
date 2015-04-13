package com.otgenasis.virtualwar.robot;

import java.util.List;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.vue.Vue;

public abstract class Robot {

	private int energie;
	private final int equipe;
	private Coordonnees coord;
	protected Vue vue;

	public Robot(Vue vue, int x, int y, int equipe) {
		this.vue = vue;
		coord = new Coordonnees(x, y);
		this.equipe = equipe;
	}
	public boolean estSurBase() {
		return coord.equals(vue.getBase(equipe).getCoordonnees());
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public Coordonnees getCoord() {
		return coord;
	}

	public void setCoord(Coordonnees coord) {
		this.vue.move(this.coord, coord, this);
		this.coord = coord;
	}

	public int getEquipe() {
		return equipe;
	}

	public Vue getVue() {
		return vue;
	}
	
	public void setVue(Vue vue) {
		this.vue = vue;
	}

	@Override
	public String toString() {
		return "Robot [energie=" + energie + ", equipe=" + equipe + ", coord="
				+ coord + "]\n";
	}
	
	public void subitTir() {
		energie -= getCoutAction();
	}
	
	public  void subitMine() {
		energie -= getCoutAction();
	}

	public abstract boolean peutTirer();
	
	public abstract int getCoutAction();

	public abstract int getCoutDep();

	public abstract int getCoutTir();

	public abstract int getCoutMine();
	
	public abstract String getType();
	
	public abstract List<Coordonnees> getDeplacements();
	
}
