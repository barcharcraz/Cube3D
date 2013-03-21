/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.charlie.Graphics.engine;

import com.charlie.Graphics.math3DUtils.Matrix;

/**
 * Class Vertex is a structure representing a vertex with x,y,z, and w components. If a programmer
 * wanted to add color data or normal data or something simillar to their verts then they would extend
 * this class
 * 
 *
 * @author Charlie
 * 
 */
public class Vertex {
    double x;
    double y;
    double z;
    double w;

    public void setFromMatrixUsingColumnOrder(Matrix m) {
    	//check to see if the argument is actually a vector holding position information
    	x=m.getValue(0, 0);
    	y = m.getValue(1, 0);
    	z = m.getValue(2, 0);
    	w = m.getValue(3, 0);
    }
    /**
     * get a matrix representing this vertex using Column-Major ordering
     * @return matrix repersenting this vertex
     */
    public Matrix getMatrixAsColumnOrder() {
    	Matrix temp;
    	temp = new Matrix(4,1);
    	temp.setValue(0,0,x);
    	temp.setValue(1, 0, y);
    	temp.setValue(2, 0, z);
    	temp.setValue(3, 0, w);
    	return temp;
    	
    	
    	
    }
    
    /**
     * This takes the vertex and divides the first n-1 elements and divides them by the nth element
     * (ie it devides x, y, and z by w)
     * 
     * Basically this makes it so things like projections that change the w value of the 
     * Homogeneous representation of the point actually work
     */
    public void homogeneousDivide() {
    	x/=w;
    	y/=w;
    	z/=w;
    	w/=w; //this is equal to 1, if I want to do like fog I may have to do stuff to this
    	
    }
    

}
