package com.charlie.Graphics.math3DUtils;
import static com.charlie.Graphics.math3DUtils.MathUtils.*;
/**
 * Projection Matrix represents a matrix that will be used for projection from 3D space onto 2D space
 * @author Charlie
 *
 */
public class ProjectionMatrix extends Matrix {
	public ProjectionMatrix() {
		super(4,4);
	}
	public ProjectionMatrix(double fovw, double fovh, double zn, double zf) {
		super(4,4);
		this.setPerspectiveProjection(fovw, fovh, zn, zf);
	}
	
	public void setPerspectiveProjection(double fovw, double fovh, double zn, double zf) {
		double w;
		double h;
		double q;
		w = cot(fovw/2);
		h = cot(fovh/2);
		q = zf/(zf-zn);
		
		matrix[0][0] = w;
		matrix[1][1] = h;
		matrix[2][2] = q;
		matrix[2][3] = -1*(q*zn);
		matrix[3][2] = 1;
		
	}

}
