package com.revature.customexception;

import com.revature.exception.AddingTacoException;

import java.util.Scanner;


public class TestCase {
	
	public static void main(String[] args) throws AddingTacoException
	{
		String order = "Taco";
		try
		{
			if(order == "Taco") {
			
				throw new AddingTacoException("This is a burger shop");

			}
			System.out.println("Your order is: " + order);
			
		}catch(AddingTacoException e) {
			
			System.out.println("You order suppose to be a burger");

		}
		
	}

}
