package com.otgenasis.virtualwar.robot;

import java.util.List;

import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.vue.Vue;

public abstract class Robot {

	/**
	 * incremention de l'id des robots
	 */
	private static int count;

	/**
	 * eznergie du robot
	 */
	private int energie;
	/**
	 * energie max du robot
	 */
	protected int maxEnergie;
	/**
	 * equipe du robot
	 */
	private final int equipe;
	/**
	 * position du robot
	 */
	private Coordonnees coord;
	/**
	 * vue de l'equipe du robot
	 */
	protected Vue vue;

	/**
	 * créer un robot en x, y de l'equipe i avec la vue corespondante
	 * 
	 * @param vue
	 * @param x
	 * @param y
	 * @param equipe
	 */
	public Robot(Vue vue, int x, int y, int equipe) {
		this.vue = vue;
		coord = new Coordonnees(x, y);
		this.equipe = equipe;
	}

	/**
	 * renvoie si le robot est dans la base
	 * 
	 * @return boolean
	 */
	public boolean estSurBase() {
		return coord.equals(vue.getBase(equipe).getCoordonnees());
	}

	/**
	 * renvoie l'energie du robot
	 * 
	 * @return energie
	 */
	public int getEnergie() {
		return energie;
	}

	/**
	 * modifie l'energie du robot et le tue en cas de besoin
	 * 
	 * @param energie
	 */
	public void setEnergie(int energie) {
		this.energie = energie;
		if (this.energie <= 0) {
			this.vue.kill(this, this.coord);
		}
		this.energie = (this.energie > maxEnergie) ? maxEnergie : energie;
	}

	/**
	 * renvoie les coordonnees du robot
	 * 
	 * @return coordonnees
	 */
	public Coordonnees getCoord() {
		return coord;
	}

	/**
	 * modifie la position du robot
	 * 
	 * @param coord
	 * @return si c'est possible
	 */
	public boolean setCoord(Coordonnees coord) {
		if (this.getDeplacements().contains(coord)) {
			this.vue.move(this.coord, coord, this);
			this.coord = coord;
			return true;
		}
		return false;
	}

	/**
	 * renvoie l'equipe du robot
	 * 
	 * @return numero de l'equipe
	 */
	public int getEquipe() {
		return equipe;
	}

	/**
	 * renvoie la vue de l'equyipe du robot
	 * 
	 * @return vue de l'equipe
	 */
	public Vue getVue() {
		return vue;
	}

	/**
	 * 
	 * change la vue du robot
	 * 
	 * @param vue
	 *            nouvelle vue
	 */
	public void setVue(Vue vue) {
		this.vue = vue;
	}

	@Override
	public String toString() {
		count();
		return getType() + "[energie=" + energie + ", " + coord + "]";
	}

	/**
	 * le robot subbit un tir
	 */
	public void subitTir() {
		energie -= getCoutAction();
		if (energie <= 0) {
			this.vue.kill(this, this.coord);
		}
	}

	/**
	 * Le robot subit des mines
	 */
	public void subitMine() {
		energie -= getCoutAction();
		if (energie <= 0) {
			this.vue.kill(this, this.coord);
		}
	}

	/**
	 * le robot peut-il tirer
	 * 
	 * @return boolean
	 */
	public abstract boolean peutTirer();

	/**
	 * cout des degat (mine/tir)
	 * 
	 * @return cout
	 */
	public abstract int getCoutAction();

	/**
	 * cout des mouvements
	 * 
	 * @return cout
	 */
	public abstract int getCoutDep();

	/**
	 * cout des tirs
	 * 
	 * @return cout
	 */
	public abstract int getCoutTir();

	/**
	 * cout des poses de mine
	 * 
	 * @return cout
	 */
	public abstract int getCoutMine();

	/**
	 * type du robot
	 * 
	 * @return nom
	 */
	public abstract String getType();

	/**
	 * deplacements possibles
	 * 
	 * @return liste de coordonnees
	 */
	public abstract List<Coordonnees> getDeplacements();

	public static void setCount() {
		count = 0;
	}

	public static void count() {
		count++;
	}

}
