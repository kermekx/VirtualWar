package com.otganasis.virtualwar.unites;

public abstract class Unite {

	protected int ID;
	protected int PV;
	protected int armure;
	protected int positionX;
	protected int positionY;

	public String getPosition(){
		return "[" + positionX + "][" + positionY + "]";
	}

	public void setPosition(int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public String toString() {
		/*String str = "Je suis une unite de type " + this.getClass().getName() + ", j'ai "
				+ this.PV + " points de vie, une portée de " + this.portee
				+ " avec des degats de " + this.degats + " et une armure de "
				+ this.armure + ".";*/
		return "" + this.getClass().getSimpleName();
	}
}
