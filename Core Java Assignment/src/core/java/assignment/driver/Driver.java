package core.java.assignment.driver;

import core.java.assignment.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		//Question 1
		System.out.println("--Question 1:");
		QuestionOne q1 = new QuestionOne();
		int [] array = {1,0,5,6,3,2,3,7,9,8,4};
		q1.bubbleSort(array); //performs the bubble sorting and sends the initial values of the array
	}
	
		public void question2() {
		//Question 2
		System.out.println("\n--Question 2:");
		QuestionTwo q2 = new QuestionTwo();
		q2.fb.findFibonacciNumber();
	}
	
		public void question3() throws IOException{
		//Question 3
		System.out.println("\n--Question 3:");
		QuestionThree q3 = new QuestionThree();
		System.out.print("Enter a string to be reversed: ");
		input.readInput();
		if(input.getStringInput().length() > 0) {
			q3.printReverseString(input.getStringInput());
		} else {
			System.out.println("Nothing was entered");
		}
	}
	
		public void question4() throws IOException{
		//Question 4
		System.out.println("\n--Question 4:"); 
		QuestionFour q4 = new QuestionFour();
		int num;
		System.out.print("Enter a number to find factorial: ");
		input.readInput();
		num = Integer.parseInt(input.getStringInput());
		if(num >= 0)
			q4.findFactorial(num);
	}
	
		public void question5() throws IOException{
		String str;
		int index;
		
		//Question 5
		System.out.println("\n--Question 5:"); 
		QuestionFive q5 = new QuestionFive();
		System.out.print("Enter a string: ");
		input.readInput();
		str = input.getStringInput();
		System.out.print("Enter the index to split the string: ");
		input.readInput();
		index = Integer.parseInt(input.getStringInput());
		System.out.println("Result: " + q5.getSubString(str, index));
	}
	
		public void question6() throws IOException{
		int num;
		
		//Question 6
		System.out.println("\n--Question 6:"); 
		QuestionSix q6 = new QuestionSix();
		System.out.print("Enter a number to check if it is even: ");
		input.readInput();
		num = Integer.parseInt(input.getStringInput());
		if(q6.even(num)) {
			System.out.println(num + " is even");
		} else 
			System.out.println(num + " is odd");
	}
	
		public void question7(){
		//Question 7
		System.out.println("\n--Question 7:"); 
		QuestionSeven q7 = new QuestionSeven();
		q7.addEmp("John Doe", "Human Resources", 25);
		q7.addEmp("Jane Doe", "Information Technology", 23);
		System.out.println("Unsorted list: ");
		q7.printList();
		q7.SortName();
		System.out.println("\nSort by name: ");
		q7.printList();
		q7.SortDepartment();
		System.out.println("\nSort by department: ");
		q7.printList();
		q7.SortAge();
		System.out.println("\nSort by age: ");
		q7.printList();
	}
	
		public void question8(){
		//Question 8
		System.out.println("\n--Question 8:"); 
		QuestionEight q8 = new QuestionEight("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did");
		System.out.println("Original: [karan, madam, tom, civic, radar, jimmy, kayak, john, refer, billy, did]");
		System.out.println("Palindrome: " + q8.findPalindromes());
	}
	
		public void question9(){
		//Question 9
		System.out.println("\n--Question 9:"); 
		QuestionNine q9 = new QuestionNine(100);
		System.out.println(q9.findPrimes());
	}
	
		public void question10() throws IOException {
		//Question 10
		System.out.println("\n--Question 10:"); 
		QuestionTen q10 = new QuestionTen();
		System.out.print("Enter two numbers separated by a space: ");
		input.readInput();
		System.out.print("Minimum of the two: " + q10.findMinOfTwo(input.getStringInput().split(" ")) + "\n");
	}
	
		public void question11(){
		//Question 11
		System.out.println("\n--Question 11:"); 
		QuestionEleven q11 = new QuestionEleven();
		q11.printFloats();
	}
	
		public void question12(){
		//Question 12
		System.out.println("\n--Question 12:"); 
		QuestionTwelve q12 = new QuestionTwelve(100);
		q12.printEvenNumbers();
	}
	
		public void question13(){
		//Question 13
		System.out.println("\n--Question 13:");
		QuestionThirteen q13 = new QuestionThirteen();
		q13.printBinaryTriangle(false, 4);
	}
	
		public void question14() throws NumberFormatException, IOException{
		//Question 14
		System.out.println("\n--Question 14:");
		QuestionFourteen q14 = new QuestionFourteen();
		System.out.println("\n=== Menu ===");
		System.out.println(" 1. Find the square root of a number");
		System.out.println(" 2. Display current date and time");
		System.out.println(" 3. Split a string into an array");
		System.out.println("Any other to quit");
		System.out.print("Selected: ");
		input.readInput();
		q14.switching(Integer.parseInt(input.getStringInput()));
	}
	
		public void question15(){
		//Question 15
		System.out.println("\n--Question 15:");
		QuestionFifteen q15 = new QuestionFifteen();
		System.out.println("Num1: 15, Num2: 12");
		System.out.println("Add interface: " + q15.addition(15, 12));
		System.out.println("Subtract interface: " + q15.subtraction(15, 12));
		System.out.println("Multiply interface: " + q15.multiplication(15, 12));
		System.out.println("Divide interface: " + q15.division(15, 12));
	}
	
		public void question16(String [] args){
		//Question 16
		System.out.println("\n--Question 16:");
		System.out.print("Original Args: ");
		for(String s: args) {
			System.out.print("\"" + s + "\" ");
		}
		System.out.print("\nArgs (removed whitespaces): ");
		int charCount = 0;
		for(String s: args) {
			s = s.replaceAll(" ", "");
			charCount += s.length();
			System.out.print("\"" + s + "\" ");
		}
		System.out.println("\nCharacter Count (no whitespace): " + charCount);
	}
	
		public void question17() throws IOException{
		//Question 17
		System.out.println("\n--Question 17:");
		QuestionSeventeen q17 = new QuestionSeventeen();
		System.out.print("Enter in the principal: ");
		input.readInput();
		q17.setPrincipal(Double.parseDouble(input.getStringInput()));
		System.out.print("Enter in the rate as a %: ");
		input.readInput();
		q17.setRate(Double.parseDouble(input.getStringInput()));
		System.out.print("Enter in the time in years: ");
		input.readInput();
		q17.setYears(Integer.parseInt(input.getStringInput()));
		System.out.println("Interested Earned: $" + String.format("%.2f", q17.findInterest()));
	}
	
		public void question18() throws IOException{
		int numInput;
		//Question 18
		System.out.println("\n--Question 18:");
		QuestionEighteen q18 = new QuestionEighteen();
		
		q18.printMenu();
		System.out.print("=Selection: ");
		input.readInput();
		numInput = Integer.parseInt(input.getStringInput());
		if(numInput >= 1 && numInput <= 3) {
			System.out.print("Enter a string: ");
			input.readInput();
			q18.setStr(input.getStringInput());
			switch(numInput) {
				case 1:
					if(q18.checkUppercase()) {
						System.out.println("An upper case exist");
					} else {
						System.out.println("No upper case exist");
					}
					break;
				case 2:
					System.out.println("Original: " + q18.getStr());
					System.out.println("New: " + q18.toUppercase());
					break;
				case 3:
					System.out.println("Original: " + q18.getStr());
					System.out.println("New: " + q18.toIntegerAndAdd());
					break;
				default:
					break;
			}
		}
	}
	
		public void question19(){
		//Question 19
		System.out.println("\n--Question 19:");
		QuestionNineteen q19 = new QuestionNineteen(10);
		System.out.println(q19.addEvenNumbers());
		System.out.println(q19.addOddNumbers());
		System.out.println(q19.removePrimes());
	}
	
		public void question20() throws Exception{
		//Question 20
		System.out.println("\n--Question 20:");
		QuestionTwenty q20 = new QuestionTwenty();
		q20.readFileLines(":");
		q20.printData();
	}

	public static void main(String[] args) throws Exception{	
		Scanner scan = new Scanner(System.in);
		int menuOption;
		Driver d = new Driver();
		
		do {
			System.out.println("\n=== Core Assignment Menu ===");
			System.out.println("  1. Bubble sort");
			System.out.println("  2. 25 Fibonacci Numbers");
			System.out.println("  3. Reverse String w/o reverse()");
			System.out.println("  4. N factorial");
			System.out.println("  5. Substring from an index");
			System.out.println("  6. Even integer without %");
			System.out.println("  7. Sort two employees with comparator");
			System.out.println("  8. Find palindromes");
			System.out.println("  9. Print primes from 1-100");
			System.out.println(" 10. Minimun using ternary");
			System.out.println(" 11. Get floats from another package");
			System.out.println(" 12. Print evens from 1-100 using enhanced for loop");
			System.out.println(" 13. Binary Triangle with loops");
			System.out.println(" 14. Switching cases");
			System.out.println(" 15. Operator Interface Methods");
			System.out.println(" 16. Number of chars in String[] args");
			System.out.println(" 17. Calculate simple interest");
			System.out.println(" 18. Abstract class to modify string");
			System.out.println(" 19. Add, subtract, remove prime from ArrayList 1-10");
			System.out.println(" 20. Read data and format string");
			System.out.print("= Selection: ");
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
			default:
				break;
			}
		} while(menuOption >= 0 && menuOption <= 20);
		scan.close();
		d.input.reader.close();
	}

}
