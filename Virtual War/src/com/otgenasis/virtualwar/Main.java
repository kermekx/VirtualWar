package com.otgenasis.virtualwar;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
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
	
	public Main(JFrame frame) {
		this.frame = frame;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public void run() {
		this.setScene(new MainMenu(this));
	}
	
	public void setScene(JComponent component) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(component);
		SwingUtilities.updateComponentTreeUI(frame);
	}

	public void setSize(int hauteur, int largeur, int obstacles) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.obstacles = obstacles;
	}

	public Point getSize() {
		return new Point(hauteur, largeur);
	}
	
	public void setTroupes(String[] joueur1, String[] joueur2) {
		troupes_1 = new ArrayList<String>();
		troupes_2 = new ArrayList<String>();
		
		for(int i = 0; i < 5; i++) {
			troupes_1.add(joueur1[i]);
			troupes_2.add(joueur2[i]);
		}
	}

	public void launch() {
		vues = new ArrayList<Vue>();
		plateau = new Plateau(largeur, hauteur);
		vues.add(new Vue(plateau, 0));
		vues.add(new Vue(plateau, 1));
		for (String troupe : troupes_1) {
			switch (troupe) {
			case "Tireur":
				plateau.getPlateau()[0][0].deplaceSur(new Tireur(vues.get(0), 0, 0, 0));
				break;
			case "Piegeur":
				plateau.getPlateau()[0][0].deplaceSur(new Piegeur(vues.get(0), 0, 0, 0));
				break;
			case "Char":
				plateau.getPlateau()[0][0].deplaceSur(new Char(vues.get(0), 0, 0, 0));
				break;
			default:
				plateau.getPlateau()[0][0].deplaceSur(new Tireur(vues.get(0), 0, 0, 0));
				break;
			}
		}
		
		for (String troupe : troupes_2) {
			switch (troupe) {
			case "Tireur":
				plateau.getPlateau()[largeur][hauteur].deplaceSur(new Tireur(vues.get(1), largeur, hauteur, 1));
				break;
			case "Piegeur":
				plateau.getPlateau()[largeur][hauteur].deplaceSur(new Piegeur(vues.get(1), largeur, hauteur, 1));
				break;
			case "Char":
				plateau.getPlateau()[largeur][hauteur].deplaceSur(new Char(vues.get(1), largeur, hauteur, 1));
				break;
			default:
				plateau.getPlateau()[largeur][hauteur].deplaceSur(new Tireur(vues.get(1), largeur, hauteur, 1));
				break;
			}
		}

		joueur = 0;
		
		this.setScene(new Jeu(this));
	}

}
