package com.otgenasis.virtualwar;

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
		
		frame.getContentPane().add(new MenuComponent(this));
		
	}
	
	/**
	 * 
	 * @return position et taille de la fenetre
	 */
	public Rectangle getFrameBounds() {
		return frame.getBounds();
	}

}
