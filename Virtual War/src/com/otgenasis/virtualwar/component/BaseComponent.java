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

public abstract class BaseComponent extends JComponent implements
		MouseListener, MouseMotionListener {

	protected final VirtualWar vw;

	protected Rectangle bounds;

	protected Font font;
	protected FontMetrics fm;

	protected int pressed, hover;

	public BaseComponent(VirtualWar vw) {

		this.vw = vw;

		addMouseListener(this);
		addMouseMotionListener(this);

	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);

		bounds = vw.getFrameBounds();

		setFont(g);
	}

	protected void drawBackground(Graphics2D g2d, Color color) {

		g2d.setColor(color);
		g2d.fillRect(0, 0, bounds.width, bounds.height);

	}

	protected void drawTittle(Graphics2D g2d, String text) {

		int textWidth = fm.stringWidth(text);

		g2d.setColor(Color.GREEN);

		g2d.drawString(text, (int) (bounds.width * 0.5d - textWidth * 0.5d),
				(int) (bounds.height * 0.1d));

	}

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

	protected Rectangle getTextBounds(String text, double y) {

		int textWidth = fm.stringWidth(text);
		int textHeight = fm.getHeight();

		return new Rectangle((int) (bounds.width * 0.5d - textWidth * 0.52d),
				(int) (bounds.height * (y - 0.02d) - textHeight * 0.52d),
				(int) (textWidth * 1.04d), (int) (textHeight * 1.04d));
	}

	private void setFont(Graphics g) {

		font = new Font("font", Font.PLAIN, (int) (bounds.width * 0.05d));
		g.setFont(font);
		fm = g.getFontMetrics();

	}

}
