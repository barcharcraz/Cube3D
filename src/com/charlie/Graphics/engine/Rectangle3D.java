package com.charlie.Graphics.engine;

/**
 * Created by IntelliJ IDEA.
 * User: Charlie
 * Date: 1/31/11
 * Time: 9:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class Rectangle3D extends Shape3D {
    /**
     * creates a 1.0x1.0 rectangle with the bottom left corner at 0.0
     */
    public Rectangle3D () {
        super(4);
        double[] vertArray = {0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0};
        setFromVertexList(vertArray);
        

    }
    public Rectangle3D(double[] vertArray) {
        super(4);
        setFromVertexList(vertArray);
    }
}
