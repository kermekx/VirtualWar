package com.otgenasis.virtualwar.robot;

import java.util.List;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.vue.Vue;

public class Tireur extends Robot {
	
	public List<Coordonnees> deplacements;
	
	public Tireur(Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		setEnergie(40);
	}

	@Override
	public boolean peutTirer() {
		return true;
	}

	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCoutDep() {
		return 1;
	}

	@Override
	public int getCoutTir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCoutMine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coordonnees> getDeplacements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void subitTir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subitMine() {
		// TODO Auto-generated method stub
		
	}

}
