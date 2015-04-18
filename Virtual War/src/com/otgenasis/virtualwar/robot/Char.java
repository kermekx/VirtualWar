package com.otgenasis.virtualwar.robot;

import java.util.ArrayList;
import java.util.List;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.vue.Vue;

public class Char extends Robot {

	public List<Coordonnees> deplacements;

	public Char(Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		maxEnergie = 60;
		setEnergie(60);
	}

	@Override
	public boolean peutTirer() {
		return true;
	}

	@Override
	public int getCoutAction() {
		return 6;
	}

	@Override
	public int getCoutDep() {
		return 5;
	}

	@Override
	public int getCoutTir() {
		return 1;
	}

	@Override
	public int getCoutMine() {
		return 0;
	}

	@Override
	public String getType() {
		return "Char";
	}

	@Override
	public List<Coordonnees> getDeplacements() {
		deplacements = new ArrayList<Coordonnees>();
		for (int i = -2; i <= 2; i++)
			for (int j = -2; j <= 2; j++)
				if (((i != 0 && j == 0) || (i == 0 && j != 0))
						&& vue.canMove(getCoord().getX() + i, getCoord().getY()
								+ j))
					deplacements.add(getCoord().ajout(new Coordonnees(i, j)));
		return deplacements;
	}

}
