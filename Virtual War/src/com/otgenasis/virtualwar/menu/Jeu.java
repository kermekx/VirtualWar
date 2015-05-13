package com.otgenasis.virtualwar.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import com.otgenasis.virtualwar.Main;
import com.otgenasis.virtualwar.action.Action;
import com.otgenasis.virtualwar.action.Deplacement;
import com.otgenasis.virtualwar.coordonnees.Coordonnees;
import com.otgenasis.virtualwar.plateau.Base;
import com.otgenasis.virtualwar.plateau.Case;
import com.otgenasis.virtualwar.plateau.Cellule;
import com.otgenasis.virtualwar.robot.Robot;
import com.otgenasis.virtualwar.vue.Vue;

public class Jeu extends JComponent {

	private Main game;

	private List<JPanel> cellules = new ArrayList<JPanel>();
	private Map<String, Icon> equivalents;

	private Vue vue;

	private JPanel choix;

	public Jeu(Main game) {
		this.game = game;

		this.setBackground(Color.WHITE);
		this.addGrid();
		this.loadImages();
	}

	private void addGrid() {
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;

		JPanel grille = new JPanel(new GridLayout(game.getSize().x,
				game.getSize().y));
		grille.setBounds(0, 0, (int) (height * 0.9), (int) (height * 0.9));

		Border blackline = BorderFactory.createLineBorder(Color.black, 1);
		for (int i = 0; i < game.getSize().x * game.getSize().y; i++) {
			JPanel cellule = new JPanel();
			cellule.setBorder(blackline);
			cellule.setLayout(new BorderLayout());
			grille.add(cellule);
			cellules.add(cellule);

			cellule.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					int pos = 0;
					for (JPanel cellule : cellules) {
						if (cellule == e.getSource())
							break;
						pos++;
					}

					switch (getCellule(pos)) {
					case "base":
						choix.removeAll();

						Robot[] robots = new Robot[vue.getBase(vue.getEquipe())
								.getUnites().size()];
						for (int i = 0; i < robots.length; i++)
							robots[i] = vue.getBase(vue.getEquipe())
									.getUnites().get(i);
						final JComboBox<Robot> boxRobots = new JComboBox<Robot>(
								robots);
						choix.add(boxRobots);

						String[] actions = { "Deplacement" };
						JComboBox<String> boxActions = new JComboBox<String>(
								actions);

						choix.add(boxActions);

						final Map<Robot, JComboBox<Coordonnees>> boxCoordonnees = new HashMap<Robot, JComboBox<Coordonnees>>();

						for (Robot robot : robots) {
							List<Coordonnees> dep = robot.getDeplacements();
							Coordonnees[] positions = new Coordonnees[robot
									.getDeplacements().size()];
							for (int i = 0; i < positions.length; i++)
								positions[i] = dep.get(i);
							JComboBox<Coordonnees> boxDeplacements = new JComboBox<Coordonnees>(
									positions);
							boxDeplacements.setVisible(false);
							choix.add(boxDeplacements);
							boxCoordonnees.put(robot, boxDeplacements);
						}

						boxRobots.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								Robot robot = (Robot) ((JComboBox<Robot>) e
										.getSource()).getSelectedItem();

								Iterator<Robot> it = boxCoordonnees.keySet()
										.iterator();

								while (it.hasNext()) {
									Robot key = it.next();
									boxCoordonnees.get(key).setVisible(false);
								}

								boxCoordonnees.get(robot).setVisible(true);
							}
						});

						boxCoordonnees.get(boxRobots.getSelectedItem())
								.setVisible(true);

						JButton boutonAction = new JButton("Action");
						choix.add(boutonAction);

