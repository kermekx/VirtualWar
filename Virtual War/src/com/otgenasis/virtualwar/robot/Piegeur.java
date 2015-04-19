package com.otgenasis.virtualwar.robot;

import java.util.ArrayList;
import java.util.List;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.vue.Vue;

public class Piegeur extends Robot {

	/**
	 * liste des deplacement possibles
	 */
	private List<Coordonnees> deplacements;

	public Piegeur(Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		maxEnergie = 50;
		setEnergie(50);
	}

	@Override
	public boolean peutTirer() {
		return false;
	}

	@Override
	public int getCoutAction() {
		return 2;
	}

	@Override
	public int getCoutDep() {
		return 1;
	}

	@Override
	public int getCoutTir() {
		return 0;
	}

	@Override
	public int getCoutMine() {
		return 2;
	}

	@Override
	public String getType() {
		return "Piegeur";
	}

	@Override
	public List<Coordonnees> getDeplacements() {
		deplacements = new ArrayList<Coordonnees>();
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++)
				if (!(i == 0 && j == 0)
						&& vue.canMove(getCoord().getX() + i, getCoord().getY()
								+ j))
					deplacements.add(getCoord().ajout(new Coordonnees(i, j)));
		return deplacements;
	}

}
