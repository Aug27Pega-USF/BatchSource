package com.revature.JUnit5;

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

class StringTest {
	private String str;
	@BeforeAll //STATIC method that runs ONCE before all test methods
	static void beforAllTest() {
		System.out.println("I run once before all tests");
	}
	
	@BeforeEach//used on a method that will once before each test
	void beforeEach(TestInfo info) {
		System.out.println("Initialize Test Data for "+
	info.getDisplayName());
	}
	@AfterEach// used after each test
	void afterEach(TestInfo info) {
		System.out.println("Clean up Test Data for "+
	info.getDisplayName());
	}
	
	@Test //method which forms a JUnit Test
	void meh() {
		//Assert length == 4
		//write test
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		//assertEquals(expected value, actual value)
		assertEquals(expectedLength,actualLength);
		
	}
	@ParameterizedTest
	@ValueSource(strings= {"ABCD", "ABC", "A","DEF"})
	void lengthGreaterThan0Paramterized(String str) {
		assertTrue(str.length()>0);
	}
	@Nested
	class EmptyStringTest{
		@BeforeEach
		void setToEmpty() {
			str="";
		}
		@Test
		@DisplayName("length should zero")
		void lengthIsZero() {
			assertEquals(0,str.length());
		}
		@Test
		void uppercaseIsEmpty() {
			assertEquals("",str.toUpperCase());
		}
	}
	
}
	
	




