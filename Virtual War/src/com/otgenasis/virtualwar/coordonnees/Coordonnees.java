package com.otgenasis.virtualwar.coordonnees;

public class Coordonnees {

	private int x;
	private int y;

	public Coordonnees(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Coordonees [x=" + x + ", y=" + y + "]";
	}
	
	public boolean equals(Coordonnees cord) {
		return (x == cord.x && y == cord.y);
	}

	public Coordonnees ajout(Coordonnees coord) {
		return new Coordonnees(x + coord.x, y + coord.y);
	}

}
