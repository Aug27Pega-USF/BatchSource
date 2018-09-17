package Homework.Assignments.hw1;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class tests {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	@Test
	public void testQ1() {
		Q1BubbleSort q1bubble= new Q1BubbleSort();
		int[] q1arr = {1,0,5,6,3,2,3,7,9,8,4};
		q1arr=q1bubble.bubblesort(q1arr);
		int[] q1arr2 = {0,1,2,3,3,4,5,6,7,8,9};
		assertArrayEquals(q1arr,q1arr2);
	}

	@Test
	public void testQ2() {
		Q2Fibonacci q2fib= new Q2Fibonacci();
		q2fib.Fib(25);
		assertEquals("0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 \r\n", outContent.toString());
	}
	@Test
	public void testQ3() {
		Q3Reversestring q3rev = new Q3Reversestring();
		q3rev.reversal("Q3: Reverse string");
		assertEquals("gnirts esreveR :3Q\r\n", outContent.toString());
	}
	@Test
	public void testQ4() {
		Q4Factorial q4fac = new Q4Factorial();
		assertEquals(720, q4fac.facto(6));
		assertEquals(3628800, q4fac.facto(10));
	}
	
	@Test
	public void testQ5() {
		Q5Substring q5sub= new Q5Substring();
		assertEquals(q5sub.substr("Substring",3), "Sub");
		assertEquals(q5sub.substr("Short string",15), "Short string");
	}
	
	@Test
	public void testQ6even() {
		Q6DetermineEven q6even= new Q6DetermineEven();
		q6even.modulofree(257341156);
		assertEquals("257341156 is even.\r\n", outContent.toString());
	}
	
	@Test
	public void testQ6odd() {
		Q6DetermineEven q6even= new Q6DetermineEven();
		q6even.modulofree(3535257);
		assertEquals("3535257 is odd.\r\n", outContent.toString());
	}
	
	@Test
	public void testQ7() {
		List<Q7Employee> q7arr= new ArrayList<Q7Employee>();
		q7arr.add(new Q7Employee("Frank", "Accounting", 36));
		q7arr.add(new Q7Employee("Alfred", "Manager", 45));
		q7arr.add(new Q7Employee("Balnor","Sandwich Protector",40));
        Collections.sort(q7arr, new SortEmployeebyNameQ7());
        assertEquals(q7arr.get(0).getName(),"Alfred");
        assertEquals(q7arr.get(1).getName(),"Balnor");
        assertEquals(q7arr.get(2).getName(),"Frank");
        Collections.sort(q7arr, new SortEmployeebyDeptQ7());
        assertEquals(q7arr.get(0).getName(),"Frank");
        assertEquals(q7arr.get(1).getName(),"Alfred");
        assertEquals(q7arr.get(2).getName(),"Balnor");
        Collections.sort(q7arr, new SortEmployeebyAgeQ7());
        assertEquals(q7arr.get(0).getName(),"Frank");
        assertEquals(q7arr.get(1).getName(),"Balnor");
        assertEquals(q7arr.get(2).getName(),"Alfred");
	}
	
	@Test
	public void testQ8() {
		Q8Palindrome q8pal=new Q8Palindrome();
		q8pal.Q8();
		ArrayList<String> names = new ArrayList<>();
        names.add("madam");
        names.add("civic");
        names.add("radar");
        names.add("kayak");
        names.add("refer");
        names.add("did");
		assertEquals(q8pal.palindromes, names);
	}
	@Test
	public void testQ9() {
		Q9PrimeNumbers q9pri=new Q9PrimeNumbers();
		q9pri.Q9();
		assertEquals("2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 \r\n", outContent.toString());
	}
	
	@Test
	public void testQ10() {
		Q10TernaryLess q10les=new Q10TernaryLess();
		assertEquals(q10les.minimum(10, 12),10);
		assertEquals(q10les.minimum(-5, -8),-8);
		assertEquals(q10les.minimum(-500, 8001),-500);
	}
	
	@Test
	public void testQ11() {
		Q11PackageAccessor q11pac=new Q11PackageAccessor();
		assertTrue(q11pac.floatadd()==3.57f);
	}
	
	@Test
	public void testQ12() {
		Q12EvenNumbers q12eve=new Q12EvenNumbers();
		q12eve.Q12();
		assertEquals("2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98 100 \r\n", outContent.toString());
	}
	
	@Test
	public void testQ13() {
		Q13TriangleLoop q13tri=new Q13TriangleLoop();
		q13tri.Q13();
		assertEquals("0 \r\n" + 
				"1 0 \r\n" + 
				"1 0 1 \r\n" + 
				"0 1 0 1 \r\n", outContent.toString());
	}
	
	@Test
	public void testQ14one() {
		Q14Switch q14swi = new Q14Switch();
		q14swi.q14switch(1);
		Calendar cal = Calendar.getInstance();
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    assertEquals(outContent.toString(),String.format("Today's Date: %02d/%02d/%4d\n", month+1, day, year));
	}
	@Test
	public void testQ14two() {
		Q14Switch q14swi = new Q14Switch();
		q14swi.q14switch(2);
		assertEquals("I\r\n" + 
		"am\r\n" + 
		"learning\r\n" + 
		"Core\r\n" + 
		"Java\r\n", outContent.toString());
	}
	@Test
	public void testQ14three() {
		Q14Switch q14swi = new Q14Switch();
		q14swi.q14switch(9);
		assertEquals("The square root of 9 is 3.0.\r\n",outContent.toString());
	}
	
	@Test
	public void testQ16() {
		String[] hard= {"1234567"};
		Q16StringLength.main(hard);
		assertEquals("The number of characters in the inputted string is: 7.\r\n", outContent.toString());
	}
	
	
	@Test
	public void testQ18() {
		Q18Abstractclass q18abs = new Q18subclass();
		assertEquals(q18abs.uppercasecheck("i am lowercase"), false);
		assertEquals(q18abs.uppercasecheck("Abstract Class"),true);
		assertEquals(q18abs.makeUppercase("i am lowercase"),"I AM LOWERCASE");
		assertEquals(q18abs.makeUppercase("Abstract Class"), "ABSTRACT CLASS");
		q18abs.add10("18");
		assertEquals("28\r\n",outContent.toString());
	}
	
	@Test
	public void testQ19() {
		Q19ArrayListStuff q19arr=new Q19ArrayListStuff();
		q19arr.Q19();
		assertEquals("Initial Array: 1 2 3 4 5 6 7 8 9 10 \r\n" + 
				"Sum of even numbers: 30\r\n" + 
				"Sum of odd numbers: 25\r\n" + 
				"Non-Prime Numbers: 1 4 6 8 9 10 \r\n", outContent.toString());
	}
	
	@Test
	public void testQ20() {
		Q20FileInterpreter q20fil= new Q20FileInterpreter();
		q20fil.Q20();
		assertEquals("Name: Mickey Mouse\n" + 
				"Age: 35 years\n" + 
				"State: Arizona State\n" + 
				"\n" + 
				"Name: Hulk Hogan\n" + 
				"Age: 50 years\n" + 
				"State: Virginia State\n" + 
				"\n" + 
				"Name: Roger Rabbit\n" + 
				"Age: 22 years\n" + 
				"State: California State\n" + 
				"\n" + 
				"Name: Wonder Woman\n" + 
				"Age: 18 years\n" + 
				"State: Montana State\n\n",outContent.toString());
	}
}
