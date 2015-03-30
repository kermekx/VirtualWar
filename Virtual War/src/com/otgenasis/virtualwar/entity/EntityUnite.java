package com.otgenasis.virtualwar.entity;

import java.util.ArrayList;
import java.util.List;

import com.otgenasis.virtualwar.texture.Texture;

public class EntityUnite extends Entity {

	/**
	 * List des unit� disponible
	 */
	public static List<EntityUnite> unites;

	/**
	 * Mouvement max d'une unit�
	 */
	private double mouvement;

	/**
	 * cout des d�placement
	 */
	private int coutMouvement;

	/**
	 * Energie max d'une unit�
	 */
	private int energie;

	/**
	 * d�gats subit par attaque
	 */
	private int degatSubit;

	/**
	 * Cr�er une unit� de base
	 * 
	 * @param nom
	 *            de l'entit�
	 * @param texture
	 *            de l'entit�
	 * @param energie
	 *            max de l'unit�
	 * @param mouvement
	 *            max de l'unit�
	 * @param coutMouvement
	 *            de l'unit�
	 * @param degatSubit
	 *            de l'unit�
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
	 * revoie la liste des unit�es
	 * 
	 * @return List Unite
	 */
	public static List<EntityUnite> getUnites() {
		if (unites == null)
			loadUnites();
		return unites;
	}

	/**
	 * Charges les types d'unit�es
	 */
	private static void loadUnites() {

		unites = new ArrayList<EntityUnite>();
		
		unites.add(new EntityTireur("Chasseur", null, 40, 5.0d, 1, 3, 10.0d, 2));
		unites.add(new EntityPiegeur("Destin�e", null, 50, 10.0d, 5, 2, 1.0d, 2));
		unites.add(new EntityTireur("Croisseur", null, 60, 2.0d, 5, 6, 15.0d, 1));

	}

	/**
	 * renvoie l'energie max de l'unit�
	 * 
	 * @return energie
	 */
	public int getEnergie() {
		return energie;
	}

	/**
	 * renvoie le mouvement max de l'unit�
	 * 
	 * @return mouvement
	 */
	public double getMouvement() {
		return mouvement;
	}

	/**
	 * renvoie le cout des mouvement de l'unit�
	 * 
	 * @return coutMouvement
	 */
	public int getCoutMouvement() {
		return coutMouvement;
	}

	/**
	 * renvoie les d�gat que subit l'unite
	 * 
	 * @return degatSubit
	 */
	public int getDegatSubit() {
		return degatSubit;
	}
}
