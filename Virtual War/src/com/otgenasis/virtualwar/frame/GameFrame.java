package com.otgenasis.virtualwar.frame;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

	public GameFrame() {

		this.setTitle("Virtual War | O.T. Genasis");
		this.setIconImage(new ImageIcon("images/icon.png").getImage());

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		Rectangle bounds = new Rectangle((int) (width * 0.25),
				(int) (height * 0.25), (int) (width * 0.5),
				(int) (height * 0.5));
		this.setBounds(bounds);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}

}
