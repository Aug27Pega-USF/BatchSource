package core.java.assignment.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import core.java.assignment.*;
import core.java.assignment.QuestionSeven.Employee;
import core.java.assignment.utility.*;

class CoreTests {

	@Test
	void QuestionOneTest() {
		QuestionOne q1 = new QuestionOne();
		int [] actualList = {1,0,5,6,3,2,3,7,9,8,4};
		int [] expectedList = {0,1,2,3,3,4,5,6,7,8,9};
		
		assertArrayEquals(expectedList, q1.bubbleSort(actualList));
	}
	
	@Test
	void QuestionTwoTest() {
		QuestionTwo q2 = new QuestionTwo();
		assertEquals(75025, q2.fb.findFibonacciNumber());
	}
	
	@Test
	void QuestionThreeTest() {
		QuestionThree q3 = new QuestionThree();
		String actual = "asdfqwer", expected = "rewqfdsa";
		assertTrue(expected.equals(q3.reverseString(actual)));
	}
	
	@Test
	void QuestionFourTest() {
		QuestionFour q4 = new QuestionFour();
		int factorialNumber = 12;
		int expected  = 479001600;
		assertEquals (expected, q4.mf.factorial(factorialNumber));
	}
	
	@Test
	void QuestionFiveTest() {
		QuestionFive q5 = new QuestionFive();
		String actual = "This is a string", expected = "This i";
		assertTrue(expected.equals(q5.getSubString(actual, 7)));
		assertFalse(expected.equals(q5.getSubString(actual, 6)));
		assertFalse(expected.equals(q5.getSubString(actual, 8)));
	}
	
	@Test
	void QuestionSixTest() {
		QuestionSix q6 = new QuestionSix();
		assertTrue(q6.even(98));
		assertFalse(q6.even(73));
	}
	
	@Nested
	class QuestionSevenTest {
		QuestionSeven q7 = new QuestionSeven();
		Employee emp1 = new Employee("John Doe", "Human Resources", 25);
		Employee emp2 = new Employee("Jane Doe", "Information Technology", 23);
		
		{
			q7.addEmp("John Doe", "Human Resources", 25);
			q7.addEmp("Jane Doe", "Information Technology", 23);
		}
		
		@Test
		void unsortedTest() {
			List<Employee> expectedUnsortedName = new ArrayList<Employee>();
			expectedUnsortedName.add(emp1);
			expectedUnsortedName.add(emp2);
			assertTrue(expectedUnsortedName.toString().equals(q7.printList().toString()));
		}
		
		@Test
		void sortNameTest() {
			List<Employee> expectedSortedName = new ArrayList<Employee>();
			expectedSortedName.add(emp2);
			expectedSortedName.add(emp1);
			assertTrue(expectedSortedName.toString().equals(q7.SortName().toString()));
		}
		
		@Test
		void sortDepartmentTest() {
			List<Employee> expectedSortedDepartment = new ArrayList<Employee>();
			expectedSortedDepartment.add(emp1);
			expectedSortedDepartment.add(emp2);
			assertTrue(expectedSortedDepartment.toString().equals(q7.SortDepartment().toString()));
		}
		
		@Test
		void sortAgeTest() {
			List<Employee> expectedSortedAge = new ArrayList<Employee>();
			expectedSortedAge.add(emp2);
			expectedSortedAge.add(emp1);
			assertTrue(expectedSortedAge.toString().equals(q7.SortAge().toString()));
		}
		
	}
	
	@Test
	void QuestionEightTest() {
		QuestionEight q8 = new QuestionEight("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did");
		List<String> expectedList = new ArrayList<String>();
		
		for(String s : "madam,civic,radar,kayak,refer,did".split(",")) {
			expectedList.add(s);
		}
		assertTrue(expectedList.equals(q8.findPalindromes()));
	}
	
	@Test
	void QuestionNineTest() {
		QuestionNine q9 = new QuestionNine(100);
		Integer [] expectedPrimes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
		assertArrayEquals(expectedPrimes, q9.findPrimes().toArray(expectedPrimes));
	}
	
	@Test
	void QuestionTenTest() {
		QuestionTen q10 = new QuestionTen();
		assertEquals(1,q10.findMinOfTwo("2 1".split(" ")));
		assertEquals(1,q10.findMinOfTwo("1 2".split(" ")));
		assertEquals(25,q10.findMinOfTwo("25 62".split(" ")));
		assertEquals(165428,q10.findMinOfTwo("2281166 165428".split(" ")));	
	}
	
	@Test
	void QuestionElevenTest() {
		QuestionElevenUtility q11 = new QuestionElevenUtility();
		q11.setFirstFloat(4.1234f);
		q11.setSecondFloat(62.1596f);
		
		assertEquals(4.1234f, q11.getFirstFloat());
		assertEquals(62.1596f, q11.getSecondFloat());
	}
	
