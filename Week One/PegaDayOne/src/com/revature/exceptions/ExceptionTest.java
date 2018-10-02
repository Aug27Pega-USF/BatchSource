package com.revature.exceptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.beans.Person;
public class ExceptionTest {

	static Person P = new Person("Tim", 3, 200);
	static ArrayList<String> names = new ArrayList<String>();
	public static void main(String[] args) throws NameNotFoundException {
		
		names.add("bob");
		names.add("Jeff");
		
//		P.increaseAgeBy(20);
//		System.out.println(P.getAge());
//		P.increaseAgeBy(-13);
//		System.out.println(P.getAge());
//			if(!Arrays.asList(names).contains("Kevin")) throw new NameNotFoundException();
				
				try {
					for(int x = 0; x < names.size();x++) {
						
					}
			} catch (NameNotFoundException e){
				System.out.println("Catch Block");
			}
	}

}
