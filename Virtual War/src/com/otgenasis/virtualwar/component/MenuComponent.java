package com.otgenasis.virtualwar.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

import com.otgenasis.virtualwar.VirtualWar;

public class MenuComponent extends JComponent implements MouseListener, MouseMotionListener {

	/**
	 * generated serial version uid
	 */
	private static final long serialVersionUID = 7288039675705874525L;

	private final VirtualWar vw;

	private Rectangle bounds;

	private Font font;
	private FontMetrics fm;
	
	private int pressed, hover;

	public MenuComponent(VirtualWar vw) {

		this.vw = vw;
		
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		bounds = vw.getFrameBounds();

		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0, 0, bounds.width, bounds.height);

		setFont(g);

		if (pressed == 1)
			drawCenteredText(g2d, "Jouer", 0.3d, Color.BLACK);
		else if(hover == 1)
			drawCenteredText(g2d, "Jouer", 0.3d, Color.DARK_GRAY);
		else
			drawCenteredText(g2d, "Jouer", 0.3d, Color.GRAY);
		if (pressed == 2)
			drawCenteredText(g2d, "Options", 0.5d, Color.BLACK);
		else if(hover == 2)
			drawCenteredText(g2d, "Options", 0.5d, Color.DARK_GRAY);
		else
			drawCenteredText(g2d, "Options", 0.5d, Color.GRAY);
		if (pressed == 3)
			drawCenteredText(g2d, "Quitter", 0.7d, Color.BLACK);
		else if(hover == 3)
			drawCenteredText(g2d, "Quitter", 0.7d, Color.DARK_GRAY);
		else
			drawCenteredText(g2d, "Quitter", 0.7d, Color.GRAY);

	}

	public void setFont(Graphics g) {

		font = new Font("font", Font.PLAIN, (int) (bounds.width * 0.05d));
		g.setFont(font);
		fm = g.getFontMetrics();

	}

	public void drawCenteredText(Graphics2D g2d, String text, double y,
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
	
	public Rectangle getTextBounds(String text, double y) {
		
		int textWidth = fm.stringWidth(text);
		int textHeight = fm.getHeight();
		
		return new Rectangle((int) (bounds.width * 0.5d - textWidth * 0.52d),
				(int) (bounds.height * (y - 0.02d) - textHeight * 0.52d),
				(int) (textWidth * 1.04d), (int) (textHeight * 1.04d));
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
				
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
		
		if (jouer.contains(mouseEvent.getPoint()));
		else if (option.contains(mouseEvent.getPoint()));
		else if (quitter.contains(mouseEvent.getPoint()))
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
		
		if(lastHover != hover)
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
		
		if(lastHover != hover)
			repaint();
	}

}
