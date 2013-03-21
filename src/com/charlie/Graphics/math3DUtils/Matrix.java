package com.charlie.Graphics.math3DUtils;

import java.util.Arrays;

/**
 * Class matrix represents a matrix and operations that can be done on it.
 * 
 * subclasses can be used to specify matrices used for specific things such as translation and rotation
 * 
 * Created by IntelliJ IDEA.
 * User: Charlie
 * Date: 1/24/11
 * Time: 2:37 PM
 * this class represents the mathmatical concept of a matrix
 */
public class Matrix {

    protected double[][] matrix;

    /**
     * initilize the matrix
     * @param n number of columns
     * @param m number of rows
     */
    public Matrix(int n, int m) {
        matrix = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = 0.0;
            }
        }
    }
    /**
     * sets this matrix to be an identity matrix, this will only work is the matrix is square
     */
    public void setToIdentity() {
    	if(getRows() == getColumns()) {
	    	for(int i = 0; i<getColumns(); i++) {
	    		matrix[i][i] = 1;
	    	}
    	} else {
    		throw new java.lang.UnsupportedOperationException("the matrix must be square");
    	}
    }
    /**
     * get the value of the i,jth element of this matrix
     * @param i the row to access
     * @param j the column to access
     * @return the value at i,j
     */
    public double getValue(int i, int j) {
        return matrix[i][j];
    }
    /**
     * set the value of the i,jth element in the matrix
     * @param i the row of the element to set
     * @param j the column of the element to set
     * @param value the value to set element i,j to
     */
    public void setValue(int i, int j, double value) {
        matrix[i][j] = value;
    }

    /**
     * gets the number of columns
     * @return the number of columns
     */
    public int getColumns() {
        return matrix[0].length;
    }

    /**
     * get the number of rows
     * @return the number of rows
     */
    public int getRows() {
        return matrix.length;
    }

    /**
     * gets a vector representing column j of this matrix
     * @param j the column tog et a vector representation of
     * @return a vector representing the column j
     */
    public Vector getColumnVector(int j) {
        double[] tempArray = new double[this.getRows()];
        for (int i = 0; i < this.getRows(); i++) {
            tempArray[i] = matrix[i][j];
        }
        return new Vector(tempArray);
    }

    /**
     * gets a vector representing a row of this matrix
     * @param i the row to get the vector representation of
     * @return the vector representation of row i
     */
    public Vector getRowVector(int i) {
        return new Vector(matrix[i]);
    }

    /**
     * Finds the cross product between this matrix and matrix m.
     *
     * @param rightMatrix the matrix to find the cross product with
     * @return the resulting matrix of the cross product operation
     * @throws IllegalArgumentException Matrix m must have the same number of rows as the other matrix has columns, otherwise the operation is undefined and this will throw an exception
     */
    public Matrix multiply(Matrix rightMatrix) throws IllegalArgumentException {
        //only run if the operation is defined
        if (this.getColumns() == rightMatrix.getRows()) {
            Matrix result = new Matrix(this.getRows(), rightMatrix.getColumns());
            for (int k = 0; k<result.getColumns(); k++) {
	            for (int i = 0; i < result.getRows(); i++) {
	                for (int j = 0; j < this.getColumns(); j++) {
	                    //calculate the value of index i,j in the result matrix
	                    result.setValue(i, k, result.getValue(i, k) + this.getValue(i, j) * rightMatrix.getValue(j, k));
	                }
	            }
            }
            return result;
        } else {
            throw new IllegalArgumentException("the argument martix must have the same number of rows as the other matrix has columns");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Matrix m = (Matrix) o;
        if (this.getRows() != m.getRows() || this.getColumns() != m.getColumns()) {
            return false;
        }
        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getColumns(); j++) {
                if (m.getValue(i, j) != this.getValue(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Arrays.deepHashCode(this.matrix);
        return hash;
    }
    
    @Override
    public String toString() {
        String stringRep = "";
        for(int i = 0; i<this.getRows(); i++) {
            for(int j=0;j<this.getColumns();j++) {
                stringRep+=this.getValue(i, j) + ", ";
            }
            stringRep+="\n";
        }
        return stringRep;
    }
}
