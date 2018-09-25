package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {
	private String str;
	
	@BeforeAll
	void beforeAll() {
		System.out.println("Before All");
	}
	
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize Test data for " + info.getDisplayName());
		
	}
	
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("Clean up test data for " + info.getDisplayName());
	}
	
	@Test //method which forms a JUnit test
	void meh() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		//assertEquals( expected value, actual value)
		assertEquals(expectedLength,actualLength);
	}
	
	

}
