package com.otgenasis.virtualwar.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.otgenasis.virtualwar.Main;

public class PlayMenu extends JComponent {
	
	private Main game;
	
	private int hauteur = 2;
	private int largeur = 2;

	public PlayMenu(Main game) {
		this.game = game;

		this.setBackground(Color.WHITE);
		this.addTitle();
		this.addButtons();
		this.addSliders();
	}

	private void addTitle() {
		JLabel title = new JLabel("VIRTUAL WAR");
		
		Font police;
		try {
			police = Font.createFont(Font.TRUETYPE_FONT, new File(
					"fonts/font.ttf"));
			police = police.deriveFont(50f);
			title.setFont(police);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		title.setForeground(Color.ORANGE);
		
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;
		
		title.setBounds((int) (width * 0.25), 0, (int) (width * 0.5), (int) (height * 0.25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(title);
	}

	private void addButtons() {
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;

		JButton boutonSuivant = new JButton("Suivant");
		boutonSuivant.setBounds((int) (width * 0.25), (int) (height * 0.85),
				(int) (width * 0.5), (int) (height * 0.05));
		
		this.add(boutonSuivant);
		
		boutonSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setSize(hauteur, largeur);
				game.setScene(new PlayMenu2(game));
			}
		});
	}
	
	private void addSliders() {
		
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;
		
		JSlider slideH = new JSlider();
		slideH.setToolTipText("Choisit la hauteur du terrain de jeu");
		slideH.setMaximum(20);
		slideH.setMinimum(2);
		slideH.setValue(5);
		slideH.setPaintTicks(true);
		slideH.setPaintLabels(true);
		slideH.setMinorTickSpacing(5);
		slideH.setMajorTickSpacing(5);
		slideH.setForeground(Color.ORANGE);
		
		slideH.setBackground(Color.WHITE);
		slideH.setBounds((int) (width * 0.25), (int) (height * 0.35),
				(int) (width * 0.5), (int) (height * 0.15));
		
		slideH.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hauteur = ((JSlider) e.getSource()).getValue();
			}
		});
		
		JSlider slideL = new JSlider();
		slideL.setToolTipText("Choisit la largeur du terrain de jeux");
		slideL.setMaximum(20);
		slideL.setMinimum(2);
		slideL.setValue(5);
		slideL.setPaintTicks(true);
		slideL.setPaintLabels(true);
		slideL.setMinorTickSpacing(5);
		slideL.setMajorTickSpacing(5);
		slideL.setForeground(Color.ORANGE);

		slideL.setBackground(Color.WHITE);
		slideL.setBounds((int) (width * 0.25), (int) (height * 0.60),
				(int) (width * 0.5), (int) (height * 0.15));
		
		slideL.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				largeur = ((JSlider) e.getSource()).getValue();
			}
		});
		
		this.add(slideH);
		this.add(slideL);
	}

}
