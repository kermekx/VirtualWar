package com.otgenasis.virtualwar.entity;

import java.util.ArrayList;
import java.util.List;

import com.otgenasis.virtualwar.texture.Texture;

public class EntityUnite extends Entity {

	/**
	 * List des unité disponible
	 */
	public static List<EntityUnite> unites;

	/**
	 * Mouvement max d'une unité
	 */
	private double mouvement;

	/**
	 * cout des déplacement
	 */
	private int coutMouvement;

	/**
	 * Energie max d'une unité
	 */
	private int energie;

	/**
	 * dégats subit par attaque
	 */
	private int degatSubit;

	/**
	 * Créer une unité de base
	 * 
	 * @param nom
	 *            de l'entité
	 * @param texture
	 *            de l'entité
	 * @param energie
	 *            max de l'unité
	 * @param mouvement
	 *            max de l'unité
	 * @param coutMouvement
	 *            de l'unité
	 * @param degatSubit
	 *            de l'unité
	 */
	public EntityUnite(String nom, Texture texture, int energie, double mouvement,
			int coutMouvement, int degatSubit) {
		super(nom, texture);
		this.energie = energie;
		this.mouvement = mouvement;
		this.coutMouvement = coutMouvement;
		this.degatSubit = degatSubit;

	}

	/**
	 * revoie la liste des unitées
	 * 
	 * @return List Unite
	 */
	public static List<EntityUnite> getUnites() {
		if (unites == null)
			loadUnites();
		return unites;
	}

	/**
	 * Charges les types d'unitées
	 */
	private static void loadUnites() {

		unites = new ArrayList<EntityUnite>();
		
		unites.add(new EntityTireur("Chasseur", null, 40, 5.0d, 1, 3, 10.0d, 2));
		unites.add(new EntityPiegeur("Destinée", null, 50, 10.0d, 5, 2, 1.0d, 2));
		unites.add(new EntityTireur("Croisseur", null, 60, 2.0d, 5, 6, 15.0d, 1));

	}

	/**
	 * renvoie l'energie max de l'unité
	 * 
	 * @return energie
	 */
	public int getEnergie() {
		return energie;
	}

	/**
	 * renvoie le mouvement max de l'unité
	 * 
	 * @return mouvement
	 */
	public double getMouvement() {
		return mouvement;
	}

	/**
	 * renvoie le cout des mouvement de l'unité
	 * 
	 * @return coutMouvement
	 */
	public int getCoutMouvement() {
		return coutMouvement;
	}

	/**
	 * renvoie les dégat que subit l'unite
	 * 
	 * @return degatSubit
	 */
	public int getDegatSubit() {
		return degatSubit;
	}
}
