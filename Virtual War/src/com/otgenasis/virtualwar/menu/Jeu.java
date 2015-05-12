package com.otgenasis.virtualwar.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.otgenasis.virtualwar.Main;

public class Jeu extends JComponent {

	private Main game;
	
	private List<JPanel> cellules = new ArrayList<JPanel>();

	public Jeu(Main game) {
		this.game = game;

		this.setBackground(Color.WHITE);
		this.addGrid();
	}

	private void addGrid() {
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;
		
		JPanel grille = new JPanel(new GridLayout(game.getSize().x,
				game.getSize().y));
		grille.setBounds(0, 0, height, height);
		
		Border blackline = BorderFactory.createLineBorder(Color.black, 1);
		for (int i = 0; i < game.getSize().x * game.getSize().y; i++) {
			JPanel cellule = new JPanel();
			cellule.setBorder(blackline);
			cellule.setLayout(new BorderLayout());
			grille.add(cellule);
			cellules.add(cellule);
		}
		
		grille.setBorder(blackline);
		this.add(grille);
		
	}
}
