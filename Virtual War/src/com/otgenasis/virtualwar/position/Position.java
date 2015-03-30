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
	 * créer une position à partir d'un point
	 * 
	 * @param point
	 *            contenant la position x et y
	 */
	public Position(Point point) {
		this.point = point;
	}

	/**
	 * créer une position à partir des coordonées x et y
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
	 * revoie la coordonée x
	 * 
	 * @return coordonée x
	 */
	public double getX() {
		return point.getX();
	}

	/**
	 * assigne la coordonée x
	 * 
	 * @param x
	 *            position x
	 */
	public void setX(double x) {
		point.setLocation(x, getY());
	}

	/**
	 * revoie la coordonée y
	 * 
	 * @return coordonée y
	 */
	public double getY() {
		return point.getY();
	}

	/**
	 * assigne la coordonée y
	 * 
	 * @param y
	 *            position y
	 */
	public void setY(double y) {
		point.setLocation(getX(), y);
	}

	/**
	 * assigne les coordonées x et y
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
