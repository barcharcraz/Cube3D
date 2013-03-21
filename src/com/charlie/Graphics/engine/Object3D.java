package com.charlie.Graphics.engine;

import com.charlie.Graphics.math3DUtils.Matrix;
import com.charlie.Graphics.math3DUtils.TransformationMatrix;

/**
 * Represents a full object in 3D space. basically this object contains a bundle(ArrayList)
 * of faces that correspond to the object. This corresponds to a triangle list(well a polygon list). If
 * someone wanted to make say an object that was defined by some sort of a mesh file they could do that
 * by extending this class
 * 
 * Created by IntelliJ IDEA.
 * User: Charlie
 * Date: 1/31/11
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Object3D {
    protected Shape3D[] faces;
    public Object3D(int size) {
        faces = new Shape3D[size];
    }
    public void setFace(int index, Shape3D shape) {
        faces[index] = shape;
    }
    public Shape3D getFace(int index) {
        return faces[index];

    }
    public int getNumFaces() {
        return faces.length;
    }
    public void setTransformationMatrix(TransformationMatrix m) throws IllegalArgumentException {
    	if(m.getColumns() == 4 && m.getRows() == 4) {
	    	for(int i = 0; i<faces.length; i++) {
	    		faces[i].setTransformationMatrix(m);
	    	}
    	} else {
    		throw new IllegalArgumentException("Argument must be a 4x4 matrix");
    	}
    }
}
