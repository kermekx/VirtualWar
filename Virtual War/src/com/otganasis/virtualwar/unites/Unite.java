package com.otganasis.virtualwar.unites;

public abstract class Unite {

	protected int ID;
	protected int PV;
	protected int portee;
	protected int degats;
	protected int armure;

	abstract void deplacement();

	abstract void crier();

	abstract void danser();

	public String toString() {
		String str = "Je suis une unite de type " + this.getClass().getName() + ", j'ai "
				+ this.PV + " points de vie, une portée de " + this.portee
				+ " avec des degats de " + this.degats + " et une armure de "
				+ this.armure + ".";
		return str;
	}
}
