package com.otgenasis.virtualwar.position;

import java.awt.Point;

/**
 * position (x, y)
 * 
 * @author kevin MESSIAEN
 *
 */
public class Position {

	/**
	 * Point contenant la position x et y
	 */
	private Point point;

	/**
	 * cr�er une position � partir d'un point
	 * 
	 * @param point
	 *            contenant la position x et y
	 */
	public Position(Point point) {
		this.point = point;
	}

	/**
	 * cr�er une position � partir des coordon�es x et y
	 * 
	 * @param x
	 *            posiyion x
	 * @param y
	 *            position y
	 */
	public Position(int x, int y) {
		point = new Point(x, y);
	}

	@Override
	public String toString() {
		return "Position [point=" + point + "]";
	}

	/**
	 * revoie le point de la position
	 * 
	 * @return point de la position
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * assigne le point de la position
	 * 
	 * @param point
	 *            contenant la position x et y
	 */
	public void setPoint(Point point) {
		this.point = point;
	}

	/**
	 * revoie la coordon�e x
	 * 
	 * @return coordon�e x
	 */
	public double getX() {
		return point.getX();
	}

	/**
	 * assigne la coordon�e x
	 * 
	 * @param x
	 *            position x
	 */
	public void setX(double x) {
		point.setLocation(x, getY());
	}

	/**
	 * revoie la coordon�e y
	 * 
	 * @return coordon�e y
	 */
	public double getY() {
		return point.getY();
	}

	/**
	 * assigne la coordon�e y
	 * 
	 * @param y
	 *            position y
	 */
	public void setY(double y) {
		point.setLocation(getX(), y);
	}

	/**
	 * assigne les coordon�es x et y
	 * 
	 * @param x
	 *            position x
	 * @param y
	 *            position y
	 */
	public void setPosition(double x, double y) {
		point.setLocation(x, y);
	}

}
