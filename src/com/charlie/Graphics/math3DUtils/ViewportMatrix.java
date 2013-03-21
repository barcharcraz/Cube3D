package com.charlie.Graphics.math3DUtils;

public class ViewportMatrix extends Matrix {
	/**
	 * generates a viewport matrix for a windows of of widthxheight, this assumes minz and maxz and 0 and 1 respectively.
	 * this does not move the vertexes as we are going to assume the viewport fills the whole
	 * window in this case
	 * @param width the width of the window
	 * @param height the height of the window
	 */
	public ViewportMatrix(double width, double height) {
		super(4,4);
		//scale up the x axis
		setValue(0,0,width/2.0);
		//scale up the y axis and also flip it
		setValue(1,1,(height/2.0)*-1);
		setValue(2,2,1);
		setValue(3,3,1);
		
		/*
		 * transform the vertex so that 1 is at width and -1 is at 0
		 */
		setValue(0,3,(width/2.0));
		setValue(1,3,(height/2.0));
		
	}

}
