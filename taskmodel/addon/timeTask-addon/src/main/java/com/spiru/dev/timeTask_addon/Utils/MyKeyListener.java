package com.spiru.dev.timeTask_addon.Utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener  {
	
	private JPanelPlayGround panel;

	public MyKeyListener(JPanelPlayGround panel){
		this.panel = panel;
	}
	
	public void keyPressed(KeyEvent k) {
		//				
	}

	public void keyReleased(KeyEvent e) {
		//
	}

	public void keyTyped(KeyEvent e) {
		panel.setModified();
		// only numbers and '.'
		char c = e.getKeyChar();			
		if (panel.isCorrected()){
			e.setKeyChar('\0');
		}			
	}	
}
