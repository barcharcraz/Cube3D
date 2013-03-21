package com.charlie.Graphics.engine;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class TestInputListener extends InputListener {
	@Override
	public void mouseMoved(MouseEvent arg0) {
		if(arg0.getButton()==MouseEvent.BUTTON1) {
			//transform.translate(arg0.getX(), arg0.getY(), 0);
		} else {
			//transform.rotateTo(arg0.getY()/100.0*-1, arg0.getX()/100.0*-1, 0);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
