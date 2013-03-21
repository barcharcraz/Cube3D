package com.charlie.Graphics.engine;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import static java.awt.event.KeyEvent.*;

public class GameInputListener extends InputListener {
	private Camera camera;
	public GameInputListener() {
	}
	public void setCamera(Camera c) {
		camera = c;
	}
	public Camera getCamera() {
		return camera;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("key fire");
		switch(arg0.getKeyCode()) {
		case VK_W:
			camera.moveForward(.01);
			break;
		case VK_S:
			camera.moveBackward(.01);
			break;
		case VK_A:
			camera.moveLeft(0.01);
			break;
		case VK_D:
			camera.moveRight(0.01);
			break;
		case VK_LEFT:
			camera.rotateLeft(0.01);
			break;
		case VK_RIGHT:
			camera.rotateRight(0.01);
			break;
		case VK_UP:
			camera.rotateUp(0.01);
			break;
		case VK_DOWN:
			camera.rotateDown(0.01);
			break;
		case VK_Q:
			camera.moveUp(0.01);
		case VK_E:
			camera.moveUp(0.01);
			
		}
		
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
	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		
		
	}
}
