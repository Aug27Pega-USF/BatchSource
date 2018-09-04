package com.testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NewTest {
private String str;
	
	@BeforeAll //<-- STATIC method that is going to run ONCE before all of our test methods
	static void beforeAllTest() {
		System.out.println("I run once before all test");
	}
	
	@BeforeEach //<-- used on a method that will run once before EACH test
	void beforeEach(TestInfo info) {
		System.out.println("Initialize test data for " + info.getDisplayName());
	}
	
	@AfterEach // <-- used after each test
	void afterEach(TestInfo info) {
		System.out.println("Clean up test data for " + info.getDisplayName());
	}
	
	@Test  //<-- this is a method which forms a JUnit test
	void meh() {
		//Assert that length == 4
		//write test
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		
		//assertEquals(expected value, actual value)
		assertEquals(expectedLength, actualLength);
		
		//fail("Not yet implemented");
	}

	@ParameterizedTest //<- if we want to test the same method more than once
	@ValueSource(strings = {"ABCD", "ABC", "A", "DEF"})
	void lengthGreaterThanZeroParameterized(String str) {
		assertTrue(str.length()>0);
	}
	
	@Nested
	class EmptyStringTest {
		@BeforeEach
		void setToEmpty() {
			str="";
		}
		
		@Test
		@DisplayName("length should be zero")
		void lengthIsZero() {
			assertEquals(0, str.length());
		}
		
		@Test
		void uppercaseIsEmpty() {
			assertEquals("",str.toUpperCase());
		}
	}
}
