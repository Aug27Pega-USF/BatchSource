package com.revature.exception;

public class DesertTime {
	public static void main(String[] args) {
		//exceptionHierarchy();
//		try {
//			method2();
//		} catch (TooMuchPieException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Successfully ran main method.");
		finallyExample();
	}
	
	public static void finallyExample()
	{
		int[] arr = new int[4];
		try{
			arr[5]=5;
			System.out.println("Trying code.");
			
			System.out.println("Print this if no exception thrown.");
			
			return;
		}
		catch(Exception e)
		{
			System.out.println("Caught Exception");
		}
		finally
		{
			System.out.println("Finally.");
		}
		System.out.println("Reached end of method.");
	}

	public static void method1() throws Exception {
		System.out.println("Hi from method1");
		throw new Exception("Too much pie. Am full now.");
	}

	public static void method2() throws TooMuchPieException {
		System.out.println("Hi from method2");
		throw new TooMuchPieException("Too much pie. Am full now.");
	}

	public static void method3() {
		System.out.println("Hi from method3");
		throw new RuntimeException("You done messed up now.");
	}
	
	public static void exceptionHierarchy()
	{
		try{
			throw new TooMuchPieException("Hi");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		//go here
	}

}
/*
 * Multiple catch blocks
 * need to be order most specfic to least specific
