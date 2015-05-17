package com.otgenasis.virtualwar;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.otgenasis.virtualwar.frame.GameFrame;
import com.otgenasis.virtualwar.menu.Jeu;
import com.otgenasis.virtualwar.menu.MainMenu;
import com.otgenasis.virtualwar.plateau.Plateau;
import com.otgenasis.virtualwar.robot.Char;
import com.otgenasis.virtualwar.robot.Piegeur;
import com.otgenasis.virtualwar.robot.Tireur;
import com.otgenasis.virtualwar.vue.Vue;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new GameFrame();
		Main game = new Main(frame);
		game.run();
	}

	private JFrame frame;

	private int hauteur, largeur, obstacles;

	private List<String> troupes_1, troupes_2;

	private String team1, team2, flag1, flag2;

	private Jeu jeu;

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
	 * creation de la fenetre
	 * @param frame
	 */
	public Main(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * renvoie la fenetre
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * lance la fenetre
	 */
	public void run() {
		this.setScene(new MainMenu(this));
	}

	/**
	 * change l'affichage
	 * @param component
	 */
	public void setScene(JComponent component) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(component);
		SwingUtilities.updateComponentTreeUI(frame);
	}

	/**
	 * change la taille du plateau
	 * @param hauteur
	 * @param largeur
	 * @param obstacles
	 */
	public void setSize(int hauteur, int largeur, int obstacles) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.obstacles = obstacles;
	}

	/**
	 * renvoie la taille du plateau
	 * @return
	 */
	public Point getSize() {
		return new Point(hauteur, largeur);
	}

	/**
	 * change les troupes des equipe
	 * @param joueur1
	 * @param joueur2
	 */
	public void setTroupes(String[] joueur1, String[] joueur2) {
		troupes_1 = new ArrayList<String>();
		troupes_2 = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			if (joueur1[i] != null)
				troupes_1.add(joueur1[i]);
			if (joueur2[i] != null)
				troupes_2.add(joueur2[i]);
		}
	}

	/**
	 * change le nom des equipes
	 * @param teamName1
	 * @param teamName2
	 */
	public void setTeamName(String teamName1, String teamName2) {
		team1 = teamName1;
		team2 = teamName2;
	}

	/**
	 * change les chemins de drapeau des equipes
	 * @param player1Flag
	 * @param player2Flag
	 */
	public void setTeamFlag(String player1Flag, String player2Flag) {
		flag1 = player1Flag;
		flag2 = player2Flag;
	}

	/**
	 * nom de l'equipe
	 * @param equipe
	 * @return
	 */
	public String getTeamName(int equipe) {
		return (equipe == 0) ? team1 : team2;
	}
	
	/**
	 * chemin du drapeau de l'equipe
	 * @param equipe
	 * @return
	 */
	public String getTeamFlag(int equipe) {
		return (equipe == 0) ? flag1 : flag2;
	}

	/**
	 * lance la partie
	 */
	public void launch() {
		vues = new ArrayList<Vue>();
		plateau = new Plateau(largeur, hauteur, obstacles);
		vues.add(new Vue(plateau, 0));
		vues.add(new Vue(plateau, 1));
		for (String troupe : troupes_1) {
			switch (troupe) {
			case "Tireur":
				plateau.getPlateau()[0][0].deplaceSur(new Tireur(vues.get(0),
						0, 0, 0));
				break;
			case "Piegeur":
				plateau.getPlateau()[0][0].deplaceSur(new Piegeur(vues.get(0),
						0, 0, 0));
				break;
			case "Char":
				plateau.getPlateau()[0][0].deplaceSur(new Char(vues.get(0), 0,
						0, 0));
				break;
			default:
				plateau.getPlateau()[0][0].deplaceSur(new Tireur(vues.get(0),
						0, 0, 0));
				break;
			}
		}

		int largeur = this.largeur - 1;
		int hauteur = this.hauteur - 1;

		for (String troupe : troupes_2) {
			switch (troupe) {
			case "Tireur":
				plateau.getPlateau()[largeur][hauteur].deplaceSur(new Tireur(
						vues.get(1), largeur, hauteur, 1));
				break;
			case "Piegeur":
				plateau.getPlateau()[largeur][hauteur].deplaceSur(new Piegeur(
						vues.get(1), largeur, hauteur, 1));
				break;
			case "Char":
				plateau.getPlateau()[largeur][hauteur].deplaceSur(new Char(vues
						.get(1), largeur, hauteur, 1));
				break;
			default:
				plateau.getPlateau()[largeur][hauteur].deplaceSur(new Tireur(
						vues.get(1), largeur, hauteur, 1));
				break;
			}
		}

		joueur = 0;

		jeu = new Jeu(this);
		this.setScene(jeu);

		this.nextTurn();
	}

	/**
	 * tour suivant
	 */
	public void nextTurn() {
		if (isFinished())
			endGame();
		else {
			vues.get(joueur).heal();
			jeu.setVue(vues.get(joueur));
			SwingUtilities.updateComponentTreeUI(frame);
			joueur = (joueur + 1) % 2;
		}
	}

	/**
	 * fin de la partie
	 */
	private void endGame() {
		JOptionPane.showMessageDialog(getFrame(), ((vues.get(0).getRobot(0) == null) ? team2 : team1) + " a gagner!");
		setScene(new MainMenu(this));
	}

	/**
	 * renvoie si la partie est fini
	 * @return boolean
	 */
	private boolean isFinished() {
		if (vues.get(0).getRobot(0) == null || vues.get(1).getRobot(0) == null )
			return true;
		
		return false;
	}
}
