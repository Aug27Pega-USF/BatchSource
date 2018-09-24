package com.PrestonL.junit;

import static org.junit.jupiter.api.Assertions.*;

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
	static void beforeall() {
		System.out.println("BeforeAll");
	}
	
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
		int expectedLength=4;
		assertEquals(actualLength,expectedLength);
	}
	
	@Test
	void contain_basics() {
		String str= "abcdefg";
		boolean result = str.contains("ijk");
		assertFalse(result);
	}
	@Test
	void length_exception() {
		String str=null;
		assertThrows(NullPointerException.class,()->{str.length();});
		
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
