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
import javax.swing.SwingConstants;

import com.otgenasis.virtualwar.Main;

public class MainMenu extends JComponent {

	/**
	 * Class principal du jeu
	 */
	private Main game;

	/**
	 * cree un menu principale
	 * 
	 * @param game
	 */
	public MainMenu(Main game) {
		this.game = game;

		this.setBackground(Color.WHITE);
		this.addTitle();
		this.addButtons();
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
		boutonJouer.setBounds((int) (width * 0.15), (int) (height * 0.45),
				(int) (width * 0.25), (int) (height * 0.05));
		JButton boutonClassement = new JButton("Classement");
		boutonClassement.setBounds((int) (width * 0.65), (int) (height * 0.45),
				(int) (width * 0.25), (int) (height * 0.05));
		JButton boutonOptions = new JButton("Options");
		boutonOptions.setBounds((int) (width * 0.15), (int) (height * 0.7),
				(int) (width * 0.25), (int) (height * 0.05));
		;
		JButton boutonQuitter = new JButton("Quiter");
		boutonQuitter.setBounds((int) (width * 0.65), (int) (height * 0.7),
				(int) (width * 0.25), (int) (height * 0.05));

		this.add(boutonJouer);
		this.add(boutonClassement);
		this.add(boutonOptions);
		this.add(boutonQuitter);

		boutonJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setScene(new TeamMenu(game));
			}
		});

		boutonClassement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setScene(new LadderMenu(game));
			}
		});

		boutonOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setScene(new OptionMenu(game));
			}
		});

		boutonQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
