package com.otgenasis.virtualwar.frame;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Frame principale du jeu
 * 
 * @author kevin MESSIAEN
 *
 */
public class VirtualWarFrame extends JFrame {

	/**
	 * generated serial version ID
	 */
	private static final long serialVersionUID = 5908179841598029502L;

	/**
	 * Largeur de la Frame (pixel)
	 */
	private double width;

	/**
	 * hauteur de la frame (pixel)
	 */
	private double height;

	/**
	 * true si la Frame est en plein écran <BR>
	 * false si la Frame est en mode fenetre
	 */
	private boolean fullScreen = false;

	/**
	 * Crée la Frame du jeu
	 */
	public VirtualWarFrame() {
		super();

		this.setTitle("Virtual War  by O.T. Genasis");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		width = screenSize.getWidth() * 0.5d;
		height = screenSize.getHeight() * 0.5d;

		double posX = width * 0.5d;
		double posY = height * 0.5d;

		this.setBounds((int) posX, (int) posY, (int) width, (int) height);

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	/**
	 * Rend la Frame en mode plein écran
	 */
	public void setFullScreen() {

		setVisible(false);

		GraphicsDevice device = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getScreenDevices()[0];

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		width = screenSize.getWidth();
		height = screenSize.getHeight();

		fullScreen = true;

		this.setBounds(0, 0, (int) width, (int) height);

		if (isDisplayable())
			dispose();

		setResizable(false);
		setUndecorated(true);

		device.setFullScreenWindow(this);

		setVisible(true);
	}

	/**
	 * Rend la Frame en mode fenetre
	 */
	public void setWindow() {

		setVisible(false);

		GraphicsDevice device = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getScreenDevices()[0];

		device.setFullScreenWindow(null);

		if (isDisplayable())
			dispose();

		setResizable(true);
		setUndecorated(false);
		setVisible(true);

		pack();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		width = screenSize.getWidth() * 0.5d;
		height = screenSize.getHeight() * 0.5d;

		double posX = width * 0.5d;
		double posY = height * 0.5d;

		fullScreen = false;

		this.setBounds((int) posX, (int) posY, (int) width, (int) height);
	}

	/**
	 * Renvoie le mode d'affichage de la Frame
	 * 
	 * @return true si la Frame est en plein écran <BR>
	 *         false si la Frame est en mode fenetre
	 */
	public boolean isFullScreen() {
		return fullScreen;
	}

	/**
	 * Rend la Frame en mode plein écran si elle est en mode fenetre <BR>
	 * Et vice versa
	 */
	public void switchView() {
		if (fullScreen)
			setWindow();
		else
			setFullScreen();
	}

}
