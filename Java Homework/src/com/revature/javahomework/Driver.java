package com.revature.javahomework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

public class Driver {

			class InputReader{
			private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			private String stringInput;
			
			public void readInput() throws IOException{
				stringInput = reader.readLine();
			}
			public String getStringInput() {
				return stringInput;
			}
			public void setStringInput(String stringInput) {
				this.stringInput = stringInput;
			}
		}
		
			InputReader input = new InputReader();
		
			public void question1() {
				//Question 1 Perform Bubble Sort
				System.out.println("\nQuestion 1 (Perform Bubble Sort: ");
				QuestionOne q1 = new QuestionOne();
				int [] array = {1,0,5,6,3,2,3,7,9,8,4};
				for(int i : q1.bubbleSort(array)) {
					System.out.print(i + ", " );
				}
				System.out.println();
			}
		
			public void question2() {
				//Question 2
				System.out.println("\nQuestion 2 (First 25 Fibonacci number begining at 0: ");
				QuestionTwo q2 = new QuestionTwo();
				System.out.println("Fibonacci(25) = " + q2.fb.findFibonacciNumber());
			}
		
			public void question3() throws IOException{
				//Question 3
				System.out.println("\nQuestion 3 (Reverse String): ");
				//QThree q3 = new QThree();
				System.out.print("Please enter a string to be reversed: ");
				input.readInput();
				if(input.getStringInput().length() > 0) {
					System.out.println(input.getStringInput());
				} else {
					System.out.println("Not valid String");
				}
			}
		
			public void question4() throws IOException{
				//Question 4
				System.out.println("\nQuestion 4 (Compute N factorial): "); 
				QuestionFour q4 = new QuestionFour();
				int num;
				System.out.print("Please enter a number to find it's factorial: ");
				input.readInput();
				num = Integer.parseInt(input.getStringInput());
				if(num >= 0) {
					System.out.println(num + " Factorial: " + q4.mf.factorial(num));
				}
			}
		
			public void question5() throws IOException{
				String str;
				int index;
				
				//Question 5
				System.out.println("\nQuestion 5 (Substring method): "); 
				QuestionFive q5 = new QuestionFive();
				System.out.print("Please enter a string: ");
				input.readInput();
				str = input.getStringInput();
				System.out.print("Enter the index to split the string: ");
				input.readInput();
				index = Integer.parseInt(input.getStringInput());
				System.out.println(" Your Result: " + q5.getSubString(str, index));
			}
		
			public void question6() throws IOException{
				int num;
				
				//Question 6
				System.out.println("\nQuestion 6 (Even Integer): "); 
				QuestionSix q6 = new QuestionSix();
				System.out.print("Please enter a number: ");
				input.readInput();
				num = Integer.parseInt(input.getStringInput());
				if(q6.even(num)) {
					System.out.println(num + " is even.");
				} else 
					System.out.println(num + " is odd.");
			}
		
			public void question7(){
				//Question 7
				System.out.println("\nQuestion 7 (Sort two Employees): "); 
				QuestionSeven q7 = new QuestionSeven();
				q7.addEmp("Miguel Avila", "Software Developer", 48);
				q7.addEmp("Elizabeth Hernandez", "Web Developer", 35);
				System.out.println("Unsorted list as follows: ");
				System.out.println(q7.printList());
				System.out.println("\nSort by the name: ");
				System.out.println(q7.SortName().toString());
				System.out.println("\nSort by the  department: ");
				System.out.println(q7.SortDepartment());
				System.out.println("\nSort by the age: ");
				System.out.println(q7.SortAge());
			}
		
			public void question8(){
				//Question 8
				System.out.println("\nQuestion 8 (Store String): "); 
				QuestionEight q8 = new QuestionEight("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did");
				System.out.println("Original String: [karan, madam, tom, civic, radar, jimmy, kayak, john, refer, billy, did]");
				System.out.println("Palindrome String: " + q8.findPalindromes());
			}
		
