package test.java;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.driver.driver;
import com.driver.abstractz.Subby;
import com.driver.functions.Functions;
import com.driver.questions.Q1;
import com.driver.questions.Q12;
import com.driver.questions.Q13;
import com.driver.questions.Q14;
import com.driver.questions.Q16;
import com.driver.questions.Q19;

import question.fifteen.Q15Maths;
import question.twenty.IO;

import com.driver.questions.Q2;
import com.driver.questions.Q3;
import com.driver.questions.Q5;
import com.driver.questions.Q6;

public class Testing {
	
	/*
	 * Testing out Functions
	 */
	@Test
	void test_displayArray() {
		int[] arr = {14, 5, 1, 7, 2};
		Functions.displayArray(arr);		
	}
	
	@Test
	void test_fibonacci() {
		int fibVal = 4;
		assertEquals(3, Functions.fibonacci(fibVal));
	}
	
	@Test
	void test_factorial() {
		int val = 4;
		assertEquals(24, Functions.factorial(val));
	}
	
	@Test
	void test_isPalindrome() {
		String pal1 = "racecar";
		String pal2 = "banana";
		
		assertTrue(Functions.isPalindrome(pal1));
		assertTrue(!Functions.isPalindrome(pal2));
	}
	
	@Test
	void test_isPrime() {
		int pri1 = 3;
		int pri2 = 4;
		
		assertTrue(Functions.isPrime(pri1));
		assertTrue(!Functions.isPrime(pri2));
	}
	
	@Test
	void test_displayQuestion() {
		int num = 2;
		assertEquals(num+1, driver.displayQuestion(num));
	}
	
	/*
	 * Questions
	 */
	@Test
	void test_question1() {
		
		int[] arr = {3, 2, 1};
		int[] target_arr = {1, 2, 3};
		
		Q1.sortArray(arr);
		
		assertEquals(arr[0], target_arr[0]);
		assertEquals(arr[1], target_arr[1]);
		assertEquals(arr[2], target_arr[2]);
	}
	
	@Test
	void test_question2() {
		String target_str = "0, 1, 1, 2, 3, 5";
		String str = "";
		
		str = Q2.fibonacci(5);
		assertEquals(target_str, str);
	}
	
	@Test
	void test_question3() {
		String str = "Banana";
		String target_str = "ananaB";
		
		str = Q3.reverseString(str);
		
		assertEquals(target_str, str);
		//assertTrue(str.equals(target_str));
	}
	
	@Test
	void test_question5() {
		String str = "Alabama";
		int idx = 5;
		String target_str = "Alaba";
		assertEquals(target_str, Q5.getSubstring( str, idx));
	}
	
	@Test
	void test_question6() {
		assertEquals(0, Q6.toOddEven(4)); 
		assertEquals(1, Q6.toOddEven(77));
	}
	
	/*
	 * Q7-10 have functions already tested or are too simple for testing
	 */
	@Test
	void test_question11() {
		question.eleven.Floaters f = new question.eleven.Floaters();
		assertEquals(22.2f, f.myFloat1);
	}
	
	@Test
	void test_question12() {
		Q12.question();
	}
	
	@Test
	void test_question13() {
		Q13.question();
	}
	
	@Test
	void test_question14() {
		Q14.question(1);
		Q14.question(2);
		Q14.question(3);
	}
	
	@Test
	void test_question15() {
		Q15Maths q = new Q15Maths();
		
		assertEquals(5, q.addition(2, 3));
		assertEquals(-1, q.subtraction(2, 3));
		assertEquals(6, q.multiplication(2, 3));
		assertEquals(2, q.division(6, 3));
		//needs to return an int, test that it casts it properly
		assertEquals(2, q.division(7, 3));
	}
	
	@Test
	void test_question16() {
		assertEquals(7,Q16.question("Alabama"));
	}
	
	@Test
	void test_question18() {
		Subby s = new Subby();
		
		assertTrue(s.method1("AAAAA"));
		assertTrue(s.method1("AAAAa"));
		assertTrue(s.method1("aA"));
		assertTrue(!s.method1("aa"));
		
		String str = "aaaa";
		assertEquals("AAAA", s.method2(str));
		
		assertEquals(20,s.method3("10"));
	}
	
	@Test 
	void test_question19() {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(6);
		intList.add(3);
		intList.add(7);
		intList.add(0);
		intList.add(2);
		intList.add(1);
		
		assertEquals(8, Q19.getEvensTotal(intList));
		assertEquals(11, Q19.getOddsTotal(intList));
	}
	
	@Test
	void test_question20() {
		IO io = new IO();

		String s = io.readFile();
		String str = "Mickey:Mouse:35:Arizona\r\n" + 
				"Hulk:Hogan:50:Virginia\r\n" + 
				"Roger:Rabbit:22:California\r\n" + 
				"Wonder:Woman:18:Montana";
		assertEquals(str, s);
	}
	
	/*
	 * Input functions
	 */
	@Nested
	class inputStringTests {
		Scanner s = new Scanner(System.in);
		
		@Test
		void test_getNumberFromInput() {
			int num = 5;
			System.out.println("Type in the number: " + num);
			assertEquals(num, Functions.getNumberFromInput(s));
		}
		
		@Test
		void test_getFloatFromInput() {
			float num = 0.5f;
			System.out.println("Type in the number: " + num);
			assertEquals(num, Functions.getFloatFromInput(s));
		}
	}
}
