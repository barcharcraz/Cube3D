package com.charlie.Graphics.math3DUtils;

/**
 * Created by IntelliJ IDEA.
 * User: Charlie
 * Date: 1/25/11
 * Time: 9:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class Vector {
    private double vector[];
    public Vector(int n) {
        vector = new double[n];

    }

    public Vector(double[] values) {
        vector = values.clone();
    }
    public Matrix getMatrixFromVector() {
        Matrix tempMatrix = new Matrix(vector.length,1);
        for(int i = 0; i<vector.length; i++) {
            tempMatrix.setValue(i,0,vector[i]);
        }
        return tempMatrix;
    }
    public void setValue(int index, double value) {
        vector[index] = value;
    }
    public int getLength() {
        return vector.length;
    }
    public double getValue(int index) {
        return vector[index];
    }
    public double dotProduct(Vector v) throws IllegalArgumentException {
        if(v.getLength() == this.getLength()) {
            double dprod = 0;
            for(int i = 0; i<this.getLength(); i++) {
                dprod += (this.getValue(i) * v.getValue(i));
            }
            return dprod;
        } else {
            throw new IllegalArgumentException("Vectors must be the same size");
        }

    }

}
