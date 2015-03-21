package com.otgenasis.virtualwar.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.otgenasis.virtualwar.VirtualWar;

/**
 * affichage du menu principale
 * 
 * @author kevin MESSIAEN
 *
 */
public class MenuComponent extends BaseComponent {

	/**
	 * generated serial version ID
	 */
	private static final long serialVersionUID = -8623759935837046445L;

	public MenuComponent(VirtualWar vw) {
		super(vw);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		drawBackground(g2d, Color.DARK_GRAY);

		drawTittle(g2d, "Virtual War");

		if (pressed == 1)
			drawCenteredButton(g2d, "Jouer", 0.3d, Color.BLACK);
		else if (hover == 1)
			drawCenteredButton(g2d, "Jouer", 0.3d, Color.DARK_GRAY);
		else
			drawCenteredButton(g2d, "Jouer", 0.3d, Color.GRAY);
		if (pressed == 2)
			drawCenteredButton(g2d, "Options", 0.5d, Color.BLACK);
		else if (hover == 2)
			drawCenteredButton(g2d, "Options", 0.5d, Color.DARK_GRAY);
		else
			drawCenteredButton(g2d, "Options", 0.5d, Color.GRAY);
		if (pressed == 3)
			drawCenteredButton(g2d, "Quitter", 0.7d, Color.BLACK);
		else if (hover == 3)
			drawCenteredButton(g2d, "Quitter", 0.7d, Color.DARK_GRAY);
		else
			drawCenteredButton(g2d, "Quitter", 0.7d, Color.GRAY);

	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {

		Rectangle jouer = getTextBounds("Jouer", 0.3d);
		Rectangle option = getTextBounds("Option", 0.5d);
		Rectangle quitter = getTextBounds("Quitter", 0.7d);

		if (jouer.contains(mouseEvent.getPoint()))
			pressed = 1;
		else if (option.contains(mouseEvent.getPoint()))
			pressed = 2;
		else if (quitter.contains(mouseEvent.getPoint()))
			pressed = 3;
		else
			pressed = 0;

		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {

		Rectangle jouer = getTextBounds("Jouer", 0.3d);
		Rectangle option = getTextBounds("Option", 0.5d);
		Rectangle quitter = getTextBounds("Quitter", 0.7d);

		if (jouer.contains(mouseEvent.getPoint()))
			;
		else if (option.contains(mouseEvent.getPoint())) {
			removeMouseListener(this);
			removeMouseMotionListener(this);
			vw.setContentPane(new OptionComponent(vw));
		} else if (quitter.contains(mouseEvent.getPoint()))
			System.exit(0);

		pressed = 0;

		repaint();

	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent) {

		int lastHover = hover;

		Rectangle jouer = getTextBounds("Jouer", 0.3d);
		Rectangle option = getTextBounds("Option", 0.5d);
		Rectangle quitter = getTextBounds("Quitter", 0.7d);

		if (jouer.contains(mouseEvent.getPoint()))
			hover = 1;
		else if (option.contains(mouseEvent.getPoint()))
			hover = 2;
		else if (quitter.contains(mouseEvent.getPoint()))
			hover = 3;
		else
			hover = 0;

		if (lastHover != hover)
			repaint();

	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {

		int lastHover = hover;

		Rectangle jouer = getTextBounds("Jouer", 0.3d);
		Rectangle option = getTextBounds("Option", 0.5d);
		Rectangle quitter = getTextBounds("Quitter", 0.7d);

		if (jouer.contains(mouseEvent.getPoint()))
			hover = 1;
		else if (option.contains(mouseEvent.getPoint()))
			hover = 2;
		else if (quitter.contains(mouseEvent.getPoint()))
			hover = 3;
		else
			hover = 0;

		if (lastHover != hover)
			repaint();
	}

}
