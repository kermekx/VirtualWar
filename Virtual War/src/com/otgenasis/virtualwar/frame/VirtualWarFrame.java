package com.otgenasis.virtualwar.frame;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class VirtualWarFrame extends JFrame {

	private double width;
	private double height;
	private boolean fullScreen = false;

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
	 * Rend la fenetre en mode pleinne ecran
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
		
		if(isDisplayable())dispose();
		
		setResizable(false);
		setUndecorated(true);
		
		device.setFullScreenWindow(this);
		
		setVisible(true);
	}
	
	public void setWindow() {
		
		setVisible(false);
		
		GraphicsDevice device = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getScreenDevices()[0];
		
		device.setFullScreenWindow(null);
		
		if(isDisplayable())dispose();
		
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

	public boolean isFullScreen() {
		return fullScreen;
	}

	public void switchView() {
		if(fullScreen) 
			setWindow();
		else
			setFullScreen();
	}

}
