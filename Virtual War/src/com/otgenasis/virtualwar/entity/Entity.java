package com.otgenasis.virtualwar.entity;

import com.otgenasis.virtualwar.texture.Texture;

public abstract class Entity {

	/**
	 * nom de l'entit�
	 */
	private String nom;

	/**
	 * Texture de l'entit�
	 */
	private Texture texture;

	/**
	 * Cr�er une entit�
	 * 
	 * @param nom
	 *            de l'entit�
	 * @param texture
	 *            de l'entit�
	 */
	public Entity(String nom, Texture texture) {
		this.nom = nom;
		this.texture = texture;
	}

	/**
	 * Entity [nom="nom de l'entit�"]
	 */
	@Override
	public String toString() {
		return "Entity [nom=" + nom + "]";
	}

	/**
	 * renvoie le nom de l'entit�
	 * 
	 * @return nom de l'entit�
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * renvoie la texture de l'entit�
	 * 
	 * @return texture de l'entit�
	 */
	public Texture getTexture() {
		return texture;
	}

}
