package com.otgenasis.virtualwar.component;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

import com.otgenasis.virtualwar.VirtualWar;

public class MenuComponent extends JComponent {
	
	private final VirtualWar vw;
	
	public MenuComponent(VirtualWar vw) {
		
		this.vw = vw;
		
	}
	
	@Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        Rectangle bounds = vw.getFrameBounds();
        
        Font font = new Font("font", Font.PLAIN, (int) (bounds.width * 0.05d));
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth("Jouer");
        int textHeight = fm.getHeight();
        
        g2d.drawRect((int) (bounds.width * 0.5d - textWidth * 0.52d), (int) (bounds.height * 0.28d - textHeight * 0.52d), (int) (textWidth * 1.02d), (int) (textHeight * 1.02d));     
        g2d.drawString("Jouer", (int) (bounds.width * 0.5d - textWidth * 0.5d), (int) (bounds.height * 0.3d));

    }

}
