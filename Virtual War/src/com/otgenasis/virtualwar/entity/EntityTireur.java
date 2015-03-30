package com.otgenasis.virtualwar.entity;

import com.otgenasis.virtualwar.texture.Texture;

public class EntityTireur extends EntityUnite {

	/**
	 * porté des tirs
	 */
	private double porte;

	/**
	 * cout en energie pour titre
	 */
	private int coutTirer;

	/**
	 * Créer une unité sachant tirer
	 * 
	 * @param nom de l'entité
	 * @param texture de l'entité
	 * @param energie max de l'unité
	 * @param mouvement max de l'unité
	 * @param coutMouvement de l'unité
	 * @param degatSubit de l'unité
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
	 * renvoie la porté des tirs
	 * 
	 * @return porté
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
