package com.otgenasis.virtualwar.frame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

	private boolean fullScreen = false;

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

		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}

	public boolean isFullScreen() {
		return fullScreen;
	}

	public void switchScreen() {
		if (fullScreen) {
			this.setVisible(false);
			this.dispose();
			this.setExtendedState(Frame.NORMAL);
			this.setUndecorated(false);

			this.pack();

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double width = screenSize.getWidth();
			double height = screenSize.getHeight();

			Rectangle bounds = new Rectangle((int) (width * 0.25),
					(int) (height * 0.25), (int) (width * 0.5),
					(int) (height * 0.5));
			this.setBounds(bounds);

			this.setResizable(false);

			this.setVisible(true);
			fullScreen = false;
		} else {
			this.setVisible(false);
			this.dispose();

			this.setExtendedState(Frame.MAXIMIZED_BOTH);
			this.setUndecorated(true);
			this.pack();
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double width = screenSize.getWidth();
			double height = screenSize.getHeight();

			Rectangle bounds = new Rectangle(0, 0, (int) width, (int) height);
			this.setBounds(bounds);
			
			this.setVisible(true);
			fullScreen = true;
		}
	}

}
