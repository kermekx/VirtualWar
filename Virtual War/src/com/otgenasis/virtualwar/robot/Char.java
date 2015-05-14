package com.otgenasis.virtualwar.robot;

import java.util.ArrayList;
import java.util.List;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.plateau.Cellule;
import com.otgenasis.virtualwar.vue.Vue;

public class Char extends Robot {

	/**
	 * liste des deplacement possibles
	 */
	private List<Coordonnees> deplacements;

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
		List<Coordonnees> dep = new ArrayList<Coordonnees>();
		deplacements = new ArrayList<Coordonnees>();
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++)
				if (((i != 0 && j == 0) || (i == 0 && j != 0))
						&& vue.canMove(getCoord().getX() + i, getCoord().getY()
								+ j))
					dep.add(new Coordonnees(i, j));

		for (Coordonnees c : dep) {
			deplacements.add(new Coordonnees(getCoord().getX() + c.getX(),
					getCoord().getY() + c.getY()));

			if (vue.canMove(getCoord().getX() + c.getX() * 2, getCoord().getY()
					+ c.getY() * 2))
				deplacements.add(new Coordonnees(getCoord().getX() + c.getX()
						* 2, getCoord().getY() + c.getY() * 2));
		}

		return deplacements;
	}

	@Override
	public List<Robot> getCibles() {
		Cellule[][] cellules = vue.getPlateau().getPlateau();

		List<Robot> cibles = new ArrayList<Robot>();

		for (Cellule[] cellulesX : cellules) {
			for (Cellule cellule : cellulesX) {
				Robot r = cellule.getContenu();
				if (r != null && r.getEquipe() != this.getEquipe()) {
					int difX = Math.abs(r.getCoord().getX()
							- this.getCoord().getX());
					int difY = Math.abs(r.getCoord().getY()
							- this.getCoord().getY());
					if ((difX == 0 || difY == 0) && difX <= 10 && difY <= 10)
						cibles.add(r);
				}
			}
		}

		return cibles;
	}

	@Override
	public List<Coordonnees> getPosMines() {
		// TODO Auto-generated method stub
		return null;
	}

}
