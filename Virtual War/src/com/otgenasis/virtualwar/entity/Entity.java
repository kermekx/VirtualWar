package com.otgenasis.virtualwar.entity;

import com.otgenasis.virtualwar.texture.Texture;

public abstract class Entity {

	/**
	 * nom de l'entité
	 */
	private String nom;

	/**
	 * Texture de l'entité
	 */
	private Texture texture;

	/**
	 * Créer une entité
	 * 
	 * @param nom
	 *            de l'entité
	 * @param texture
	 *            de l'entité
	 */
	public Entity(String nom, Texture texture) {
		this.nom = nom;
		this.texture = texture;
	}

	/**
	 * Entity [nom="nom de l'entité"]
	 */
	@Override
	public String toString() {
		return "Entity [nom=" + nom + "]";
	}

	/**
	 * renvoie le nom de l'entité
	 * 
	 * @return nom de l'entité
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * renvoie la texture de l'entité
	 * 
	 * @return texture de l'entité
	 */
	public Texture getTexture() {
		return texture;
	}

}
