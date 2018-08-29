package com.revature.utility;

import java.util.ArrayList;

public class NameNotFoundTest {
	public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Harold");		
		String login="Harold";
		int temp=0;
		try {
			
			for (int i=0; i<names.size(); i++) {
				if (names.get(i)==login) {
					temp=1;
					break;
				}
			}
			check(temp);
			System.out.println("Login is successful. Hello, "+ login +".");
		}
		catch(NameNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public static void check(int temp) throws NameNotFoundException{
		if (temp==0) {
			throw new NameNotFoundException("Name is not on list of login names.");
		}
	}
	
}
