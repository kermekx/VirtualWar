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

public class PlateauMenu extends JComponent {

	private Main game;

	private int hauteur = 5;
	private int largeur = 5;
	private int obstacles = 25;

	public PlateauMenu(Main game) {
		this.game = game;

		this.setBackground(Color.WHITE);
		this.addTitle();
		this.addButtons();
		this.addSliders();
	}

	private void addTitle() {
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;

		JLabel title = new JLabel("VIRTUAL WAR");
		JLabel largeur = new JLabel("LARGEUR : ");
		JLabel hauteur = new JLabel("HAUTEUR : ");
		JLabel obstacles = new JLabel("TAUX D'OBSTACLES : ");
		Font police;
		try {
			police = Font.createFont(Font.TRUETYPE_FONT, new File(
					"fonts/font.ttf"));
			police = police.deriveFont(50f);
			title.setFont(police);
			police = Font.createFont(Font.TRUETYPE_FONT, new File(
					"fonts/font.ttf"));
			police = police.deriveFont(20f);
			largeur.setFont(police);
			hauteur.setFont(police);
			obstacles.setFont(police);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		title.setForeground(Color.ORANGE);
		largeur.setForeground(Color.ORANGE);
		hauteur.setForeground(Color.ORANGE);
		obstacles.setForeground(Color.ORANGE);

		title.setBounds((int) (width * 0.25), 0, (int) (width * 0.5),
				(int) (height * 0.25));
		largeur.setBounds(0, (int) (height * 0.3),
				(int) (width * 0.25), (int) (height * 0.15));
		hauteur.setBounds(0, (int) (height * 0.5),
				(int) (width * 0.25), (int) (height * 0.15));
		obstacles.setBounds(0, (int) (height * 0.7),
				(int) (width * 0.25), (int) (height * 0.15));

		title.setHorizontalAlignment(SwingConstants.CENTER);
		largeur.setHorizontalAlignment(SwingConstants.RIGHT);
		hauteur.setHorizontalAlignment(SwingConstants.RIGHT);
		obstacles.setHorizontalAlignment(SwingConstants.RIGHT);
		
		this.add(title);
		this.add(largeur);
		this.add(hauteur);
		this.add(obstacles);
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
				game.setSize(hauteur, largeur, obstacles);
				game.setScene(new RobotMenu(game));
			}
		});
	}

	private void addSliders() {

		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;

		JSlider sliderHauteur = new JSlider();
		sliderHauteur.setToolTipText("Hauteur :");
		sliderHauteur.setMaximum(20);
		sliderHauteur.setMinimum(2);
		sliderHauteur.setValue(5);
		sliderHauteur.setPaintTicks(true);
		sliderHauteur.setPaintLabels(true);
		sliderHauteur.setMinorTickSpacing(5);
		sliderHauteur.setMajorTickSpacing(5);
		sliderHauteur.setForeground(Color.ORANGE);
		sliderHauteur.setBackground(Color.WHITE);
		sliderHauteur.setBounds((int) (width * 0.25), (int) (height * 0.3),
				(int) (width * 0.5), (int) (height * 0.15));

		JSlider sliderLargeur = new JSlider();
		sliderLargeur.setToolTipText("Largeur :");
		sliderLargeur.setMaximum(20);
		sliderLargeur.setMinimum(2);
		sliderLargeur.setValue(5);
		sliderLargeur.setPaintTicks(true);
		sliderLargeur.setPaintLabels(true);
		sliderLargeur.setMinorTickSpacing(5);
		sliderLargeur.setMajorTickSpacing(5);
		sliderLargeur.setForeground(Color.ORANGE);
		sliderLargeur.setBackground(Color.WHITE);
		sliderLargeur.setBounds((int) (width * 0.25), (int) (height * 0.5),
				(int) (width * 0.5), (int) (height * 0.15));

		JSlider sliderObstacles = new JSlider();
		sliderObstacles.setToolTipText("Taux d'obstacles :");
		sliderObstacles.setMaximum(100);
		sliderObstacles.setMinimum(0);
		sliderObstacles.setValue(25);
		sliderObstacles.setPaintTicks(true);
		sliderObstacles.setPaintLabels(true);
		sliderObstacles.setMinorTickSpacing(5);
		sliderObstacles.setMajorTickSpacing(5);
		sliderObstacles.setForeground(Color.ORANGE);
		sliderObstacles.setBackground(Color.WHITE);
		sliderObstacles.setBounds((int) (width * 0.25), (int) (height * 0.7),
				(int) (width * 0.5), (int) (height * 0.15));

		sliderHauteur.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hauteur = ((JSlider) e.getSource()).getValue();
			}
		});

		sliderLargeur.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				largeur = ((JSlider) e.getSource()).getValue();
			}
		});

		sliderObstacles.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				obstacles = ((JSlider) e.getSource()).getValue();
			}
		});

		this.add(sliderHauteur);
		this.add(sliderLargeur);
		this.add(sliderObstacles);
	}

}
