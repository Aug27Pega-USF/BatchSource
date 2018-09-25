package JDBCBank.Banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
	
	public static String GetMenuSelection(Scanner s, String ... a) {
		//loop until we get a string pertaining to one of the options
		boolean valid_value = false;
		
		String result = "";
		
		int total_options = a.length;
		
		//line break
		System.out.println("-----------------------");
		//print out all the options
		for (int i = 0; i < total_options; i++) {
			System.out.println("(" + (i+1) + ") - " + a[i]);
		}
		
		//loop until we get a value within the range
		while(!valid_value) {
			System.out.print("Select: ");
			//get input
			result = s.next();
			
			for(int i = 1; i <= total_options && !valid_value; i++) {
				if(result.contains(Integer.toString(i))) {
					valid_value = true;
					result = a[i-1]; //just return the value we want
				}
			}
			
			//prompt if they mess up
			if(!valid_value)
				System.out.println("Please pick an option from 1 to " + total_options);
		}
		
		return result;
	}
	
	//returns an id value
	public static int GetAccountSelection(Scanner s, ArrayList<String> a, ArrayList<Integer> id, ArrayList<Integer> balance) {
		//loop until we get a string pertaining to one of the options
		boolean valid_value = false;
		
		String result = "";
		int result_value = 0;
		
		int total_options = a.size();
		
		//line break
		System.out.println("-----------------------");
		
		//print out all the options
		for (int i = 0; i < total_options; i++) {
			System.out.println("(" + (i+1) + ") - " + a.get(i) + " (Balance: $" + balance.get(i) + ")");
		}
		System.out.println("(0) - Exit To Menu");
		
		//loop until we get a value within the range
		while(!valid_value) {
			System.out.print("Select: ");
			//get input
			result = s.next();
			
			for(int i = 1; i <= total_options && !valid_value; i++) {
				if(result.contains(Integer.toString(i))) {
					valid_value = true;
					result_value = id.get(i-1); //just return the value we want
				}
				
				else if (result.contains("0")) {
					valid_value = true;
					result_value = -1;
				}
			}
			
			//prompt if they mess up
			if(!valid_value)
				System.out.println("Please pick an option from 1 to " + total_options);
		}
		
		return result_value;
	}
	
	
	//returns an id value
		public static int GetUserSelection(Scanner s, ArrayList<String> a, ArrayList<Integer> id) {
			//loop until we get a string pertaining to one of the options
			boolean valid_value = false;
			
			String result = "";
			int result_value = 0;
			
			int total_options = a.size();
			
			//line break
			System.out.println("-----------------------");
			
			//print out all the options
			for (int i = 0; i < total_options; i++) {
				System.out.println("(" + (i+1) + ") - " + a.get(i));
			}
			System.out.println("(0) - Exit To Menu");
			
			//loop until we get a value within the range
			while(!valid_value) {
				System.out.print("Select: ");
				//get input
				result = s.next();
				
				for(int i = 1; i <= total_options && !valid_value; i++) {
					if(result.contains(Integer.toString(i))) {
						valid_value = true;
						result_value = id.get(i-1); //just return the value we want
					}
					
					else if (result.contains("0")) {
						valid_value = true;
						result_value = -1;
					}
				}
				
				//prompt if they mess up
				if(!valid_value)
					System.out.println("Please pick an option from 1 to " + total_options);
			}
			
			return result_value;
		}
}
