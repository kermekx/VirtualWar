package com.otgenasis.virtualwar.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.otgenasis.virtualwar.Main;

public class TeamMenu extends JComponent {

	private Main game;

	private JTextField player1TeamName;
	private JTextField player2TeamName;

	private String player1Flag;
	private String player2Flag;

	private JPanel drapeau1;
	private JPanel drapeau2;

	public TeamMenu(Main game) {
		this.game = game;

		this.setBackground(Color.WHITE);
		this.addTitle();
		this.addButtons();
		this.addJTextField();
		this.addFlagDisplay();
	}

	private void addTitle() {
		JLabel title = new JLabel("VIRTUAL WAR");
		JLabel vs = new JLabel("VERSUS");

		Font police;
		try {
			police = Font.createFont(Font.TRUETYPE_FONT, new File(
					"fonts/font.ttf"));
			police = police.deriveFont(50f);
			title.setFont(police);
			vs.setFont(police);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		title.setForeground(Color.ORANGE);
		vs.setForeground(Color.ORANGE);


		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;

		title.setBounds((int) (width * 0.25), 0, (int) (width * 0.5),
				(int) (height * 0.25));
		vs.setBounds((int) (width * 0.375), (int) (height * 0.5), (int) (width * 0.25),
				(int) (height * 0.25));
		
		title.setHorizontalAlignment(SwingConstants.CENTER);
		vs.setHorizontalAlignment(SwingConstants.CENTER);
		vs.setVerticalAlignment(SwingConstants.CENTER);
		
		this.add(title);
		this.add(vs);
	}

	private void addButtons() {
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;

		JButton boutonJouer = new JButton("Jouer");
		boutonJouer.setBounds((int) (width * 0.25), (int) (height * 0.85),
				(int) (width * 0.5), (int) (height * 0.05));

		JButton boutonDrapeauJ1 = new JButton("Choix du drapeau");
		boutonDrapeauJ1.setBounds((int) (width * 0.125), (int) (height * 0.4),
				(int) (width * 0.25), (int) (height * 0.05));

		JButton boutonDrapeauJ2 = new JButton("Choix du drapeau");
		boutonDrapeauJ2.setBounds((int) (width * 0.625), (int) (height * 0.4),
				(int) (width * 0.25), (int) (height * 0.05));

		this.add(boutonJouer);
		this.add(boutonDrapeauJ1);
		this.add(boutonDrapeauJ2);

		boutonJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setTeamName(player1TeamName.getText(),
						player2TeamName.getText());
				game.setTeamFlag(player1Flag, player2Flag);
				game.setScene(new PlateauMenu(game));
			}
		});

		boutonDrapeauJ1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser dialogue = new JFileChooser(new File(
						"images/drapeaux"));
				FileFilter filter = new FileNameExtensionFilter("Images",
						"bmp", "gif", "jpg", "jpeg", "png");
				dialogue.addChoosableFileFilter(filter);
				dialogue.setAcceptAllFileFilterUsed(false);
				dialogue.setDialogTitle("Drapeau de l'equipe "
						+ player1TeamName.getText());
				File fichier;

				if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					Rectangle bounds = game.getFrame().getBounds();
					int width = bounds.width;
					int height = bounds.height;

					fichier = dialogue.getSelectedFile();
					player1Flag = fichier.getPath();

					Image flag = scaleImage(
							new ImageIcon(fichier.getPath()).getImage(),
							(int) (width * 0.25), (int) (height * 0.25));
					Icon scaledFlag = new ImageIcon(flag);
					
					drapeau1.removeAll();				
					drapeau1.add(new JLabel(scaledFlag), BorderLayout.CENTER);
					update();
				}
			}
		});
		
		boutonDrapeauJ2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser dialogue = new JFileChooser(new File(
						"images/drapeaux"));
				FileFilter filter = new FileNameExtensionFilter("Images",
						"bmp", "gif", "jpg", "jpeg", "png");
				dialogue.addChoosableFileFilter(filter);
				dialogue.setAcceptAllFileFilterUsed(false);
				dialogue.setDialogTitle("Drapeau de l'equipe "
						+ player2TeamName.getText());
				File fichier;

				if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					Rectangle bounds = game.getFrame().getBounds();
					int width = bounds.width;
					int height = bounds.height;

					fichier = dialogue.getSelectedFile();
					player2Flag = fichier.getPath();

					Image flag = scaleImage(
							new ImageIcon(fichier.getPath()).getImage(),
							(int) (width * 0.25), (int) (height * 0.25));
					Icon scaledFlag = new ImageIcon(flag);
					
					drapeau2.removeAll();				
					drapeau2.add(new JLabel(scaledFlag), BorderLayout.CENTER);
					update();
				}
			}
		});
	}

	private void addJTextField() {
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;

		player1TeamName = new JTextField("joueur 1");
		player1TeamName.setBounds((int) (width * 0.125), (int) (height * 0.3),
				(int) (width * 0.25), (int) (height * 0.05));

		player2TeamName = new JTextField("joueur 2");
		player2TeamName.setBounds((int) (width * 0.625), (int) (height * 0.3),
				(int) (width * 0.25), (int) (height * 0.05));

		this.add(player1TeamName);
		this.add(player2TeamName);

	}

	private void addFlagDisplay() {
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;

		Border blackline = BorderFactory.createLineBorder(Color.black, 1);

		drapeau1 = new JPanel();
		drapeau1.setBorder(blackline);
		drapeau1.setLayout(new BorderLayout());
		drapeau1.setBounds((int) (width * 0.125), (int) (height * 0.5),
				(int) (width * 0.25), (int) (height * 0.25));
		this.add(drapeau1);

		drapeau2 = new JPanel();
		drapeau2.setBorder(blackline);
		drapeau2.setLayout(new BorderLayout());
		drapeau2.setBounds((int) (width * 0.625), (int) (height * 0.5),
				(int) (width * 0.25), (int) (height * 0.25));
		this.add(drapeau2);
	}

	private static Image scaleImage(Image source, int width, int height) {
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(source, 0, 0, width, height, null);
		g.dispose();
		return img;
	}
	
	private void update() {
		SwingUtilities.updateComponentTreeUI(this);
	}
}
