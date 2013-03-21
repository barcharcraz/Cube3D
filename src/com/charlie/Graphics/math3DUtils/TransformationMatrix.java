package com.charlie.Graphics.math3DUtils;
//make math functions easer to deal with and read using a static import
import static java.lang.Math.*;
public class TransformationMatrix extends Matrix {
	public TransformationMatrix() {
		super(4,4);
		this.setToIdentity();
	}
	/**
	 * sets this matrix's scaling values, not that it is better to use the scaleUniform method
	 * for uniform scaling as that uses the 4th value in the homogeneous matrix to do scaleing and it is
	 * faster
	 * @param x x scale factor
	 * @param y y scale factor
	 * @param z z scale factor
	 */
	public void sacle(double x, double y , double z) {
		Matrix tempMatrix = new Matrix(4,4);
		tempMatrix.setToIdentity();
		tempMatrix.setValue(0, 0, x);
		tempMatrix.setValue(1, 1, y);
		tempMatrix.setValue(2, 2, z);
		//TODO: Clean this up
		//multiply this by the temp matrix and set the current instance's matrix to the matrix
		//of the result, not really that "clean" but is works
		this.matrix = this.multiply(tempMatrix).matrix;
	}
	/**
	 * uniformly scale the object
	 * @param s the scale factor
	 */
	public void scaleUniform(double s) {
		Matrix tempMatrix = new Matrix(4,4);
		tempMatrix.setToIdentity();
		tempMatrix.setValue(3, 3, 1/s);
		this.matrix = this.multiply(tempMatrix).matrix;
	}
	/**
	 * rotate around the X axis
	 * @param theta the amount to rotate in radians
	 */
	public void rotateX(double theta) {
		Matrix tempMatrix = new Matrix(4,4);
		tempMatrix.setToIdentity();
		tempMatrix.setValue(1, 1, cos(theta));
		tempMatrix.setValue(1, 2, sin(theta)*-1);
		tempMatrix.setValue(2, 1, sin(theta));
		tempMatrix.setValue(2, 2, cos(theta));
		this.matrix = this.multiply(tempMatrix).matrix;
	}
	/**
	 * rotate around the Y axis
	 * @param theta the amount to rotate in radians
	 */
	public void rotateY(double theta) {
		Matrix tempMatrix = new Matrix(4,4);
		tempMatrix.setToIdentity();
		tempMatrix.setValue(0, 0, cos(theta));
		tempMatrix.setValue(0, 2, sin(theta));
		tempMatrix.setValue(2, 0, sin(theta)*-1);
		tempMatrix.setValue(2, 2, cos(theta));
		this.matrix = this.multiply(tempMatrix).matrix;
	}
	/**
	 * rotate around the Z axis
	 * @param theta the amount to rotate in radians
	 */
	public void rotateZ(double theta) {
		Matrix tempMatrix = new Matrix(4,4);
		tempMatrix.setToIdentity();
		tempMatrix.setValue(0, 0, cos(theta));
		tempMatrix.setValue(0, 1, sin(theta)*-1);
		tempMatrix.setValue(1, 0, sin(theta));
		tempMatrix.setValue(1, 1, cos(theta));
		this.matrix = this.multiply(tempMatrix).matrix;
	}
	public void rotateTo(double x, double y, double z) {
		clearRotation();
		rotate(x,y,z);
	}
	/**
	 * clears any rotation that has been done on this shape 
	 */
	private void clearRotation() {
		this.setValue(0, 0, 1);
		this.setValue(0, 1, 0);
		this.setValue(0, 2, 0);
		this.setValue(1, 1, 1);
		this.setValue(1, 0, 0);
		this.setValue(1, 2, 0);
		this.setValue(2, 2, 1);
		this.setValue(2, 0, 0);
		this.setValue(2, 1, 0);
		
		
	}
	/**
	 * rotate around the X, Y, and Z axes in that order
	 * @param x the amount in radians to rotate around the x axis
	 * @param y the amount in radians to rotate around the y axis
	 * @param z the amount in radians to rotate around the z axis
	 */
	public void rotate(double x, double y, double z) {
		rotateX(x);
		rotateY(y);
		rotateZ(z);
	}
	/**
	 * clears the translation
	 */
	private void clearTranslation() {
		this.setValue(0, 3, 0);
		this.setValue(1, 3, 0);
		this.setValue(2, 3, 0);
	}
	/**
	 * changes the matrix to translate to a specific point instead of translateing from the current
	 * position
	 * @param x
	 * @param y
	 * @param z
	 */
	public void translateTo(double x, double y, double z) {
		clearTranslation();
		translate(x,y,z);
	}
	/**
	 * translate the object to a new position
	 * @param x the distance along the X axis to move the object
	 * @param y the distance along the Y axis to move the object
	 * @param z the distance along the Z axis to move the object
	 */
	public void translate(double x, double y, double z) {
		Matrix tempMatrix = new Matrix(4,4);
		tempMatrix.setToIdentity();
		tempMatrix.setValue(0, 3, x);
		tempMatrix.setValue(1, 3, y);
		tempMatrix.setValue(2, 3, z);
		this.matrix = this.multiply(tempMatrix).matrix;
	}

}
