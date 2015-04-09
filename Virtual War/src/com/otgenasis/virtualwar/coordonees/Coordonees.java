package com.otgenasis.virtualwar.coordonees;

public class Coordonees {
	
	private int x;
	private int y;
	
	public Coordonees(int x, int y) {
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

	
}
