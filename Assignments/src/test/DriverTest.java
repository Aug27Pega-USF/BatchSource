package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import floater.FloatOn;
import homework.Driver;

public class DriverTest {

	Driver d = new Driver();

	@Test
	public void testBubbleSort() {
		// fail("Not yet implemented");
		int[] expected = { 1, 2, 3, 4, 5, 6, 7 };
		int[] actual = { 2, 7, 4, 1, 3, 6, 5 };
		d.bubbleSort(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testFibo() {
		int act = d.fibo(10);
		assertEquals(55, act);

	}

	@Test
	public void testFlipIt() {
		String expected = "Now is the winter of our discontent, made glorious summer by this sun of York";
		String actual = "kroY fo nus siht yb remmus suoirolg edam ,tnetnocsid ruo fo retniw eht si woN";
		String check = d.flipIt(actual);
		System.out.println(expected);
		System.out.println(check);
		assertTrue(expected.equals(check));
	}

	@Test
	public void testFactorial() {
		int act = d.factorial(5);
		assertEquals(120, act);
	}

	@Test
	public void testSubStr() {
		String check = "You Put A Move On My Heart";
		assertEquals("You Put", d.subStr(check, 8));
	}

	@Test
	public void testEvenNoMod() {
		String check = d.evenNoMod(15);
		assertEquals("odd", check);
	}

	@Test
	public void testIsPalindrome() {
		assertTrue(d.isPalindrome("civic"));
	}

	@Test
	public void testIsPrime() {
		assertFalse(d.isPrime(7));
	}

	@Test
	public void FloatOnTest() {
		FloatOn fl = new FloatOn();
		float check = (fl.getAbba() + fl.getNoice());
		assertEquals(225f, fl.getAbba(), 0f);
		assertEquals(246f, fl.getNoice(), 0f);
		assertEquals(471f, check, 0f);
	}
	

}
