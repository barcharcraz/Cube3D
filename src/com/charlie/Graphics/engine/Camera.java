package com.charlie.Graphics.engine;

import com.charlie.Graphics.math3DUtils.TransformationMatrix;

public class Camera {
	private double x;
	private double y;
	private double z;
	private double rotX;
	private double rotY;
	private double rotZ;
	private TransformationMatrix viewMatrix;
	public Camera() {
		viewMatrix = new TransformationMatrix();
		x = 0;
		y = 0;
		z = 0;
		rotX = 0;
		rotY = 0;
		rotZ = 0;
	}
	public Camera(double x, double y, double z, double rotX, double rotY, double rotZ) {
		viewMatrix = new TransformationMatrix();
		setPosition(x, y, z, rotX, rotY, rotZ);
	}
	public void setPosition(double x, double y, double z, double rotX, double rotY, double rotZ) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		updateMatrix();
	}
	private void updateMatrix() {
		viewMatrix.rotateTo(-rotX, -rotY, -rotZ);
		viewMatrix.translateTo(-x, -y, -z);
	}
	public void rotate(double x, double y, double z) {
		viewMatrix.rotate(x, y, z);
	}
	public void moveForward(double amount) {
		z-=amount;
		updateMatrix();
	}
	public void moveBackward(double amount) {
		z+=amount;
		updateMatrix();
	}
	public void moveLeft(double amount) {
		x+=amount;
		updateMatrix();
	}
	public void moveRight(double amount) {
		x-=amount;
		updateMatrix();
	}
	public void moveUp(double amount) {
		y-=amount;
		updateMatrix();
	}
	public void moveDown(double amount) {
		y+=amount;
		updateMatrix();
	}
	public void rotateUp(double amount) {
		rotX-=amount;
		updateMatrix();
	}
	public void rotateDown(double amount) {
		rotX+=amount;
		updateMatrix();
	}
	public void rotateLeft(double amount) {
		rotY-=amount;
		updateMatrix();
	}
	public void rotateRight(double amount) {
		rotY+=amount;
		updateMatrix();
	}
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @return the z
	 */
	public double getZ() {
		return z;
	}
	/**
	 * @return the rotX
	 */
	public double getRotX() {
		return rotX;
	}
	/**
	 * @return the rotY
	 */
	public double getRotY() {
		return rotY;
	}
	/**
	 * @return the rotZ
	 */
	public double getRotZ() {
		return rotZ;
	}
	public TransformationMatrix getViewMatrix() {
		return viewMatrix;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
		updateMatrix();
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
		updateMatrix();
	}
	/**
	 * @param z the z to set
	 */
	public void setZ(double z) {
		this.z = z;
		updateMatrix();
	}
	/**
	 * @param rotX the rotX to set
	 */
	public void setRotX(double rotX) {
		this.rotX = rotX;
		updateMatrix();
	}
	/**
	 * @param rotY the rotY to set
	 */
	public void setRotY(double rotY) {
		this.rotY = rotY;
		updateMatrix();
	}
	/**
	 * @param rotZ the rotZ to set
	 */
	public void setRotZ(double rotZ) {
		this.rotZ = rotZ;
		updateMatrix();
	}
	
	
}
