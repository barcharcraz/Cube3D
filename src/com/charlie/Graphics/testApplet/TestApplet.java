package com.charlie.Graphics.testApplet;
import com.charlie.Graphics.engine.*;

import java.applet.Applet;
import java.awt.Graphics;

import com.charlie.Graphics.engine.GraphicsPane;
import com.charlie.Graphics.math3DUtils.TransformationMatrix;

public class TestApplet extends javax.swing.JApplet {
	private static GraphicsPane panel;
	TransformationMatrix cubeTransform = new TransformationMatrix();
	Cube theObject;
	public void init() {
		panel = new GraphicsPane();
        panel.setSize(640,480);
        this.getContentPane().add(panel);
        
        theObject = new Cube(-.25,-.25,-.25,.5,.5,.5);
        
        theObject.setTransformationMatrix(cubeTransform);
        //cubeTransform.sacle(0.25, 0.25, 0.25);
        //cubeTransform.sacle(100, 100, 100);
        //cubeTransform.rotateX(45);
        cubeTransform.translate(.5, 0, -2.25);
        
        
        
        
        System.out.println(panel.getRefreshRate());
        
	}
	public void start() {
		panel.setDoubleBuffered(true);
        
        
        panel.addObject(theObject);
        GraphicsApplication app = new Game(panel);
        panel.grabFocus();
        
        app.setFramerate(30);
        Thread appThread = new Thread(app);
        appThread.start();
		
		
	}
	
	public void stop() {
		
	}
	

}
