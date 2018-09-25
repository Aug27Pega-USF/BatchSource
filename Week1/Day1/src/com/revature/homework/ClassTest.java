package com.revature.homework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.homework.*;
class ClassTest {
	JavaAssignment1 ja= new JavaAssignment1();
	
	@Test
	@DisplayName("Should be Even")
	void q6test() {
		String a= ja.even(4);
		assertEquals("4 is Even",a);
	}

}
