package com.revature.HW1;

public class Question18part2 extends Question18part1{

	public static void main(String[] args) {
		Question18part1 part1 = new Question18part2();
		System.out.println(part1.isUpper("roll tIde") + "   " 
	+ part1.toUpper("roll tide") + "   " + part1.addedResult("55"));
	}
	
	public String isUpper(String strA) {
		String a = "true"; //set true for a string
		String b = "false"; //set false for a string
		String strB = strA.toLowerCase(); //set a string strB to be the lower case version of your input
		
		if(strA.equals(strB)) { //if your input has the same value as the lower case version
			return b; //has no uppercase, so returns false
		} else {
			return a; //has at least one uppercase, so returns true
		}
	}
	
	public String toUpper(String a) {
		return a.toUpperCase(); //converts input to uppercase and returns the new string
	}
	
	public String addedResult(String a){
		int b = Integer.parseInt(a) + 10;// converts input to integer and adds 10
		String c = Integer.toString(b); //converts the new sum into string
		return c; //returns the string
	}

}
