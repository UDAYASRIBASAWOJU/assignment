package com.lpu.test;

import org.junit.jupiter.api.Test;

public class TestDemo {

	@Test
	public void m1() {
		System.out.println("m1 Test");
	}
	
	@Test   //without this @Test method is treated as normal method
	public void m2() {
		System.out.println("m2 Test");
	}
}