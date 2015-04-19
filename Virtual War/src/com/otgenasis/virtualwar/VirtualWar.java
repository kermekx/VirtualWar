package com.otgenasis.virtualwar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.otgenasis.virtualwar.action.Action;
import com.otgenasis.virtualwar.action.Attaque;
import com.otgenasis.virtualwar.action.Deplacement;
import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.plateau.Plateau;
import com.otgenasis.virtualwar.robot.Char;
import com.otgenasis.virtualwar.robot.Piegeur;
import com.otgenasis.virtualwar.robot.Robot;
import com.otgenasis.virtualwar.robot.Tireur;
import com.otgenasis.virtualwar.vue.Vue;

public class VirtualWar {

	/**
	 * Instructions
	 */
	public static String INFO = "Unites\n"
			+ "T : tireur alie  | y : tireur enemie\n"
			+ "P : piegeur alie | p : piegeur enemie\n"
			+ "C : char alie    | c : char enemi\n"
			+ "B : Base alie    | b : base enemi\n"
			+ "X : mine alie    | (invisible) : mine enemi\n\n"
			+ "Comandes :\n" + "move 'numero_robot' 'pos_x' 'pos_y';\n"
			+ "shot 'numero_robot' 'pos_x' 'pos_y';\n"
			+ "mine 'numero_robot' 'pos_x' 'pos_y';\n";

	/**
	 * Vues des deux joueurs
	 */
	private List<Vue> vues;

	/**
	 * Plateau de jeu
	 */
	private Plateau plateau;

	/**
	 * joueur actuel
	 */
	private int joueur;

	/**
	 * lancement du jeu directement
	 * 
	 * @param args
	 *            non utilisés
	 */
	public static void main(String[] args) {
		VirtualWar vw = new VirtualWar();
		while (!vw.finished())
			vw.turn();
	}

	/**
	 * Création d'une partie 10X10 JvJ
	 */
	public VirtualWar() {
		vues = new ArrayList<Vue>();
		plateau = new Plateau();
		vues.add(new Vue(plateau, 0));
		vues.add(new Vue(plateau, 1));
		plateau.getPlateau()[0][0].deplaceSur(new Tireur(vues.get(0), 0, 0, 0));
		plateau.getPlateau()[0][0].deplaceSur(new Tireur(vues.get(0), 0, 0, 0));
		plateau.getPlateau()[0][0]
				.deplaceSur(new Piegeur(vues.get(0), 0, 0, 0));
		plateau.getPlateau()[0][0].deplaceSur(new Char(vues.get(0), 0, 0, 0));
		plateau.getPlateau()[0][0].deplaceSur(new Char(vues.get(0), 0, 0, 0));
		plateau.getPlateau()[9][9].deplaceSur(new Tireur(vues.get(1), 9, 9, 1));
		plateau.getPlateau()[9][9].deplaceSur(new Tireur(vues.get(1), 9, 9, 1));
		plateau.getPlateau()[9][9]
				.deplaceSur(new Piegeur(vues.get(1), 9, 9, 1));
		plateau.getPlateau()[9][9].deplaceSur(new Char(vues.get(1), 9, 9, 1));
		plateau.getPlateau()[9][9].deplaceSur(new Char(vues.get(1), 9, 9, 1));
		joueur = 0;
	}

	/**
	 * Affiche le rendu du joueur actuel
	 */
	@Override
	public String toString() {
		return "Joueur : " + (joueur + 1) + "\n\n" + INFO + "\n\n"
				+ vues.get(joueur);
	}

	/**
	 * Tour de l'equipe
	 */
	private void turn() {
		vues.get(joueur).heal();
		System.out.println(this);
		getInput();
		joueur = (joueur + 1) % 2;
	}

	/**
	 * demande unbe commande tant qu'elle n'est pas valide
	 */
	private void getInput() {
		boolean done = false;
		do {
			Scanner scanner = new Scanner(System.in);
			List<String> args = new ArrayList<String>();
			while (scanner.hasNext()) {
				args.add(scanner.next());
				if (args.size() == 4)
					break;
			}
			done = action(args);

		} while (!done /* || vues.get(joueur).hasRobotOutOfBase() */);
	}

	/**
	 * traduit une commande
	 * 
	 * @param args
	 *            commande numeroRobot x y
	 * @return si la commande à réussit
	 */
	private boolean action(List<String> args) {

		if (args.size() < 4)
			return false;

		Action action;

		if (args.get(0).equalsIgnoreCase("move")) {
			try {
				Robot robot = vues.get(joueur).getRobot(
						Integer.parseInt(args.get(1)) - 1);
				action = new Deplacement(robot, new Coordonnees(
						Integer.parseInt(args.get(2)), Integer.parseInt(args
								.get(3))));
				return action.agit();
			} catch (Exception e) {
				System.out
						.println("utilisation de 'move' : move 'numero_robot' 'pos_x' 'pos_y'");
				return false;
			}
		} else if (args.get(0).equalsIgnoreCase("shot")) {
			try {
				Robot robot = vues.get(joueur).getRobot(
						Integer.parseInt(args.get(1)) - 1);
				action = new Attaque(robot, new Coordonnees(
						Integer.parseInt(args.get(2)), Integer.parseInt(args
								.get(3))));
				return action.agit();
			} catch (Exception e) {
				System.out
						.println("utilisation de 'shot' : shot 'numero_robot' 'pos_x' 'pos_y'");
				return false;
			}
		} else if (args.get(0).equalsIgnoreCase("mine")) {
			try {
				Robot robot = vues.get(joueur).getRobot(
						Integer.parseInt(args.get(1)) - 1);
				if (robot.peutTirer() || robot.estSurBase())
					return false;
				return vues.get(joueur).mine(
						new Coordonnees(Integer.parseInt(args.get(2)), Integer
								.parseInt(args.get(3))));
			} catch (Exception e) {
				System.out
						.println("utilisation de 'mine' : mine 'numero_robot' 'pos_x' 'pos_y'");
				return false;
			}
		}

		System.out.println("Commande '" + args.get(0) + "' introuvable!");

		return false;

	}

	/**
	 * TODO
	 * demande si le jeu est fini
	 * @return false
	 */
	private boolean finished() {
		return false;
	}

}
