package com.otgenasis.virtualwar.coordonnees;

public class Coordonnees {

	/**
	 * position verticale (gauche à droite)
	 */
	private int x;
	/**
	 * position horizontale (haut en bas)
	 */
	private int y;

	/**
	 * créer une position x, y
	 * 
	 * @param x
	 * @param y
	 */
	public Coordonnees(int y, int x) {
		this.x = x;
		this.y = y;
	}

	/**
	 * position verticale
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * position horizontale
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * renvoie les coordonnées
	 */
	@Override
	public String toString() {
		return "Coordonees [x=" + x + ", y=" + y + "]";
	}

	/**
	 * renvoie si les positions sont identiques
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Coordonnees))
			return false;

		Coordonnees coord = (Coordonnees) obj;
		return (x == coord.x && y == coord.y);
	}

	/**
	 * additionne les coordonnées
	 * 
	 * @param coord
	 * @return
	 */
	public Coordonnees ajout(Coordonnees coord) {
		return new Coordonnees(x + coord.x, y + coord.y);
	}

}
