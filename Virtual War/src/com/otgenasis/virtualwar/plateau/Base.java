package com.otgenasis.virtualwar.plateau;

public class Base extends Cellule {
	
	private int equipe = 0;
	
	public int getEquipe(){
		return this.equipe;
	}
	
	@Override
	void deplaceSur(Robot r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void ajoute(int equipe) {
		this.equipe = equipe;
	}

	@Override
	void videCase(Robot r) {
		// TODO Auto-generated method stub
		
	}

}