	@Test
	void QuestionTwelveTest() {
		QuestionTwelve q12 = new QuestionTwelve(21);
		Integer [] expectedEvens = {2,4,6,8,10,12,14,16,18,20};
		assertArrayEquals(expectedEvens, q12.getEvenNumbers().toArray(expectedEvens));
	}
	
	@Test
	void QuestionThirteenTest() {
		QuestionThirteen q13 = new QuestionThirteen();
		String expectedString = "0 \n1 0 \n1 0 1 \n0 1 0 1 \n";
		assertTrue(expectedString.equals(q13.printBinaryTriangle(false, 4)));
	}
	
	@Nested
	class QuestionFourteenTest {
		QuestionFourteen q14 = new QuestionFourteen();
		
		@Test
		void defaultTest () {
			assertTrue("No option selected".equals(q14.switching(0, 1, new Date(), "I am learning Core Java")));
		}
		
		@Test
		void optionOneTest (){
			assertTrue("2.24".equals(q14.switching(1, 5, new Date(), "")));
		}
		
		@Test
		void option2Test (){
			Date actualDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
			String expectedDate = format.format(actualDate);
			assertTrue(expectedDate.equals(q14.switching(2, 1, actualDate, "")));
		}
		
		@Test
		void optionThreeTest (){
			assertTrue("[I, am, learning, Core, Java]".equals(q14.switching(3, 1, new Date(), "I am learning Core Java")));
		}
	}
	
	@Nested
	class QuestionFifteenTests{
		QuestionFifteen q15 = new QuestionFifteen();
		
		@Test 
		void additionTest() {
			assertEquals(5, q15.addition(2, 3));
		}
		
		@Test 
		void subtractionTest() {
			assertEquals(1, q15.subtraction(3, 2));
		}
		
		@Test 
		void multiplicationTest() {
			assertEquals(6, q15.multiplication(2, 3));
		}
		
		@Test 
		void divisionTest() {
			assertEquals(3, q15.division(9, 3));
		}
	}
	
	@Test
	void QuestionSeventeenTest () {
		QuestionSeventeen q17 = new QuestionSeventeen();
		
		q17.setPrincipal(5000);
		q17.setRate(5.25);
		q17.setYears(5);
		assertEquals(5000*5.25/100*5, q17.findInterest());
	}
	
	@Nested
	class QuestionEighteenTest {
		QuestionEighteen q18 = new QuestionEighteen();
		
		@Test
		void getStringTest() {
			q18.setStr("asdfasdf");
			assertTrue("asdfasdf".equals(q18.getStr()));
		}
		
		@Test
		void uppercaseTest() {
			q18.setStr("glfkfjoGasdfds");
			assertTrue(q18.checkUppercase());
			q18.setStr("adfdfgsdfg");
			assertFalse(q18.checkUppercase());
		}
		
		@Test
		void toUppercaseTest() {
			q18.setStr("glfkfjoGasdfds");
			assertTrue("GLFKFJOGASDFDS".equals(q18.toUppercase()));
		}
		
		@Test
		void toIntegerTest() {
			q18.setStr("21");
			assertEquals(31, q18.toIntegerAndAdd());
		}
	}
	
	@Nested
	class QuestionNineteenTest {
		QuestionNineteen q19 = new QuestionNineteen(10);
		
		@Test
		void addEvenTest() {
			assertEquals(2+4+6+8+10, q19.addEvenNumbers());
		}
		
		@Test
		void addOddTest() {
			assertEquals(1+3+5+7+9, q19.addOddNumbers());
		}
		
		@Test
		void removePrimeTest() {
			Integer [] noPrimeList = {1,4,6,8,9,10};
			assertTrue(noPrimeList.equals(q19.removePrimes().toArray(noPrimeList)));
		}
	}
	
	@Nested
	class QuestionTwentyTest {
		QuestionTwenty q20 = new QuestionTwenty();
		
		@Test
		void readFileTest() {
			List<QuestionTwenty.PersonData> expectedData = new ArrayList<QuestionTwenty.PersonData>();
			expectedData.add(q20.new PersonData("Mickey:Mouse:35:Arizona".split(":")));
			expectedData.add(q20.new PersonData("Hulk:Hogan:50:Virginia".split(":")));
			expectedData.add(q20.new PersonData("Roger:Rabbit:22:California".split(":")));
			expectedData.add(q20.new PersonData("Wonder:Woman:18:Montana".split(":")));
			
			try {
				assertTrue(expectedData.toString().equals(q20.readFileLines(":").toString()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
