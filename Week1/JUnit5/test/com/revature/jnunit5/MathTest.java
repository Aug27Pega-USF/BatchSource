package com.revature.jnunit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MathTest {

	@Test
	void minTest() {
		int a =2;
		int b = 4;
		System.out.println(Math.min(a, b));
		assertEquals(a, (Math.min(b,a)));
	}

}
