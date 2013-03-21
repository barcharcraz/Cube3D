/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.charlie.Graphics.math3DUtils;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.charlie.Graphics.math3DUtils.Matrix;

import static org.junit.Assert.*;

/**
 *
 * @author Charlie
 */
public class MatrixTest {

    public MatrixTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    @Test
    public void testSetToIdentity() {
    	System.out.println("setToIdentity");
    	Matrix rightMatrix = new Matrix(3,1);
        rightMatrix.setValue(0, 0, 4);
        rightMatrix.setValue(1, 0, 2);
        rightMatrix.setValue(2, 0, 6);
        Matrix instance = new Matrix(3,3);
        instance.setToIdentity();
        Matrix result = instance.multiply(rightMatrix);
        assertTrue(result.equals( rightMatrix ));
    	
    }
    /**
     * Test of getValue method, of class Matrix.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        int i = 4;
        int j = 2;
        Matrix instance = new Matrix(5,3);
        //instance.setValue(4, 2, 8);
        instance.matrix[i][j]=8;
        double expResult = 8;
        double result = instance.getValue(i, j);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setValue method, of class Matrix.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int i = 4;
        int j = 2;
        Matrix instance = new Matrix(5,3);
        double value = 5;
        instance.setValue(i, j, value);
        assertTrue(instance.matrix[i][j]==5);
        
    }

    /**
     * Test of getColumns method, of class Matrix.
     */
    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        Matrix instance = new Matrix(5,3);
        int expResult = 3;
        int result = instance.getColumns();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRows method, of class Matrix.
     */
    @Test
    public void testGetRows() {
        System.out.println("getRows");
        Matrix instance = new Matrix(5,3);
        int expResult = 5;
        int result = instance.getRows();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getColumnVector method, of class Matrix.
     */
    /*
    @Test
    public void testGetColumnVector() {
        System.out.println("getColumnVector");
        int j = 0;
        Matrix instance = null;
        Vector expResult = null;
        Vector result = instance.getColumnVector(j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of getRowVector method, of class Matrix.
     */
    /*
    @Test
    public void testGetRowVector() {
        System.out.println("getRowVector");
        int i = 0;
        Matrix instance = null;
        Vector expResult = null;
        Vector result = instance.getRowVector(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of multiply method, of class Matrix.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        Matrix rightMatrix = new Matrix(3,1);
        rightMatrix.setValue(0, 0, 4);
        rightMatrix.setValue(1, 0, 2);
        rightMatrix.setValue(2, 0, 6);
        Matrix instance = new Matrix(3,3);
        instance.setValue(0, 0, 4);
        instance.setValue(0, 1, 2);
        instance.setValue(0, 2, 1);
        instance.setValue(1, 0, 6);
        instance.setValue(1, 1, 9);
        instance.setValue(1, 2, 0);
        instance.setValue(2, 0, 2);
        instance.setValue(2, 1, 2);
        instance.setValue(2, 2, 3);
        Matrix expResult = new Matrix(3,1);
        expResult.setValue(0, 0, 26);
        expResult.setValue(1, 0, 42);
        expResult.setValue(2, 0, 30);
        Matrix result = instance.multiply(rightMatrix);
        System.out.print(result);
        assertTrue(expResult.equals(result));
        
    }
    
    @Test
    public void testBigMultiply() {
    	System.out.println("multiply 4x4");
        Matrix rightMatrix = new Matrix(4,4);
        rightMatrix.setValue(0, 0, 0);
        rightMatrix.setValue(0, 1, 1);
        rightMatrix.setValue(0, 2, 2);
        rightMatrix.setValue(0, 3, 3);
        
        rightMatrix.setValue(1, 0, 4);
        rightMatrix.setValue(1, 1, 5);
        rightMatrix.setValue(1, 2, 6);
        rightMatrix.setValue(1, 3, 7);
        
        rightMatrix.setValue(2, 0, 8);
        rightMatrix.setValue(2, 1, 9);
        rightMatrix.setValue(2, 2, 10);
        rightMatrix.setValue(2, 3, 11);
        
        rightMatrix.setValue(3, 0, 12);
        rightMatrix.setValue(3, 1, 13);
        rightMatrix.setValue(3, 2, 14);
        rightMatrix.setValue(3, 3, 15);
        Matrix instance = new Matrix(4,4);
        instance.setValue(0, 0, 1);
        instance.setValue(0, 1, 2);
        instance.setValue(0, 2, 3);
        instance.setValue(0, 3, 4);
        
        instance.setValue(1, 0, 5);
        instance.setValue(1, 1, 6);
        instance.setValue(1, 2, 7);
        instance.setValue(1, 3, 8);
        
        instance.setValue(2, 0, 9);
        instance.setValue(2, 1, 10);
        instance.setValue(2, 2, 11);
        instance.setValue(2, 3, 12);
        
        instance.setValue(3, 0, 13);
        instance.setValue(3, 1, 14);
        instance.setValue(3, 2, 15);
        instance.setValue(3, 3, 16);
        
        Matrix expResult = new Matrix(4,4);
        expResult.setValue(0, 0, 80);
        expResult.setValue(0, 1, 90);
        expResult.setValue(0, 2, 100);
        expResult.setValue(0, 3, 110);
        
        expResult.setValue(1, 0, 176);
        expResult.setValue(1, 1, 202);
        expResult.setValue(1, 2, 228);
        expResult.setValue(1, 3, 254);
        
        expResult.setValue(2, 0, 272);
        expResult.setValue(2, 1, 314);
        expResult.setValue(2, 2, 356);
        expResult.setValue(2, 3, 398);
        
        expResult.setValue(3, 0, 368);
        expResult.setValue(3, 1, 426);
        expResult.setValue(3, 2, 484);
        expResult.setValue(3, 3, 542);
        Matrix result = instance.multiply(rightMatrix);
        System.out.print(result);
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of equals method, of class Matrix.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Matrix o = new Matrix(3,3);
        o.setValue(0, 0, 4);
        o.setValue(0, 1, 2);
        o.setValue(0, 2, 1);
        o.setValue(1, 0, 6);
        o.setValue(1, 1, 9);
        o.setValue(1, 2, 0);
        o.setValue(2, 0, 2);
        o.setValue(2, 1, 2);
        o.setValue(2, 2, 3);
        Matrix instance = new Matrix(3,3);
        instance.setValue(0, 0, 4);
        instance.setValue(0, 1, 2);
        instance.setValue(0, 2, 1);
        instance.setValue(1, 0, 6);
        instance.setValue(1, 1, 9);
        instance.setValue(1, 2, 0);
        instance.setValue(2, 0, 2);
        instance.setValue(2, 1, 2);
        instance.setValue(2, 2, 3);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testNotEquals() {
        System.out.println("equals false");
        Matrix o = new Matrix(3,3);
        o.setValue(0, 0, 4);
        o.setValue(0, 1, 2);
        o.setValue(0, 2, 1);
        o.setValue(1, 0, 6);
        o.setValue(1, 1, 9);
        o.setValue(1, 2, 3);
        o.setValue(2, 0, 2);
        o.setValue(2, 1, 2);
        o.setValue(2, 2, 3);
        Matrix instance = new Matrix(3,3);
        instance.setValue(0, 0, 4);
        instance.setValue(0, 1, 2);
        instance.setValue(0, 2, 1);
        instance.setValue(1, 0, 6);
        instance.setValue(1, 1, 9);
        instance.setValue(1, 2, 0);
        instance.setValue(2, 0, 2);
        instance.setValue(2, 1, 2);
        instance.setValue(2, 2, 3);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
    }

}