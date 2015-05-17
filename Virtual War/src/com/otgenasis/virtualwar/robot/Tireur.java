package com.otgenasis.virtualwar.robot;

import java.util.ArrayList;
import java.util.List;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.plateau.Cellule;
import com.otgenasis.virtualwar.vue.Vue;

public class Tireur extends Robot {

	/**
	 * liste des deplacement possibles
	 */
	private List<Coordonnees> deplacements;

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
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++)
				if (!(i == 0 && j == 0)
						&& vue.canMove(getCoord().getX() + i, getCoord().getY()
								+ j))
					deplacements.add(new Coordonnees(getCoord().getX() + i,
							getCoord().getY() + j));
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
					if ((difX == 0 || difY == 0) && difX <= 3 && difY <= 3) {
						boolean canShoot = true;
						for (int i = 1; i < ((difX != 0) ? difX : difY); i++) {
							if (!vue.canMove(
									getCoord().getX()
											+ ((difX == 0) ? 0
													: ((difX > 0) ? i : -i)),
									getCoord().getY()
											+ ((difY == 0) ? 0
													: ((difY > 0) ? i : -i))))
								canShoot = false;
						}
						if (canShoot)
							cibles.add(r);
					}
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
