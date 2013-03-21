package com.charlie.Graphics.engine;

import javax.swing.*;

import com.charlie.Graphics.engine.*;
import com.charlie.Graphics.math3DUtils.Matrix;
import com.charlie.Graphics.math3DUtils.ProjectionMatrix;
import com.charlie.Graphics.math3DUtils.ViewportMatrix;


import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Component that represents the render target, the scene, and the device. Honestly this is the way things
 * were done in like 2000 but it makes for a simplet API and since I dont need fine grained control over
 * the device(because there is no device really) this sort of thing works fine. 
 * 
 * Shapes are added to this component to specify the scene and methods on this object set the "state" of the
 * device for this scene.
 * 
 * 
 * Created by IntelliJ IDEA.
 * User: Charlie
 * Date: 1/13/11
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphicsPane extends JPanel {
    private ArrayList<Shape3D> shapeBuffer;
    public GraphicsPane() {
        shapeBuffer = new ArrayList<Shape3D>();
        addComponentListener(new paneListener());
        
        

    }
    public void paintComponent(Graphics g) {
    	super.paintComponents(g);
        Graphics2D graphicsContext = (Graphics2D)g;
        graphicsContext.clearRect(0, 0, getWidth(), getHeight());
        //graphicsContext.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC, 1.0f));

        for(int i = 0; i<shapeBuffer.size(); i++) {
        	
        	graphicsContext.draw(shapeBuffer.get(i));
        }
    }
    public int getRefreshRate() {
        return this.getGraphicsConfiguration().getDevice().getDisplayMode().getRefreshRate();
    }
    public void addShape(Shape3D s) {
    	s.setViewportMatrix(getViewportMatrix());
    	s.setProjectionMatrix(new ProjectionMatrix(45.0, 45.0, 0.0, 1.0));
        shapeBuffer.add(s);
    }
    public void addObject(Object3D s) {
        for (int i = 0; i<s.getNumFaces(); i++) {
            addShape(s.getFace(i));
        }
    }
    public void setViewMatrix(Matrix m) {
    	for(int i = 0; i<shapeBuffer.size(); i++) {
    		shapeBuffer.get(i).setViewMatrix(m);
    	}
    }
    public void setProjectionMatrix() {
    	for(int i = 0; i<shapeBuffer.size(); i++) {
    		shapeBuffer.get(i).setProjectionMatrix(new ProjectionMatrix(45.0, 45.0, 0.0, 1.0));
    	}
    }
    private void resizeViewport() {
    	for(int i = 0; i<shapeBuffer.size(); i++) {
    		shapeBuffer.get(i).setViewportMatrix(getViewportMatrix());
    	}
    }
    
    private ViewportMatrix getViewportMatrix() {
    	return new ViewportMatrix((double)this.getWidth(), (double)this.getHeight());
    }
    public void addInputListener(InputListener i) {
	    if(i instanceof MouseMotionListener) {
	    	this.addMouseMotionListener(i);
		}
	    if (i instanceof KeyListener) {
	    	System.out.println("add KeyL");
			this.addKeyListener(i);
		}
	    if (i instanceof MouseListener) {
			this.addMouseListener(i);
		}
    }
    class paneListener implements java.awt.event.ComponentListener {

		@Override
		public void componentHidden(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentMoved(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentResized(ComponentEvent arg0) {
			resizeViewport();
			System.out.println("resize fire");
			
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}
    	
    }
    

}
