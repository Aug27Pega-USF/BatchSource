package com.revature.JUnit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {
	
	@BeforeAll // STATIC method that runs ONCE before all test methods
	static void beforeAllTest() {
		System.out.println("I run once before all tests");
	}
	
	@BeforeEach//used on a method that will once before each test
	void beforeEach(TestInfo info) {
		System.out.println("Initial Test Data for " + info.getDisplayName());
	}
	ize
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("Clean up Test Data for " + info.getDisplayName());
	}
	
	@Test//method which forms a JUnit test
	void meh() {
		//Assert Length == 4
		//write test
		int actualLength = "ABCD".length();
		int expected = 4;
		//assertEquals(expectedValue, actualValue) 
		assertEquals(expectedLength, actualLength);
		
	}


}
