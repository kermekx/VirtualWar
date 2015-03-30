package com.otgenasis.virtualwar.entity;

import com.otgenasis.virtualwar.position.Position;

public class Unite {
	
	/**
	 * type de l'unite
	 */
	private EntityUnite unite;
	
	/**
	 * energie de l'unité
	 */
	private int energie;
	
	//private Equipe equipe;
	
	/**
	 * position de l'unité
	 */
	private Position position;
	
	public Unite(EntityUnite unite/**, Equipe equipe*/) {
		this.unite = unite;
		energie = unite.getEnergie();
		//this.equipe = equipe;
		//position = equipe.getBase().getPosition;
	}
	
	public void soigner(int soin) {
		energie += soin;
		
		if (energie > getMaxEnergie())
			energie = getMaxEnergie();
	}
	
	public EntityUnite getUnite() {
		return unite;
	}
	
	public int getEnergie() {
		return energie;
	}
	
	public int getMaxEnergie() {
		return unite.getEnergie();
	}
	
	public Position getPosition() {
		return position;
	}

}
