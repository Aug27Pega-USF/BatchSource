package com.driver;

import com.driver.questions.Q1;
import com.driver.questions.Q10;
import com.driver.questions.Q11;
import com.driver.questions.Q12;
import com.driver.questions.Q13;
import com.driver.questions.Q14;
import com.driver.questions.Q15;
import com.driver.questions.Q16;
import com.driver.questions.Q17;
import com.driver.questions.Q18;
import com.driver.questions.Q19;
import com.driver.questions.Q2;
import com.driver.questions.Q20;
import com.driver.questions.Q3;
import com.driver.questions.Q4;
import com.driver.questions.Q5;
import com.driver.questions.Q6;
import com.driver.questions.Q7;
import com.driver.questions.Q8;
import com.driver.questions.Q9;


//import question.eleven.Floaters;

public class driver {
	
	static int q1Array[] = {1,0,5,6,3,2,3,7,9,8,4};

	public static void main(String args[]) {
		int curQues = 1;
		//Bubble Sort Function
		curQues = displayQuestion(curQues);
		Q1.question(q1Array);
		
		//Fibonacci Sequence
		curQues = displayQuestion(curQues);
		Q2.question(25);
		
		//Reversing a string
		curQues = displayQuestion(curQues);
		Q3.question("Abcdefg");
		
		//N! Factorial
		curQues = displayQuestion(curQues);
		Q4.question(6);
		
		//Substring Method
		curQues = displayQuestion(curQues);
		Q5.question("Alabama", 4);
		
		//Check For Even Number
		curQues = displayQuestion(curQues);
		Q6.question(51);
		Q6.question(100);
		Q6.question(2);
		Q6.question(-15);
		
		//Sorting a Collection of Two Employees
		curQues = displayQuestion(curQues);
		Q7.question();
		
		//Get palindromes from an ArrayList
		curQues = displayQuestion(curQues);
		Q8.question();
		
		//Get Prime Numbers
		curQues = displayQuestion(curQues);
		Q9.question();
		
		//Minimums via Ternary Operators
		curQues = displayQuestion(curQues);
		Q10.question(12, 5);
		Q10.question(3, 124);
		Q10.question(5, 6);
		
		//Get Floats
		curQues = displayQuestion(curQues);
		Q11.question();
		
		//Get Even Numbers
		curQues = displayQuestion(curQues);
		Q12.question();
		
		//Print Right-Triangle Pattern
		curQues = displayQuestion(curQues);
		Q13.question();
		
		//Switch Case Example
		curQues = displayQuestion(curQues);
		Q14.question(1);
		Q14.question(2);
		Q14.question(3);
		
		//Implementing an Interface
		curQues = displayQuestion(curQues);
		Q15.question();
		
		//String Input Argument
		curQues = displayQuestion(curQues);
		Q16.question(args[0]);
		
		//Input interest rate program
		curQues = displayQuestion(curQues);
		Q17.question();
		
		//Inheriting an Abstract class
		curQues = displayQuestion(curQues);
		Q18.question();
		
		//Manipulating an ArrayList
		curQues = displayQuestion(curQues);
		Q19.question();
		
		//Reading from a file
		curQues = displayQuestion(curQues);
		Q20.question();
	}
	
	//displays current question
	public static int displayQuestion (int i) {
		//make two blank lines
		System.out.println();
		System.out.println();
		//display current number
		System.out.println("Q"+ i + ": ");
		
		//update on current question
		return ++i;
	}
}




