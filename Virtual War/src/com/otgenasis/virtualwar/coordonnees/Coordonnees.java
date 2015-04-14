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
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Coordonnees))
			return false;
		
		Coordonnees coord = (Coordonnees) obj;
		System.out.println("" + x + coord.x + y + coord.y);
		return (x == coord.x && y == coord.y);
	}

	public Coordonnees ajout(Coordonnees coord) {
		return new Coordonnees(x + coord.x, y + coord.y);
	}

}
