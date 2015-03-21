package com.otgenasis.virtualwar.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

import com.otgenasis.virtualwar.VirtualWar;

/**
 * base des affichages
 * 
 * @author kevin MESSIAEN
 *
 */
public abstract class BaseComponent extends JComponent implements
		MouseListener, MouseMotionListener {

	/**
	 * generated serial version ID
	 */
	private static final long serialVersionUID = 5706167241448486809L;

	/**
	 * instance de la classe principale du jeu
	 */
	protected final VirtualWar vw;

	/**
	 * Pisition et taille de la Frame
	 */
	protected Rectangle bounds;

	/**
	 * Police utilisé lors des affichage de text
	 */
	protected Font font;
	/**
	 * Info complaimentaire sur la poice (Taille de rendu, ...)
	 */
	protected FontMetrics fm;

	/**
	 * ID du bouton de l'action
	 */
	protected int pressed, hover;

	/**
	 * Crée un écran d'affichage pour la Fram
	 * 
	 * @param vw
	 *            instance de la classe principale du jeu
	 */
	public BaseComponent(VirtualWar vw) {

		this.vw = vw;

		addMouseListener(this);
		addMouseMotionListener(this);

	}

	/**
	 * Boucle d'affichage <BR>
	 * A actualisé en cas de besoin en menu <BR>
	 * et a 60 FPS max en jeu
	 * 
	 * @param g
	 *            Graphics du rendu
	 */
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);

		bounds = vw.getFrameBounds();

		setFont(g);
	}

	/**
	 * rend une couleur de fond TODO ajoutez un drawn background avec une image
	 * 
	 * @param g2d
	 *            Graphics du rendu
	 * @param color
	 *            Couleur de fond
	 */
	protected void drawBackground(Graphics2D g2d, Color color) {

		g2d.setColor(color);
		g2d.fillRect(0, 0, bounds.width, bounds.height);

	}

	/**
	 * Affiche le titre du menu courant
	 * 
	 * @param g2d
	 *            Graphics du rendu
	 * @param text
	 *            nom du menu
	 */
	protected void drawTittle(Graphics2D g2d, String text) {

		int textWidth = fm.stringWidth(text);

		g2d.setColor(Color.GREEN);

		g2d.drawString(text, (int) (bounds.width * 0.5d - textWidth * 0.5d),
				(int) (bounds.height * 0.1d));

	}

	/**
	 * Affiche un bouton centré horizontalement TODO utilisez un JButton et des
	 * images
	 * 
	 * @param g2d
	 *            Graphics du rendu
	 * @param text
	 *            Nom du bouton
	 * @param y
	 *            Positon vertical (entre 0 et 1)
	 * @param color
	 *            Couleur de fond du bouton
	 */
	protected void drawCenteredButton(Graphics2D g2d, String text, double y,
			Color color) {

		int textWidth = fm.stringWidth(text);

		g2d.setColor(color);

		g2d.fill(getTextBounds(text, y));

		g2d.setColor(Color.BLACK);

		g2d.draw(getTextBounds(text, y));

		g2d.setColor(Color.GREEN);

		g2d.drawString(text, (int) (bounds.width * 0.5d - textWidth * 0.5d),
				(int) (bounds.height * y));

	}

	/**
	 * Retourne la position et la taille d'un text centré horizontalement <BR>
	 * utile pour les boutons
	 * 
	 * @param text
	 *            nom du bouton
	 * @param y
	 *            position vertical du bouton
	 * @return bounds du bouton
	 */
	protected Rectangle getTextBounds(String text, double y) {

		int textWidth = fm.stringWidth(text);
		int textHeight = fm.getHeight();

		return new Rectangle((int) (bounds.width * 0.5d - textWidth * 0.52d),
				(int) (bounds.height * (y - 0.02d) - textHeight * 0.52d),
				(int) (textWidth * 1.04d), (int) (textHeight * 1.04d));
	}

	/**
	 * Change la police d'affichage
	 * 
	 * @param g
	 *            Graphics du rendu
	 */
	private void setFont(Graphics g) {

		font = new Font("font", Font.PLAIN, (int) (bounds.width * 0.05d));
		g.setFont(font);
		fm = g.getFontMetrics();

	}

}
