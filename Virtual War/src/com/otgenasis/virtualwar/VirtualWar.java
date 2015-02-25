package com.otgenasis.virtualwar;

import com.otgenasis.virtualwar.frame.VirtualWarFrame;

public class VirtualWar {

	public static void main(String[] args) {
		
		boolean fullScreen = false;
		
		for (String arg : args) {
			if(arg.equals("-f"))
				fullScreen = true;
		}

		VirtualWarFrame frame = new VirtualWarFrame();
		
		if(fullScreen)
			frame.setFullScreen();

		frame.setVisible(true);

	}

}
