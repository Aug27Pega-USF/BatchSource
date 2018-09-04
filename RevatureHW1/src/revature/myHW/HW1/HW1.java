package revature.myHW.HW1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
// ESSENTIAL IMPORTS
import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import revature.myHW.PackageForQ11.Q11Package;

//BUBBLE SORT ALGORITHM IMPLEMENTATION
class BubbleSort
{
	void bubbleSort(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (arr[j] > arr[j+1])
				{
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
	}
	// Prints the array 
	void printArray(int arr[]) {
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

// EMPLOYEE CLASS
class employee {
	//Sort two employees based on their name, department, and age using the Comparator interface. ");
	private String name;
	private String department;
	private int age;
	
	// Constructor
	public employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	// Getters/Setters - Accessors/Mutators
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
}

// Employee Comparators
class employeeNameComparator implements Comparator<employee>{
	// Implements compare() from Comparator interface!
	@Override
	public int compare(employee arg0, employee arg1) {
		return (int)(arg0.getName().compareTo(arg1.getName()) );
	}
}
class employeeDepartmentComparator implements Comparator<employee>{
	// Implements compare() from Comparator interface!
	@Override
	public int compare(employee arg0, employee arg1) {
		return (int)(arg0.getDepartment().compareTo(arg1.getDepartment()) );
	}
}
class employeeAgeComparator implements Comparator<employee>{
	// Implements compare() from Comparator interface!
	@Override
	public int compare(employee arg0, employee arg1) {
		return (arg0.getAge() - arg1.getAge());
	}
}

// Question 15 - Class 'Calc' implements interface 'Calculator'
class Calc implements Calculator {
	
	@Override
	public float add(float x, float y) {
		return (x+y);
	}
	@Override
	public float subtract(float x, float y) {
		return (x-y);
	}
	@Override
	public float multiply(float x, float y) {
		return(x*y);
	}
	@Override
	public float divide(float x, float y) {
		return(x/y);
	}
}

// Question 18 stuff to show inheritance
	// Abstract class with abstract methods
abstract class stringFunctions {

	stringFunctions(){
		super();
	}
	abstract boolean checkUpperCase(String s);
	abstract String convertToLowerCase(String s);
	abstract int convertToIntegerAddTen(String s);
}
	// Concrete class that inherits from abstract class
	// and overrides abstract methods.
class stringManipulation extends stringFunctions {
	
	stringManipulation() {
		super();
	}
	@Override
	boolean checkUpperCase(String s) {
		for(char c: s.toCharArray()) {
			if(Character.isUpperCase(c))
				return true;
		}
		return false;
	}
	@Override
	String convertToLowerCase(String s) {
		String ss = new String(s.toLowerCase());
		return ss;
	}
	@Override
	int convertToIntegerAddTen(String s) {
		int X = Integer.valueOf(s);
		X += 10;
		return X;
	}
}



// Main class with 'main' method
public class HW1 {

	private static final String inFile = "Data.txt";

	public static void Q1() {
		// Array to be sorted.
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		BubbleSort bs = new BubbleSort();
		System.out.println("Answer to Q1 - Use BubbleSort to sort this array: 1,0,5,6,3,2,3,7,9,8,4  ");
	    System.out.println("Unsorted array");
	    bs.printArray(arr);
		// Sort
		bs.bubbleSort(arr);
	    System.out.println("Sorted array");
		// Print out using member function
	    bs.printArray(arr);
	    System.out.println();
	}
	
	static void fibonacci(int startNum, int numIterations) {

		int [] arr = new int[numIterations];
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 0; i < numIterations; i++) {
			if( i<2 )
				System.out.print(arr[i] + " " );
			else {
				arr[i] = arr[i-1] + arr[i-2];
				System.out.print(arr[i] + " " );
			}			
		}
		
		System.out.println();
	}
	
	
	public static void Q2() {
		System.out.println("Answer to Q2 - First 25 numbers of Fibonacci sequence starting at 0: ");
		int startNum = 0;
		int numIterations = 25;
		fibonacci(startNum,numIterations);
		System.out.println();
	}
	
	static String reverseString(String s) {
		for (int i = 0; i < s.length(); i++) {
		    s = s.substring(1, s.length() - i)
		        + s.substring(0, 1)
		        + s.substring(s.length() - i, s.length());
		 }
		return s;
	}
	
	
	public static void Q3() {
		System.out.println("Answer to Q3 - Reverse string without use of temp variable or reverse().  ");
		String s = new String("Hello");
		System.out.println(s);
		s = reverseString(s);
		System.out.print(s);
		System.out.println();
		System.out.println();
	}
	
	static int factorial(int n) {
		if(n>1)
			return n * factorial(n-1);
		else
			return 1;
	}
	
	
	public static void Q4() {
		System.out.println("Answer to Q4 - Compute N factorial.  ");
		int n = 5;
		System.out.println("Factorial of " + n +" is: ");
		System.out.println(factorial(n));
		System.out.println();		
	}
	
	static String getSubString(String S, int idx) {
		String X = "";
		
		for(int i = 0; i < idx; i++)
			X += S.charAt(i);
		return X;
	}
	
	
	public static void Q5() {
		System.out.println("Answer to Q5 - Get substring of string up until given index. ");
		int idx = 5;
		String S = "Potato";
		
		if(idx > S.length()- 1|| idx < 0) {
			System.out.println("Error in choosing index number. Index exceeds string length OR index is negative. Correct this and try again. ");
		}
		else {
			System.out.println("String is: " + S);
			System.out.println("Substring of string from index 0 to index " + idx + " is:");
			System.out.println(getSubString(S, idx));
		}
		System.out.println();		
	}
	
	
	public static void Q6() {
		System.out.println("Answer to Q6 - Find if number is even without modulus operator. ");
		// Number to be discerned odd or even
		int x = 6;
		System.out.println("Number to be discerned odd or even is:  " + x);
		int y = x/2;
		if(y*2 == x)
			System.out.println("The number " + " is even");
		else
			System.out.println("The number " + " is odd");
		System.out.println();			
	}
	
	public static void Q7() {
		System.out.println("Answer to Q7 - Sort two employees based on their name, department, and age using the Comparator interface. ");
		
		ArrayList <employee> EmployeeList = new ArrayList<employee>();
		
		EmployeeList.add(new employee("Steven", "Engineering", 44));
		EmployeeList.add(new employee("Abby", "Sales", 29));

		System.out.println("Here are the two employees sorted by NAME: ");
		EmployeeList.sort(new employeeNameComparator());
		System.out.println(EmployeeList);
		
		System.out.println("Here are the two employees sorted by DEPARTMENT: ");
		EmployeeList.sort(new employeeDepartmentComparator());
		System.out.println(EmployeeList);	
		
		System.out.println("Here are the two employees sorted by AGE: ");
		EmployeeList.sort(new employeeAgeComparator());
		System.out.println(EmployeeList);	
		
		System.out.println();			
	}
	
	
	
	public static void Q8() {
		System.out.println("Answer to Q8 - stores the following strings in an ArrayList and saves all the palindromes in another ArrayList ");
		ArrayList<String> X = new ArrayList<String>();
		ArrayList<String> PalindromeList = new ArrayList<String>();
		
		X.add("karan");
		X.add("madam");
		X.add("tom");
		X.add("civic");
		X.add("radar");
		X.add("jimmy");
		X.add("kayak");
		X.add("john");
		X.add("refer");
		X.add("billy");
		X.add("did");
		
		System.out.println("The following strings are in ArrayList 1. \n." + X);
		
		// Iterate over every String in the ArrayList
		for(int i = 0; i < X.size(); i++) {
			int numOfIterations = X.get(i).length() / 2;
			
			// Iterate over indexes in current String
			for(int j = 0; j < numOfIterations; j++){	
				// Compare string indexes working inwards from the outmost indexes
				if(X.get(i).charAt(j) == X.get(i).charAt( X.get(i).length()-j-1 ) ) {
					if( j == numOfIterations - 1)
						PalindromeList.add(X.get(i));
				}
				else
					break;
			}
		}
		System.out.println("The following strings are in ArrayList 2 - only the palindromes from ArrayList 1. \n." + PalindromeList);
		System.out.println();			
	}
	
	// Function that finds out if a given number is prime
	public static boolean isPrime(int num) {
		if( num == 2 || num == 3) {
			return true;
		}
		if( num % 2 == 0) {
			return false;
		}
		int sqrt = (int) Math.sqrt(num) + 1;
		for (int i = 3; i < sqrt; i+=2) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void Q9() {
		System.out.println("Answer to Q9 - Save numbers 1-100 to an array list and print out the prime numbers. ");

		ArrayList<Integer> Numbers = new ArrayList<Integer>(100);
		// add Numbers 1-100 to array list
		System.out.println(" Numbers in arraylist: ");
		for(int i = 0; i < 100; i++) {
			Numbers.add(new Integer(i+1));
			System.out.print(Numbers.get(i) + " ");
		}
		System.out.println();			
		// Print out Prime numbers
		int k;
		for(int i = 0; i < 100; i++) {
			k = Numbers.get(i);
			if(isPrime(k))
				System.out.print(Numbers.get(i) + " ");
		}
		System.out.println();	
		System.out.println();				
	}
	
	public static void Q10() {
		System.out.println("Answer to Q10 - Find the minimum of two numbers using ternary operators.");
		int x = 20;
		int y = 100;
		int z;
		System.out.println("The minimum of " + x + " and " + y + " is: ");
		
		z = (x<y) ? x : y ;
		System.out.println(z);				
		System.out.println();				
	}
	
	public static void Q11() {
		System.out.println("Answer to Q11 - Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.");
	
		Q11Package q = new Q11Package();
		
		System.out.println("Within our class 'q',which was defined within a separate package, there are two float variables.");
		System.out.println("Here is the content of float var1: " + q.getVar1());
		System.out.println("Here is the content of float var2: " + q.getVar2());

		System.out.println();
	}
	
	public static void Q12() {
		System.out.println("Answer to Q12 - Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers." );
		int [] arr = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i+1;
			if(arr[i] % 2 == 0 )
				System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println();
	}
	
	public static void Q13() {
		
		System.out.println("Answer to Q13 - Print out triangle. ");
		
		String X = "0101";
		String Y = "0101";
		boolean left = true;
		
		System.out.println(X);

		for(int i = 0; i < 3; i++) {
			if(left) {
				Y = X.substring(1,X.length()) + Y;
				X = X.substring(1,X.length());
				left = false;
			}
			else {
				Y = X.substring(0,X.length()-1) + Y;
				X = X.substring(0,X.length()-1);
				left = true;
			}
			System.out.println(X);
		}
		System.out.println(Y);
		System.out.println();

	}
	
	public static void Q14() {
		System.out.println("Answer to Q14 - ");
		System.out.println("Write a program that demonstrates the switch case. Implement the following functionalities in the cases:\n"
				+"Case 1: Find the square root of a number using the Math class method.\n"
				+"Case 2: Display today’s date.\n"
				+"Case 3: Split the following string and store it in a string array.\n 'I am learning Core Java' \n");

		int x = 3;
		
		switch(x) {
		case 1:
			int sqrt = (int) Math.sqrt(25);
			System.out.println("This is case 1:");
			System.out.println("sqrt of 25 = " + sqrt);
			break;
		case 2:
			Date date = new Date();
			System.out.println("This is case 2:");
			System.out.println(date.toString());
			break;
		case 3:
			System.out.println("This is case 3:");
			String D = "I am learning Core Java";
			String stringArr[] = new String[5];
			StringBuilder tStr = new StringBuilder();
			int i = 0;
			for(char c: D.toCharArray()) {

				if(c == ' ') {
					stringArr[i] = tStr.toString();
					i++;
					tStr.delete(0, tStr.length());
				}
				else
				if(c !=' ' ) {
					tStr.append(c);
				}
				 
				if(i == 4) {
					stringArr[i] = tStr.toString();
				}
			}
			System.out.println("The following are the contents of the string array after splitting the string '" + D + "'.");
			for(int j = 0; j < 5; j++) {
				System.out.println("Array[" + j + "] = " + stringArr[j].toString());
			}
			break;
		default:
			System.out.println("This is the default switch case...");
			break;
		}
		System.out.println();
	}
	
	public static void Q15() {
/*
 Write a program that defines an interface having the following methods: addition, 
 subtraction, multiplication, and division. Create a class that implements this interface 
 and provides appropriate functionality to carry out the required operations. Hard code 
 two operands in a test class having a main method that calls the implementing class.
 */
		System.out.println("Answer to Q15 - Write a program that defines an interface having the following "
				+ "methods: addition, subtraction, multiplication, and division. Create a class"
				+ " that implements this interface and provide appropriate functionality to carry"
				+ " out the required operations.");
		
		Calc C = new Calc();
		float x = 25.0f; 
		float y = 10.0f;
		System.out.println("Using the class' implementation of the 'add' method in the interface: ");
		System.out.println(x + " + " + y + " = " + C.add(x,y));
		System.out.println("Using the class' implementation of the 'subtract' method in the interface: ");
		System.out.println(x + " - " + y + " = " + C.subtract(x,y));
		System.out.println("Using the class' implementation of the 'multiply' method in the interface: ");
		System.out.println(x + " * " + y + " = " + C.multiply(x,y));
		System.out.println("Using the class' implementation of the 'divide' method in the interface: ");
		System.out.println(x + " / " + y + " = " + C.divide(x,y));
		System.out.println();
	}
	
	
	public static void Q16(String s) {
// Write a program to display the number of characters for a string input.
// The string should be entered as a command line argument using (String [ ] args).
		System.out.println("Answer to Q16 - Write a program to display the number of characters for a string input.");
		System.out.println("The Length of " + s + " is: " + s.length());
		System.out.println();
	}
	
	public static void Q17(String principal, String rate, String numYears) {
/*
Write a program that calculates the simple interest on the principal, rate of 
interest and number of years provided by the user. Enter principal, rate and 
time through the console using the Scanner class.
Interest = Principal* Rate* Time
*/
		float p = Float.valueOf(principal);
		float r = Float.valueOf(rate)/100.0f;
		float y = Float.valueOf(numYears);
		
		float interest = p * r * y;
		System.out.println("The interest on $" + p + " at a rate of " + r*100 + " % for " + y + " years is: $" + interest );
		System.out.println();
	}
	
	public static void Q18() {
/*
 Write a program having a concrete subclass that inherits three abstract methods 
 from a superclass. Provide the following three implementations in the subclass
 corresponding to the abstract methods in the superclass:
 
1.          	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
2.          	Convert all of the lower case characters to uppercase in the input string, and return the result.
3.          	Convert the input string to integer and add 10, output the result to the console.
Create an appropriate class having a main method to test the above setup.
 */
		System.out.println("Answer to Q17 - Write a program having a concrete subclass that inherits "
		+ "three abstract methods from a superclass. \nProvide three implementations in the sublass "
		+ "corresponding to the abstract methods in the superclass. ");
		System.out.println();
		
		// Concrete class that inherited from the abstract class
		stringManipulation strManip = new stringManipulation();

		String S1 = "hello World";
		System.out.println("Using the inherited method 'checkUpperCase', we will return a boolean to verify \n"
				+ "if there are any upper case letters in the string: " + S1);
		System.out.println("Inherited method 'checkUpperCase' returned: " + strManip.checkUpperCase(S1) );
		System.out.println();

		String S2 = new String("bEER iS GrEaT");	// creates a reference (S2) to the new string object
		System.out.println("Using the inherited method 'convertToLowerCase', we will convert all letters in the string '"
				+ S2 + "' to lowercase.");
		System.out.println("Inherited method 'convertToLowerCase' converted string '" + S2 + " to string '" 
				+ strManip.convertToLowerCase(S2) + "'.");
		System.out.println();

		// convertToIntegerAddTen
		String S3 = "169";
		System.out.println("Using the inherited method 'convertToIntegerAddTen', we will convert the string to an integer \n"
				+ "and then add ten to that same value. The string to be converted is: " + S3);
		System.out.println("Inherited method 'convertToIntegerAddTen' returned: " + strManip.convertToIntegerAddTen(S3) );
		System.out.println();

		System.out.println();
	}

	public static void Q19() {
/*
Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
Add all the even numbers up and display the result. Add all the odd numbers 
up and display the result. Remove the prime numbers from the ArrayList and 
print out the remaining ArrayList.		
 */
		System.out.println("Answer to Q19 - Create an ArrayList and insert integers 1 through 10. Display \n"
				+ "the ArrayList. Add all the even numbers up and display the result. Add all the odd numbers \n"
				+ "up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);
		arr.add(8);
		arr.add(9);
		arr.add(10);
	
		int sumOfEven = 0;
		int sumOfOdd = 0;
		
		for(int ii = 0; ii < arr.size(); ii++) {
			if(arr.get(ii).intValue() %2 == 0)  // if the number is even
				sumOfEven += arr.get(ii).intValue();
			else
				sumOfOdd += arr.get(ii).intValue();
			if(isPrime(arr.get(ii).intValue()))
				arr.remove(ii);
		}
		System.out.println("The summation of all EVEN numbers in the ArrayList is: " + sumOfEven);
		System.out.println("The summation of all ODD numbers in the ArrayList is: " + sumOfOdd);
		System.out.println("The prime numbers have been removed from the ArrayList. This is what remains: " + arr);
		System.out.println();
	}
	

	public static void Q20() {
/*
Create a notepad file called Data.txt and enter the following:
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana
 
Write a program that would read from the file and print it out to the screen in the following format:
 
Name: Mickey Mouse
Age: 35 years
State: Arizona State
	
 */
		System.out.println("Answer to Q20 - Write a program that would read from the Data.txt file and print it \n"
				+ "out to the screen with the given format.");

		InputStream is = null;
		File file = new File(inFile);
		StringBuilder s = new StringBuilder();
		StringBuilder T = new StringBuilder();
		
		String firstName = "";
		String lastName = "";
		String age = "";
		String state = "";
		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int b = 0;
		int colonCounter = 0;
		
		try {
			while((b=is.read())!=-1) {
				
				if((char)b == '\n') {
					state = T.substring(0, T.length()-1);
					System.out.println("Name: " + firstName + " " + lastName);
					System.out.println("Age: " + age + " years");
					System.out.println("State: " + state + " State");
					T.delete(0,T.length());
					System.out.println();
				}
				else
				if((char)b == ':')
				{
					if(colonCounter == 0) {
						firstName = T.toString();
						colonCounter++;
					}
					else
					if(colonCounter == 1) {
						lastName = T.toString();
						colonCounter++;
					}
					else
					if(colonCounter == 2) {
						age = T.toString();
						colonCounter = 0;
					}
					T.delete(0,T.length());
				}
				else
				if((char)b != ' ' && (char)b != '\n') {
					T.append((char)b);
				}

				// Add the char to the string that holds ALL text file contents 'as is' 
				char c = (char) b;	// this casts the byte number to a char
				s.append(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(is!=null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("These are the original contents of the text file: " + s);
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     Q1();
	     Q2();
	     Q3();
	     Q4();
	     Q5();
	     Q6();
	     Q7();
	     Q8();
	     Q9();
	     Q10();
	     Q11();
	     Q12();
	     Q13();
	     Q14();
	     Q15();
	     
	     // The following questions may utilize input from user.
	     Scanner SC = new Scanner(System.in);
	     
	     // Question 16 - The following will be used for user input required in 
	     System.out.println("Question 16 - Please enter any text. This is a requirement for the answer of question 16!  ");
	     String s = SC.nextLine();
	     // Pass in user input used for Question 16
	     Q16(s);
	     
	     // Question 17 - The following will be used for user input required 
	     System.out.println("The following are required user inputs to calculate interest in question 17!  ");
	     System.out.println("Please enter the principal:  ");
	     String principal = SC.nextLine();
	     System.out.println("Please enter the rate as a whole number (ex. 25.7% should be inserted as 25.7) :  ");
	     String rate = SC.nextLine();
	     System.out.println("Please enter the number of years:  ");
	     String years = SC.nextLine();
	     Q17(principal, rate, years);
	     
	     Q18();
	     Q19();
	     Q20();
	     
	     //Q16 add command line args
	     // Run > Run Configurations> [Your Drivera Class ]> Arguments
	     
	     SC.close();
	}

}
