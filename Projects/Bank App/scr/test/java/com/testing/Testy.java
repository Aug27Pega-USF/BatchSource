package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Testy {
	/*
	 * What I had to was run the JUnit stuff as dependencies in Maven's pog.xml
	 * Run the program and it'll download all the plugins/jars
	 * Organize it like here but when I run the file,
	 * click on the source folder and hit Run As -> JUnit Test
	 * This will give you an error, set it to run as JUnit 5 instead
	 */
	@Test
	void minTest() {
		int a =5;
		int b = 4;
		System.out.println(Math.min(a, b));
		assertEquals(a, (Math.min(b,a)));
	}

}
