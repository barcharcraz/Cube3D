/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.charlie.Graphics.engine;

import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.*;


import com.charlie.Graphics.math3DUtils.*;


/**
 * Class Shape specifies a shape in 3D, this shape will most often correspond to a face but there is no reason
 * that all of the vertexes in it have to be coplaner
 * 
 * @author Charlie
 *
 */
public class Shape3D implements java.awt.Shape {

    private Vertex[] verts;
    private Vertex[] transformedVerts;
    private Vertex[] viewportVerts;
    private Vertex[] projectedVerts;
    private Matrix projectionMatrix;
    private Path2D.Double shapePath;
    private Matrix worldMatrix;
    private Matrix viewMatrix;
    private Matrix modelViewMatrix;
    private Matrix viewportMatrix;
    /**
     * 
     * @param size the number of vertices in the shape
     */
    public Shape3D(int size) {
        verts = new Vertex[size];
        for (int i = 0; i < verts.length; i++) {
            verts[i] = new Vertex();
        }
        worldMatrix = new TransformationMatrix();
        viewMatrix = new TransformationMatrix();

    }
    /**
     * Set the vertex data for this shape by using an array of points specified in the format
     * {x,y,z,w,x,y,z,w,...}
     * @param list
     */
    public void setFromVertexList(double[] list) {
        System.out.println(list.toString());
        ArrayList<Double> tempList = new ArrayList<Double>();
        for (int i = 0; i < list.length; i++) {
            tempList.add(Double.valueOf(list[i]));
        }
        for (int i = 0; i < verts.length; i++) {

            verts[i].x = tempList.remove(0).doubleValue();
            System.out.print(i +","+ verts[i].x + "|");
            verts[i].y = tempList.remove(0).doubleValue();
            System.out.print(i +","+ verts[i].y + "|");
            verts[i].z = tempList.remove(0).doubleValue();
            System.out.println(i +","+ verts[i].z);
            verts[i].w = tempList.remove(0).doubleValue();
            //System.out.println(i+ " " + j);

        }
    }
    /**
     * Get all of the X vertices in this shape
     * @return double[], ist of X verts
     */
    public double[] getVertsX() {
        double[] xVerts = new double[verts.length];
        for (int i = 0; i < verts.length; i++) {
            xVerts[i] = verts[i].x;

        }
        return xVerts;
    }
    /**
     * Get all of the Y vertices in this shape
     * @return double[], list of Y verts
     */
    public double[] getVertsY() {
        double[] yVerts = new double[verts.length];
        for (int i = 0; i < verts.length; i++) {
            yVerts[i] = verts[i].y;

        }
        return yVerts;

    }

    public Rectangle getBounds() {
        return this.getBounds2D().getBounds();


    }

    public Rectangle2D getBounds2D() {
        double smallestX = verts[0].x;
        double largestX = verts[0].x;
        double smallestY = verts[0].y;
        double largestY = verts[0].y;
        for (int i = 0; i < verts.length; i++) {

            if (verts[i].x < smallestX) {
                smallestX = verts[i].x;
            }
            if (verts[i].x > largestX) {
                largestX = verts[i].x;
            }
            if (verts[i].y < smallestY) {
                smallestY = verts[i].y;
            }
            if (verts[i].y > largestY) {
                largestY = verts[i].y;
            }



        }
        return new Rectangle2D.Double(smallestX, largestY, largestX - smallestX, largestY - smallestY);
    }

