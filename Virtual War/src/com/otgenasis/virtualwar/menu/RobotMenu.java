package com.otgenasis.virtualwar.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.otgenasis.virtualwar.Main;

public class RobotMenu extends JComponent {

	/**
	 * Class principal du jeu
	 */
	private Main game;

	/**
	 * Liste des robots de l'equipe 1
	 */
	private String[] joueur1 = new String[5];
	/**
	 * Liste des robots de l'equipe 2
	 */
	private String[] joueur2 = new String[5];

	/**
	 * cree un menu de choix du robot
	 * 
	 * @param game
	 */
	public RobotMenu(Main game) {
		this.game = game;

		this.setBackground(Color.WHITE);
		this.addTitle();
		this.addButtons();
		this.addBox();
	}

	/**
	 * affichage du titre
	 */
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

		title.setBounds((int) (width * 0.25), 0, (int) (width * 0.5),
				(int) (height * 0.25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(title);
	}

	/**
	 * affichage des boutons
	 */
	private void addButtons() {
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;

		JButton boutonJouer = new JButton("Jouer");
		boutonJouer.setBounds((int) (width * 0.25), (int) (height * 0.85),
				(int) (width * 0.5), (int) (height * 0.05));

		this.add(boutonJouer);

		boutonJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setTroupes(joueur1, joueur2);
				game.launch();
			}
		});
	}

	/**
	 * affichage des boites de choix
	 */
	private void addBox() {

		Integer[] nbr = { 1, 2, 3, 4, 5 };
		String[] troupes = { "Tireur", "Piegeur", "Char" };

		final JComboBox<Integer> boxNbr = new JComboBox<Integer>(nbr);
		placeBox(boxNbr, new Point(50, 35));

		final List<JComboBox<String>> box = new ArrayList<JComboBox<String>>();

		for (int i = 0; i < 5; i++) {
			final JComboBox<String> joueur_1 = new JComboBox<String>(troupes);
			placeBox(joueur_1, new Point(20, 45 + i * 10));
			joueur_1.setVisible(false);

			final JComboBox<String> joueur_2 = new JComboBox<String>(troupes);
			placeBox(joueur_2, new Point(80, 45 + i * 10));
			joueur_2.setVisible(false);

			box.add(joueur_1);
			box.add(joueur_2);

		}

		boxNbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nbr = (Integer) boxNbr.getSelectedItem();

				for (JComboBox<String> b : box)
					b.setVisible(false);

				for (int i = 0; i / 2 < nbr; i++) {
					box.get(i).setVisible(true);
					if (i % 2 == 0) {
						joueur1[i / 2] = (String) box.get(i).getSelectedItem();
					} else {
						joueur2[i / 2] = (String) box.get(i).getSelectedItem();
					}
				}

				for (int i = nbr; i < 5; i++) {
					joueur1[i] = null;
					joueur2[i] = null;
				}

			}
		});

		for (JComboBox<String> b : box)
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String choix = (String) ((JComboBox<String>) e.getSource())
							.getSelectedItem();
					int i = box.indexOf(((JComboBox<String>) e.getSource()));
					if (i % 2 == 0) {
						joueur1[i / 2] = choix;
					} else {
						joueur2[i / 2] = choix;
					}
				}
			});

		joueur1[0] = "Tireur";
		joueur2[0] = "Tireur";

		this.add(boxNbr);

		for (JComboBox<String> b : box)
			this.add(b);
	}

	/**
	 * placage des combo box
	 */
	private void placeBox(JComboBox<?> comboBox, Point pos) {
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;

		comboBox.setBounds((int) (width * pos.getX() * 0.01 - width * 0.125),
				(int) (height * pos.getY() * 0.01 - height * 0.05),
				(int) (width * 0.25), (int) (height * 0.05));

	}
}