						boutonAction.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Robot robot = (Robot) boxRobots
										.getSelectedItem();
								Action action = new Deplacement(robot,
										(Coordonnees) boxCoordonnees.get(
												boxRobots.getSelectedItem())
												.getSelectedItem());
								action.agit();
								game.nextTurn();
								choix.removeAll();
							}
						});

						break;
					default:
						break;
					}

					SwingUtilities.updateComponentTreeUI(game.getFrame());
				}
			});

		}

		grille.setBorder(blackline);
		this.add(grille);

		choix = new JPanel();
		choix.setBounds(height, 0, width - height, height);
		this.add(choix);
	}

	private void loadImages() {
		Rectangle bounds = game.getFrame().getBounds();
		int width = bounds.width;
		int height = bounds.height;

		equivalents = new HashMap<String, Icon>();

		Image wall = scaleImage(new ImageIcon("images/mur.png").getImage(),
				(int) (height * 0.9 / game.getSize().y),
				(int) (height * 0.9 / game.getSize().x));
		Icon scaledWall = new ImageIcon(wall);
		equivalents.put("mur", scaledWall);

		Image base = scaleImage(new ImageIcon("images/base.png").getImage(),
				(int) (height * 0.9 / game.getSize().y),
				(int) (height * 0.9 / game.getSize().x));
		Icon scaledBase = new ImageIcon(base);
		equivalents.put("base", scaledBase);

		Image ebase = scaleImage(
				new ImageIcon("images/enemy_base.png").getImage(),
				(int) (height * 0.9 / game.getSize().y),
				(int) (height * 0.9 / game.getSize().x));
		Icon scaledEBase = new ImageIcon(ebase);
		equivalents.put("enemy_base", scaledEBase);

		Image tireur = scaleImage(
				new ImageIcon("images/tireur.png").getImage(),
				(int) (height * 0.9 / game.getSize().y),
				(int) (height * 0.9 / game.getSize().x));
		Icon scaledTireur = new ImageIcon(tireur);
		equivalents.put("tireur", scaledTireur);

		Image etireur = scaleImage(
				new ImageIcon("images/enemy_tireur.png").getImage(),
				(int) (height * 0.9 / game.getSize().y),
				(int) (height * 0.9 / game.getSize().x));
		Icon scaledETireur = new ImageIcon(etireur);
		equivalents.put("enemy_tireur", scaledETireur);

		Image piegeur = scaleImage(
				new ImageIcon("images/piegeur.png").getImage(),
				(int) (height * 0.9 / game.getSize().y),
				(int) (height * 0.9 / game.getSize().x));
		Icon scaledPiegeur = new ImageIcon(piegeur);
		equivalents.put("piegeur", scaledPiegeur);

		Image epiegeur = scaleImage(
				new ImageIcon("images/enemy_piegeur.png").getImage(),
				(int) (height * 0.9 / game.getSize().y),
				(int) (height * 0.9 / game.getSize().x));
		Icon scaledEPiegeur = new ImageIcon(epiegeur);
		equivalents.put("enemy_piegeur", scaledEPiegeur);

		Image achar = scaleImage(new ImageIcon("images/char.png").getImage(),
				(int) (height * 0.9 / game.getSize().y),
				(int) (height * 0.9 / game.getSize().x));
		Icon scaledChar = new ImageIcon(achar);
		equivalents.put("char", scaledChar);

		Image echar = scaleImage(
				new ImageIcon("images/enemy_char.png").getImage(),
				(int) (height * 0.9 / game.getSize().y),
				(int) (height * 0.9 / game.getSize().x));
		Icon scaledEChar = new ImageIcon(echar);
		equivalents.put("enemy_char", scaledEChar);

		Image mine = scaleImage(new ImageIcon("images/mine.png").getImage(),
				(int) (height * 0.9 / game.getSize().y),
				(int) (height * 0.9 / game.getSize().x));
		Icon scaledMine = new ImageIcon(mine);
		equivalents.put("mine", scaledMine);
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

	private void setCellule(String type, int x, int y) {
		cellules.get(x + y * game.getSize().x).removeAll();
		cellules.get(x + y * game.getSize().x).add(
				new JLabel(equivalents.get(type)), BorderLayout.CENTER);
		System.out.println(type + " " + x + " " + y);
	}

	private String getCellule(int x, int y) {
		Iterator<String> it = equivalents.keySet().iterator();
		if (cellules.get(x + y * game.getSize().x).getComponentCount() == 0)
			return "";
		while (it.hasNext()) {
			String str = it.next();
			if (equivalents.get(str) == (((JLabel) cellules.get(
					x + y * game.getSize().x).getComponent(0)).getIcon()))
				return str;
		}
		return "";
	}

	private String getCellule(int pos) {
		Iterator<String> it = equivalents.keySet().iterator();
		if (cellules.get(pos).getComponentCount() == 0)
			return "";
		while (it.hasNext()) {
			String str = it.next();
			if (equivalents.get(str) == (((JLabel) cellules.get(pos)
					.getComponent(0)).getIcon()))
				return str;
		}
		return "";
	}

	public void setVue(Vue vue) {

		this.vue = vue;

		game.getFrame().setTitle("Virtual War | Joueur " + vue.getEquipe());

		for (JPanel cellule : cellules) {
			cellule.removeAll();
		}

		Cellule[][] cellules = vue.getPlateau().getPlateau();
		for (int i = 0; i < cellules.length; i++) {
			for (int j = 0; j < cellules[0].length; j++) {
				if (cellules[i][j] instanceof Base) {
					Base base = (Base) cellules[i][j];
					if (base.getEquipe() == vue.getEquipe()) {
						this.setCellule("base", i, j);
					} else {
						this.setCellule("enemy_base", i, j);
					}
				} else if (cellules[i][j] instanceof Case) {
					Case cas = (Case) cellules[i][j];
					if (cas.getContenu() != null)
						if (cas.getContenu().getEquipe() == vue.getEquipe()) {
							this.setCellule(cas.getContenu().getType()
									.toLowerCase(), i, j);
						} else {
							this.setCellule("enemy_"
									+ cas.getContenu().getType().toLowerCase(),
									i, j);
						}
					else if (cas.getMine() == vue.getEquipe())
						this.setCellule("mine", i, j);
					else if (cas.isObstacle() == true)
						this.setCellule("mur", i, j);
				}
			}
		}

		SwingUtilities.updateComponentTreeUI(this);

	}
}