    public boolean contains(double x, double y) {
        return shapePath.contains(x,y);
    }
    /**
     * sets the projection matrix to be a basic orthographic matrix
     * 
     * this may be incompatible with Z checking and uniform scaling
     * 
     * @deprecated this has been moved into the ProjectionMatrix class
     */
    @Deprecated
    public void setProjectionMatrixOrthagraphic() {
        projectionMatrix = new Matrix(3, 3);
        projectionMatrix.setValue(0, 0, 1);
        projectionMatrix.setValue(1, 1, 1);

    }
    /*
     * BEGIN pipeline matrix setters, notice that these setters take generic matrix arguments and not
     * the specialized types, this is so that wacky pipelines can be accomplished. For example using a
     * strange viewport matrix one could have non-rectangular viewports and other interesting things
     */
    /**
     * 
     * @param m matrix to set the projection matrix to
     */
    public void setProjectionMatrix(Matrix m) {
        projectionMatrix = m;
    }
    /**
     * set the view matrix
     * @param m the new view matrix
     */
    public void setViewMatrix(Matrix m) {
    	viewMatrix = m;
    	updateModelView();
    }
    /**
     * 
     * @param newT matrix to set the transformation matrix to
     */
    public void setTransformationMatrix(Matrix newT) {
    	if(newT.getRows() == 4 && newT.getColumns() == 4) {
    		worldMatrix = newT;
    		updateModelView();
    	} else {
    		throw new java.lang.IllegalArgumentException("transformation matrix must be a 4x4 matrix");
    	}
    }
    /**
     * 
     * @param newV matrix to set the viewport to
     */
    public void setViewportMatrix(Matrix newV) {
    	if(newV.getRows() == 4 && newV.getColumns() == 4) {
    		viewportMatrix = newV;
    	} else {
    		throw new java.lang.IllegalArgumentException("Viewport matrix must be a 4x4 matrix");
    	}
    }
    
    /**
     * apply the transformation matrix
     */
    private void transform() {
    	transformedVerts = new Vertex[verts.length];

    	for(int i = 0; i<transformedVerts.length; i++) {
    		transformedVerts[i] = new Vertex();
    		transformedVerts[i].setFromMatrixUsingColumnOrder(modelViewMatrix.multiply(verts[i].getMatrixAsColumnOrder()));
    	}
    	
    }
    
    private void project() {
    	projectedVerts = new Vertex[transformedVerts.length];
    	for(int i = 0; i<projectedVerts.length; i++) {
    		projectedVerts[i] = new Vertex();
    		projectedVerts[i].setFromMatrixUsingColumnOrder(projectionMatrix.multiply(transformedVerts[i].getMatrixAsColumnOrder()));
    	}
    }
    private void convertToPath() {
        shapePath = new Path2D.Double();
        Vertex currentPoint;
        for (int i = 0; i<viewportVerts.length; i++) {
        	currentPoint = viewportVerts[i];
            
            currentPoint.homogeneousDivide();
            if (i == 0) {
                shapePath.moveTo(currentPoint.x, currentPoint.y);
            } else {
                shapePath.lineTo(currentPoint.x, currentPoint.y);
            }
        }
        shapePath.closePath();
    }
    
    private void viewportTransform() {
    	viewportVerts = new Vertex[projectedVerts.length];
    	for(int i = 0; i<viewportVerts.length; i++) {
    		viewportVerts[i] = new Vertex();
    		viewportVerts[i].setFromMatrixUsingColumnOrder(viewportMatrix.multiply(projectedVerts[i].getMatrixAsColumnOrder()));
    	}
    	
    }
    
    private void updateModelView() {
    	modelViewMatrix = viewMatrix.multiply(worldMatrix);
    }

    public boolean contains(Point2D p) {
        return shapePath.contains(p);
    }

    public boolean intersects(double x, double y, double w, double h) {
        return shapePath.intersects(x, y, w, h);

    }

    public boolean intersects(Rectangle2D r) {
        return shapePath.intersects(r);
    }

    public boolean contains(double x, double y, double w, double h) {
        return shapePath.contains(x,y,w,h);
    }

    public boolean contains(Rectangle2D r) {
        return shapePath.contains(r);
    }

    public PathIterator getPathIterator(AffineTransform at) {
    	transform();
        project();
        viewportTransform();
        convertToPath();
        
        return shapePath.getPathIterator(at);
    }

    public PathIterator getPathIterator(AffineTransform at, double flatness) {
    	transform();
        project();
        viewportTransform();
        convertToPath();
        return shapePath.getPathIterator(at, flatness);
    }
}
