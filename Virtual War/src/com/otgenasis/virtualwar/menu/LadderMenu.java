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

public class LadderMenu extends JComponent {

	private Main game;

	public LadderMenu(Main game) {
		this.game = game;

		this.setBackground(Color.WHITE);
		this.addTitle();
		this.addButtons();
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

		JButton boutonRetour = new JButton("Retour");
		boutonRetour.setBounds((int) (width * 0.25), (int) (height * 0.85),
				(int) (width * 0.5), (int) (height * 0.05));
		
		this.add(boutonRetour);
		
		boutonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setScene(new MainMenu(game));
			}
		});
	}
}
