package com.charlie.Graphics.engine;

import static org.junit.Assert.*;

import org.junit.Test;

import com.charlie.Graphics.engine.Object3D;


public class Object3DTest {

	@Test
	public void testGetFaces() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetNumFaces() {
		Object3D instance = new Object3D(6);
		int expResult = 6;
		assertEquals(instance.getNumFaces(), expResult, 0.0);
	}

}
