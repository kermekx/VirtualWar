package com.otgenasis.virtualwar;

import java.awt.Component;
import java.awt.Rectangle;

import com.otgenasis.virtualwar.component.MenuComponent;
import com.otgenasis.virtualwar.frame.VirtualWarFrame;

public class VirtualWar implements Runnable {
	
	private VirtualWarFrame frame;
	
	public VirtualWar(VirtualWarFrame frame) {
		
		this.frame = frame;
		
	}

	public static void main(String[] args) {
		
		boolean fullScreen = false;
		
		//parcour les arguments
		for (String arg : args) {
			if(arg.equals("-f"))
				fullScreen = true;
		}

		VirtualWarFrame frame = new VirtualWarFrame();
		
		if(fullScreen)
			frame.setFullScreen();

		frame.setVisible(true);
		
		VirtualWar virtualWar = new VirtualWar(frame);
		Thread virtualWarThread = new Thread(virtualWar, "VirtualWar");
		virtualWarThread.run();

	}

	@Override
	public void run() {
		
		setContentPane(new MenuComponent(this));
		
	}
	

	public void switchView() {
		frame.switchView();
	}
	
	public void setContentPane(Component component) {
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(component);
		frame.getContentPane().revalidate();
		frame.repaint();
		
	}
	
	/**
	 * 
	 * @return position et taille de la fenetre
	 */
	public Rectangle getFrameBounds() {
		return frame.getBounds();
	}

	public boolean isFullScreen() {
		return frame.isFullScreen();
	}

}
