package com.otgenasis.virtualwar.entity;

import com.otgenasis.virtualwar.texture.Texture;

public class EntityTireur extends EntityUnite {

	/**
	 * port� des tirs
	 */
	private double porte;

	/**
	 * cout en energie pour titre
	 */
	private int coutTirer;

	/**
	 * Cr�er une unit� sachant tirer
	 * 
	 * @param nom de l'entit�
	 * @param texture de l'entit�
	 * @param energie max de l'unit�
	 * @param mouvement max de l'unit�
	 * @param coutMouvement de l'unit�
	 * @param degatSubit de l'unit�
	 * @param porte max du tireur
	 * @param coutTirer du tireur
	 */
	public EntityTireur(String nom, Texture texture, int energie, double mouvement,
			int coutMouvement, int degatSubit, double porte, int coutTirer) {
		super(nom, texture, energie, mouvement, coutMouvement, degatSubit);
		this.porte = porte;
		this.coutTirer = coutTirer;
	}

	/**
	 * renvoie la port� des tirs
	 * 
	 * @return port�
	 */
	public double getPorte() {
		return porte;
	}

	/**
	 * renvoie le cout des tirs
	 * 
	 * @return cout des tirs
	 */
	public int getCoutTirer() {
		return coutTirer;
	}

}
