/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.charlie.Graphics.engine;
import java.awt.*;
import java.awt.geom.*;
import java.awt.Shape;

import com.charlie.Graphics.math3DUtils.*;

import static java.lang.Math.*;
/**
 * Class Cube specifies a cube, this would be classified as a primitive
 *
 *
 * @author Charlie
 */
public class Cube extends Object3D {
    double w;
    double h;
    double d;
    double x;
    double y;
    double z;
    /**
     * Create a new cube
     * @param x the position of the top left corner
     * @param y the position of the top left corner
     * @param z the position of the top left corner
     * @param w the width of the shape
     * @param h the height of the shape
     * @param d the depth of the shape
     */
    public Cube(double x, double y, double z, double w, double h, double d) {
        super(6);
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.generateFaces();
        
    }
    private void generateFaces() {
        //front face
        double[] face0 = {
            x, y, z, 1,
            x+w, y, z, 1,
            x+w, y+h, z, 1,
            x, y+h, z, 1,
        };
        //back face
        double[] face1 = {
            x, y, z+d, 1,
            x+w, y+h, z+d, 1,
            x+w, y, z+d, 1,
            x, y+h, z+d, 1,
        };
        //left face
        double[] face2 = {
            x, y, z, 1,
            x, y, z+d, 1,
            x, y+h, z+d, 1,
            x, y+h, z, 1,
        };
        //right face
        double[] face3 = {
            x+w, y, z, 1,
            x+w, y, z+d, 1,
            x+w, y+h, z+d, 1,
            x+w, y+h, z, 1,
        };
        //top face
        double[] face4 = {
            x, y, z, 1,
            x, y, z+d, 1,
            x+w, y, z+d, 1,
            x+w, y, z+d, 1,
        };
        //bottom face
        double[] face5 = {
            x, y+h, z, 1,
            x, y+h, z+d, 1,
            x+w, y+h, z+d, 1,
            x+w, y+h, z, 1,
        };
        setFace(0, new Rectangle3D(face0));
        setFace(1, new Rectangle3D(face1));
        setFace(2, new Rectangle3D(face2));
        setFace(3, new Rectangle3D(face3));
        setFace(4, new Rectangle3D(face4));
        setFace(5, new Rectangle3D(face5));
    }
}
