package com.revature.hw;

//Interface definition
interface MathOperations {
	void addition(int a,int b);	
	void subtraction(int a,int b);	
	void multiplication(int a, int b);	
	void division(int a, int b);
}

//Class implementing Interface
class MathOperationsImplement implements MathOperations {
	public void addition(int a, int b) {
		int c = a+b;
		System.out.println("Sum of the numbers is: "+c);
}
	public void subtraction(int a, int b) {
		int c = a-b;
		System.out.println("Difference of the numbers is: "+c);
}
	public void multiplication(int a, int b) {
		int c = a*b;
		System.out.println("Product of the numbers is: "+c);
}
	public void division(int a, int b) {
		int c = a/b;
		System.out.println("Division of the numbers is: "+c);
}
}

//Test class
public class Question15 {
public static void main(String[] args) {

//Hardcoded the value
int a = 20;
int b = 10;
MathOperationsImplement obj = new MathOperationsImplement();

//Calling methods of class implemented the interface
obj.addition(a,b);
obj.subtraction(a,b);
obj.multiplication(a,b);
obj.division(a,b);
}
}