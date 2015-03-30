package com.otgenasis.virtualwar.entity;

import com.otgenasis.virtualwar.texture.Texture;

public class EntityPiegeur extends EntityUnite {

	/**
	 * porté des tirs
	 */
	private double porte;

	/**
	 * cout en energie pour titre
	 */
	private int coutPieger;

	/**
	 * Créer une unité sachant tirer
	 * 
	 * @param nom de l'entité
	 * @param texture de l'entité
	 * @param energie max de l'unité
	 * @param mouvement max de l'unité
	 * @param coutMouvement de l'unité
	 * @param degatSubit de l'unité
	 * @param porte max du piegeur
	 * @param coutPieger du piegeur
	 */
	public EntityPiegeur(String nom, Texture texture, int energie, double mouvement,
			int coutMouvement, int degatSubit, double porte, int coutPieger) {
		super(nom, texture, energie, mouvement, coutMouvement, degatSubit);
		this.porte = porte;
		this.coutPieger = coutPieger;
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
	public int getCoutPieger() {
		return coutPieger;
	}

}
