package com.charlie.Graphics.engine;

import java.awt.event.MouseMotionListener;

import com.charlie.Graphics.math3DUtils.TransformationMatrix;

/**
 * Repersents any graphics application with a window and controles and such
 * @author Charlie
 *
 */
public class GraphicsApplication implements Runnable {
	protected GraphicsPane renderTarget;
	protected Camera cam;
	protected InputListener input;
	private long delay;
	public GraphicsApplication() {
		renderTarget = new GraphicsPane();
		cam = new Camera();
		setFramerate(30);
	}
	public GraphicsApplication(GraphicsPane rt) {
		cam = new Camera();
		renderTarget = rt;
	}
	public void addInputListener(InputListener inputListener) {
		this.input = inputListener;
		
		renderTarget.addInputListener(inputListener);
	}
	public void setFramerate(long fr) {
		delay = Math.round(1000.0/(double)fr);
	}
	protected void render() {
		renderTarget.repaint();
	}
	
	@Override
	public void run() {
		long time = System.currentTimeMillis();
		while(true) {
			render();
			try {
				time += delay;
				Thread.sleep(Math.max(0, time - System.currentTimeMillis()));
			} catch (InterruptedException e) {
				break;
			}
		}
		// TODO Auto-generated method stub
		
	}

}
