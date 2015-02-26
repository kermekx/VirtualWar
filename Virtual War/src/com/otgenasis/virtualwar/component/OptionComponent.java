package com.otgenasis.virtualwar.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.otgenasis.virtualwar.VirtualWar;

public class OptionComponent extends BaseComponent {

	public OptionComponent(VirtualWar vw) {
		super(vw);
	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		bounds = vw.getFrameBounds();

		drawBackground(g2d, Color.DARK_GRAY);

		drawTittle(g2d, "Options");

		if (!vw.isFullScreen()) {
			if (pressed == 1)
				drawCenteredButton(g2d, "Plein Ecran", 0.3d, Color.BLACK);
			else if (hover == 1)
				drawCenteredButton(g2d, "Plein Ecran", 0.3d, Color.DARK_GRAY);
			else
				drawCenteredButton(g2d, "Plein Ecran", 0.3d, Color.GRAY);
		} else {
			if (pressed == 1)
				drawCenteredButton(g2d, "Fenetre", 0.3d, Color.BLACK);
			else if (hover == 1)
				drawCenteredButton(g2d, "Fenetre", 0.3d, Color.DARK_GRAY);
			else
				drawCenteredButton(g2d, "Fenetre", 0.3d, Color.GRAY);
		}

		if (pressed == 1)
			drawCenteredButton(g2d, "Retour", 0.7d, Color.BLACK);
		else if (hover == 3)
			drawCenteredButton(g2d, "Retour", 0.7d, Color.DARK_GRAY);
		else
			drawCenteredButton(g2d, "Retour", 0.7d, Color.GRAY);

		if (pressed == 3)
			drawCenteredButton(g2d, "Retour", 0.7d, Color.BLACK);
		else if (hover == 3)
			drawCenteredButton(g2d, "Retour", 0.7d, Color.DARK_GRAY);
		else
			drawCenteredButton(g2d, "Retour", 0.7d, Color.GRAY);

	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		int lastHover = hover;

		Rectangle screen;
		if (!vw.isFullScreen())
			screen = getTextBounds("Plein Ecran", 0.3d);
		else
			screen = getTextBounds("Fenetre", 0.3d);
		Rectangle retour = getTextBounds("Retour", 0.7d);

		if (screen.contains(mouseEvent.getPoint()))
			hover = 1;
		else if (retour.contains(mouseEvent.getPoint()))
			hover = 3;
		else
			hover = 0;

		if (lastHover != hover)
			repaint();
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		int lastHover = hover;

		Rectangle screen;
		if (!vw.isFullScreen())
			screen = getTextBounds("Plein Ecran", 0.3d);
		else
			screen = getTextBounds("Fenetre", 0.3d);
		Rectangle retour = getTextBounds("Retour", 0.7d);

		if (screen.contains(mouseEvent.getPoint()))
			hover = 1;
		else if (retour.contains(mouseEvent.getPoint()))
			hover = 3;
		else
			hover = 0;

		if (lastHover != hover)
			repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {

		Rectangle screen;
		if (!vw.isFullScreen())
			screen = getTextBounds("Plein Ecran", 0.3d);
		else
			screen = getTextBounds("Fenetre", 0.3d);
		Rectangle retour = getTextBounds("Retour", 0.7d);

		if (screen.contains(mouseEvent.getPoint()))
			pressed = 1;
		else if (retour.contains(mouseEvent.getPoint()))
			pressed = 3;
		else
			pressed = 0;

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {

		Rectangle screen;
		if (!vw.isFullScreen())
			screen = getTextBounds("Plein Ecran", 0.3d);
		else
			screen = getTextBounds("Fenetre", 0.3d);
		Rectangle retour = getTextBounds("Retour", 0.7d);

		if (screen.contains(mouseEvent.getPoint()))
			vw.switchView();
		else if (retour.contains(mouseEvent.getPoint())) {
			removeMouseListener(this);
			removeMouseMotionListener(this);
			vw.setContentPane(new MenuComponent(vw));
		}

		pressed = 0;

		repaint();

	}

}
