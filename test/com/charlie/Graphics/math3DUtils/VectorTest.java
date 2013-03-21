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
import com.charlie.Graphics.math3DUtils.Vector;

import static org.junit.Assert.*;

/**
 *
 * @author Charlie
 */
public class VectorTest {

    public VectorTest() {
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

    /**
     * Test of getMatrixFromVector method, of class Vector.
     */
    @Test
    public void testGetMatrixFromVector() {
        System.out.println("getMatrixFromVector");
        Vector instance = null;
        Matrix expResult = null;
        Matrix result = instance.getMatrixFromVector();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Vector.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int index = 0;
        double value = 0.0;
        Vector instance = null;
        instance.setValue(index, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLength method, of class Vector.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Vector instance = null;
        int expResult = 0;
        int result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Vector.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        int index = 0;
        Vector instance = null;
        double expResult = 0.0;
        double result = instance.getValue(index);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dotProduct method, of class Vector.
     */
    @Test
    public void testDotProduct() {
        System.out.println("dotProduct");
        Vector v = null;
        Vector instance = null;
        double expResult = 0.0;
        double result = instance.dotProduct(v);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}