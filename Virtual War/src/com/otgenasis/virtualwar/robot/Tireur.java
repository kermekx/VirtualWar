package com.otgenasis.virtualwar.robot;

import java.util.ArrayList;
import java.util.List;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.vue.Vue;

public class Tireur extends Robot {
	
	public List<Coordonnees> deplacements;
	
	public Tireur(Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		maxEnergie = 40;
		setEnergie(40);
	}

	@Override
	public boolean peutTirer() {
		return true;
	}

	@Override
	public int getCoutAction() {
		return 3;
	}

	@Override
	public int getCoutDep() {
		return 1;
	}

	@Override
	public int getCoutTir() {
		return 2;
	}

	@Override
	public int getCoutMine() {
		return 0;
	}

	@Override
	public String getType() {
		return "Tireur";
	}

	@Override
	public List<Coordonnees> getDeplacements() {
		deplacements = new ArrayList<Coordonnees>();
		for(int i = -1; i <= 1; i++)
			for(int j = -1; j <= 1; j++)
				if(!(i == 0 && j == 0))
					deplacements.add(getCoord().ajout(new Coordonnees(i, j)));
		return deplacements;
	}

}