			public void question9(){
				//Question 9
				System.out.println("\nQuestion 9 (Create an Arary List: "); 
				QuestionNine q9 = new QuestionNine(100);
				System.out.println(q9.findPrimes());
			}
		
			public void question10() throws IOException {
				//Question 10
				System.out.println("\nQuestion 10 (Find a minimum of two numbers): "); 
				QuestionTen q10 = new QuestionTen();
				System.out.print("Enter two numbers: ");
				input.readInput();
				System.out.print("Minimum of the two: " + q10.findMinOfTwo(input.getStringInput().split(" ")) + "\n");
			}
		
			public void question11(){
				//Question 11
				System.out.println("\nQuestion 11 (Two float variables): "); 
				QuestionEleven q11 = new QuestionEleven();
				q11.printFloats();
			}
		
			public void question12(){
				//Question 12
				System.out.println("\nQuestion 12 (Store Numbers): "); 
				QuestionTwelve q12 = new QuestionTwelve(100);
				System.out.println(q12.getEvenNumbers().toString());
			}
		
			public void question13(){
				//Question 13
				System.out.println("\nQuestion 13 (Display Triangle): ");
				QuestionThirteen q13 = new QuestionThirteen();
				System.out.println(q13.printBinaryTriangle(false, 4));
			}
		
