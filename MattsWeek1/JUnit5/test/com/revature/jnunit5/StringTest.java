package com.revature.jnunit5;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {
	private String str;
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize Test Data for " + info.getDisplayName());
	}
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("Clean up Test Data for " + info.getDisplayName());
	}
	@Test
	void meh() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		// assertEquals( expected value, actual value)
		assertEquals(expectedLength, actualLength);

		// Assert length == 4
		// Write test code
		// Invoke method square(4) => CUT (Code Under Test)
		// Checks in place - 16 => Assertions
	}

	@Test
	void toUpperCase() {
		String str = "abcd";
		String result = str.toUpperCase();
		assertEquals("ABCD", result);
		// assertNull(result);
		assertNotNull(result);
	}

	@Test
	void contains_basics() {
		String str = "abcdefg";
		boolean result = str.contains("ijk");
		// assertEquals(false, result);
		assertFalse(result);
		// assertTrue
		
		/*
		 * Inline- can be more readable
		 * assertFalse("abcdefgh".contains("ijk"));
		 */
	}
	
	@Test
	@DisplayName("A basic split")
	void split_basic() {
		String str = "abc def ghi";
		String actualResult[]= str.split(" ");
		String [] expectedResult= new String[]{"abc","def","ghi"};
		
		assertArrayEquals(expectedResult,actualResult);
		
	}
	@Test
	//test for exceptions
	void lenth_exception() {
		String str = null;
		
		assertThrows(NullPointerException.class,
				//use lambda expression as the parameter
				() -> {
					str.length();
				}
				);
		
	}
	@ParameterizedTest
	@ValueSource(strings= {"ABCD", "ABC", "A", "DEF"})
	void length_greater_0_parameterized(String str) {
		assertTrue(str.length()>0);
	}
	/*@Test
	void upperCase() {
		assertEquals("ABCD", "abcd".toUpperCase());
		assertEquals("ABC", "abc".toUpperCase());
		assertEquals("", "".toUpperCase());
		assertEquals("ABCDEFG", "abcdefg".toUpperCase());
	}*/
	
	//@ParameterizedTest
	@ParameterizedTest(name = "{0} toUpperCase is {1}")
	@CsvSource(value= {"abcd, ABCD", "abc , ABC", " '', ''", "abcdefg , ABCDEFG"} )
	void upperCase(String word, String capitalizedWord) {
		assertEquals(capitalizedWord, word.toUpperCase());
		
	}
	
	@ParameterizedTest(name = "{0} length is {1}")
	@CsvSource(value= {"abcd, 4", "abc , 3", "'', 0", "abcdefg , 7"} )
	void length(String word, int expectedLength) {
		assertEquals(expectedLength, word.length());
	
	}
	
	@Test
	@Disabled
	void performanceTest() {
		assertTimeout(Duration.ofSeconds(5),
				()->{
					for(int i=0; i<1500000;i++) {
						int j =i;
						System.out.println(j);
				
					}
				}
				);
		
	}
	
	@Nested
	@DisplayName("For an empty String")
	class EmptyStringTests{
		@BeforeEach
		void setToEmpty() {
			str="";
		}
		
		@Test
		@DisplayName("length should be zero")
		void lengthIsZero() {
			assertEquals(0,str.length());
			}
		@Test
		@DisplayName("upper case is empty")
		void uppercaseIsEmpty() {
			assertEquals("",str.toUpperCase());
		}
		
		
		
		
	}
	
	
}
