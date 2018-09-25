package com.revature.junit5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {
	private String str;
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("BeforeAll");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize Test Date for "+ info.getDisplayName());
	}
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("Clean up test data for "+info.getDisplayName());
	}
	@AfterAll
	static void afterAll() {
		System.out.println("AfterAll");
	}
	@Test //method which forms a JUnit test
	void meh() {
		int actualLength="ABCD".length();
		int expectedLength=4;
		//assertEquals(expected value, actual value)
		assertEquals(expectedLength, actualLength);
		
	//	fail("Not yet implemented");
	}
	@Test
	void toUpperCase() {
		String str="abcd";
		String result = str.toUpperCase();
		assertEquals("ABCD",result);
	}
	@Test
	void contains_basics() {
		String str="abcdefg";
		boolean result = str.contains("ijk");
		//assertEquals(false,result); bad code, use assertFalse instead
		assertFalse(result);// BUT!! There is something even better
		//Inline
		//assertFalse("abcdefgh".contains("ijk")); This method lets us put the code to test in the test
	}
	@Test
	@DisplayName("Check for Exceptions")
	//test for exceptions
	void length_exception() {
		String str = null;
		assertThrows(NullPointerException.class,
				()->{
					str.length();
				});
	}
	@Nested
	@DisplayName("For an empty string")
	class EmptyStringTests{
		@BeforeEach
		void setToEmpty() {
			str="";
		}
		@Test
		void lengthIsZero() {
			assertEquals(0,str.length());
		}
		@Test
		void uppercaseIsEmpty() {
			assertEquals("",str.toUpperCase());
		}
	}
}