			public void question14() throws NumberFormatException, IOException{
				//Question 14
				System.out.println("\nQuestion 14 (Demonstrate Switch Case): ");
				QuestionFourteen q14 = new QuestionFourteen();
				int selection, number = 0;
				System.out.println("\n=== Menu ===");
				System.out.println(" 1. Find the square root of a number using Math class method");
				System.out.println(" 2. Display current date and time");
				System.out.println(" 3. Split a string into an array");
				System.out.println("Any other to quit");
				System.out.print("Selected: ");
				input.readInput();
				selection = Integer.parseInt(input.getStringInput());
				if(selection == 1) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					System.out.println("Please enter a number to find the square root: ");
					number = Integer.parseInt(reader.readLine());
				}
				System.out.println(q14.switching(selection, number, new Date(), "I am learning Core Java"));
			}
		
			public void question15(){
				//Question 15
				System.out.println("\nQuestion 15 (Defines an interface): ");
				QFifteen q15 = new QFifteen();
				System.out.println("Num1: 20, Num2: 10");
				System.out.println("Addition: " + q15.addition(20, 10));
				System.out.println("Subtraction: " + q15.subtraction(20, 10));
				System.out.println("Multiplication: " + q15.multiplication(20, 10));
				System.out.println("Division: " + q15.division(20, 10));
			}
		
			public void question16(String [] args){
				//Question 16
				System.out.println("Question 16 (Character for String: ");
			}
		
			public void question17() throws IOException{
				//Question 17
				System.out.println("\nQuestion 17 (Principal and Intrest Rate: ");
				QuestionSeventeen q17 = new QuestionSeventeen();
				System.out.print("Enter the principal amount: ");
				input.readInput();
				q17.setPrincipal(Double.parseDouble(input.getStringInput()));
				System.out.print("Enter the rate as a %: ");
				input.readInput();
				q17.setRate(Double.parseDouble(input.getStringInput()));
				System.out.print("Enter the number of years: ");
				input.readInput();
				q17.setYears(Integer.parseInt(input.getStringInput()));
				System.out.println("Interested Earned: $" + String.format("%.2f", q17.findInterest()));
			}
		
			public void question18() throws IOException{
				int numInput;
				//Question 18
				System.out.println("\nQuestion 18 (Abstract Methods): ");
				QEighteen q18 = new QEighteen();
				
				System.out.println("\n=== Menu ===");
				System.out.println(" 1. Checks for UPPERCASE characters in a string");
				System.out.println(" 2. Converts all lower cases into an UPPERCASE");
				System.out.println(" 3. Adds 10 to an integer");
				System.out.print("=Selection: ");
				input.readInput();
				numInput = Integer.parseInt(input.getStringInput());
				if(numInput >= 1 && numInput <= 3) {
					System.out.print("PLease enter a string: ");
					input.readInput();
					q18.setStr(input.getStringInput());
					switch(numInput) {
						case 1:
							if(q18.checkUppercase()) {
								System.out.println("UPPERCASE exist");
							} else {
								System.out.println("No UPPERCASE exist");
							}
							break;
						case 2:
							System.out.println("Original: " + q18.getStr());
							System.out.println("New String: " + q18.toUppercase());
							break;
						case 3:
							System.out.println("Original: " + q18.getStr());
							System.out.println("New String: " + q18.toIntegerAndAdd());
							break;
						default:
							break;
					}
				}
			}
		
			public void question19(){
			//Question 19
			System.out.println("\nQuestion 19 (Create an ArrayList): ");
			QuestionNineteen q19 = new QuestionNineteen(10);
			System.out.println(q19.addEvenNumbers());
			System.out.println(q19.addOddNumbers());
			System.out.println(q19.removePrimes());
		}
		
			public void question20() throws Exception{
			//Question 20
			System.out.println("\nQuestion 20 (Data.txt): ");
			QuestionTwenty q20 = new QuestionTwenty();
			System.out.println(q20.readFileLines(":").toString());
		}

		public static void main(String[] args) throws Exception{	
			Scanner scan = new Scanner(System.in);
			int menuOption;
			Driver d = new Driver();
			
			do {
				System.out.println("\n**Homework**");
				System.out.println("Question 1. Bubble sort");
				System.out.println("Question 2. 25 Fibonacci Numbers");
				System.out.println("Question 3. Reverse String w/o reverse()");
				System.out.println("Question 4. N factorial");
				System.out.println("Question 5. Substring from an index");
				System.out.println("Question 6. Even integer without %");
				System.out.println("Question 7. Sort two employees with comparator");
				System.out.println("Question 8. Find palindromes");
				System.out.println("Question 9. Print primes from 1-100");
				System.out.println("Question 10. Minimun using ternary");
				System.out.println("Question 11. Get floats from another package");
				System.out.println("Question 12. Print evens from 1-100 using enhanced for loop");
				System.out.println("Question 13. Binary Triangle with loops");
				System.out.println("Question 14. Switching cases");
				System.out.println("Question 15. Operator Interface Methods");
				System.out.println("Question 16. Number of chars in String[] args");
				System.out.println("Question 17. Calculate simple interest");
				System.out.println("Question 18. Abstract class to modify string");
				System.out.println("Question 19. Add, subtract, remove prime from ArrayList 1-10");
				System.out.println("Question 20. Read data and format string");
				System.out.print("= Selection (0-Exit): ");
				menuOption = scan.nextInt();
				
				switch(menuOption) {
				case 1:
					d.question1();
					break;
				case 2:
					d.question2();
					break;
				case 3:
					d.question3();
					break;
				case 4:
					d.question4();
					break;
				case 5:
					d.question5();
					break;
				case 6:
					d.question6();
					break;
				case 7:
					d.question7();
					break;
				case 8:
					d.question8();
					break;
				case 9:
					d.question9();
					break;
				case 10:
					d.question10();
					break;
				case 11:
					d.question11();
					break;
				case 12:
					d.question12();
					break;
				case 13:
					d.question13();
					break;
				case 14:
					d.question14();
					break;
				case 15:
					d.question15();
					break;
				case 16:
					d.question16(args);
					break;
				case 17:
					d.question17();
					break;
				case 18:
					d.question18();
					break;
				case 19:
					d.question19();
					break;
				case 20:
					d.question20();
					break;
				}
				System.out.println("\nPress enter to continue.");
				scan.nextLine();
				scan.hasNextLine();
			} while(menuOption > 0 && menuOption <= 20);
			scan.close();
			d.input.reader.close();
		}
	}