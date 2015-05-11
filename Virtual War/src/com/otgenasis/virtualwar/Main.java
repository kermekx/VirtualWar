package com.otgenasis.virtualwar;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.otgenasis.virtualwar.frame.GameFrame;
import com.otgenasis.virtualwar.menu.MainMenu;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new GameFrame();
		Main game = new Main(frame);
		game.run();
	}
	
	private JFrame frame;
	
	private int hauteur;
	private int largeur;
	
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

	public void setSize(int hauteur, int largeur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		System.out.println(hauteur);
	}

}
