package com.otgenasis.virtualwar;

import java.awt.Component;
import java.awt.Rectangle;

import com.otgenasis.virtualwar.component.MenuComponent;
import com.otgenasis.virtualwar.frame.VirtualWarFrame;

/**
 * classe principale du jeu <BR>
 * contient le main
 * 
 * @author kevin MESSIAEN
 *
 */
public class VirtualWar implements Runnable {

	/**
	 * Frame principale du jeu
	 */
	private VirtualWarFrame frame;

	/**
	 * Crée une instance principale pour le jeu
	 * 
	 * @param frame
	 *            principale du jeu
	 */
	public VirtualWar(VirtualWarFrame frame) {

		this.frame = frame;

	}

	/**
	 * lancement du programme <BR>
	 * Creé une Frame et une instance de jeu <BR>
	 * envoie au menu principale
	 * 
	 * @param args
	 *            : <BR>
	 *            -f : mode plein écran dès le lancement <BR>
	 *            -d : mode débuggage
	 */
	public static void main(String[] args) {

		boolean fullScreen = false;

		for (String arg : args) {
			if (arg.equals("-f"))
				fullScreen = true;
		}

		VirtualWarFrame frame = new VirtualWarFrame();

		if (fullScreen)
			frame.setFullScreen();

		frame.setVisible(true);

		VirtualWar virtualWar = new VirtualWar(frame);
		Thread virtualWarThread = new Thread(virtualWar, "VirtualWar");
		virtualWarThread.run();

	}

	/**
	 * lance le jeu en affichant le menu
	 */
	@Override
	public void run() {

		setContentPane(new MenuComponent(this));

	}

	/**
	 * Rend la Frame en mode plein écran si elle est en mode fenetre <BR>
	 * Et vice versa
	 */
	public void switchView() {
		frame.switchView();
	}

	/**
	 * Change le contenue à afficher
	 * 
	 * @param component
	 *            nouvelle affichage de la Frame
	 */
	public void setContentPane(Component component) {

		frame.getContentPane().removeAll();
		frame.getContentPane().add(component);
		frame.getContentPane().revalidate();
		frame.repaint();

	}

	/**
	 * retourne la position est la taille de la Frame
	 * 
	 * @return bounds (Rectangle)
	 */
	public Rectangle getFrameBounds() {
		return frame.getBounds();
	}

	/**
	 * Renvoie le mode d'affichage de la Frame
	 * 
	 * @return true si la Frame est en plein écran <BR>
	 *         false si la Frame est en mode fenetre
	 */
	public boolean isFullScreen() {
		return frame.isFullScreen();
	}

}
