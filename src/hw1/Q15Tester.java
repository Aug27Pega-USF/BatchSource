package core;

import java.util.Scanner;

public class Q15Tester {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		double a = 0;
		double b = 0;
		boolean check=false;
		String operation;
		Q15Class q15class= new Q15Class();
        do{
        	System.out.println("Input first number:");
        	if(sc.hasNextDouble()) {
        	a= sc.nextDouble();
        	check=true;
        }else {
        	sc.nextLine();
        	System.out.println("Enter a valid number.");
        }
        }while(!check);
        check=false;
        do{
        	System.out.println("Input second number:");
        	if(sc.hasNextDouble()) {
        	b= sc.nextDouble();
        	check=true;
        }else {
        	sc.nextLine();
        	System.out.println("Enter a valid number.");
        }
        }while(!check);
        check=false;
    	System.out.println("Input operation. ( '+' , '-' , '*' , '/' )");
        do{
        	operation=sc.nextLine();
        	if (operation.length()==1) {
        		switch(operation.charAt(0)) {
        		case '+':
        			System.out.println("Answer: "+ q15class.add(a, b));
        			check=true;
        			break;
        		case '-':
        			System.out.println("Answer: "+ q15class.minus(a, b));
        			check=true;
        			break;
        		case '*':
        			System.out.println("Answer: "+ q15class.multiply(a, b));
        			check=true;
        			break;
        		case '/':
        			System.out.println("Answer: "+ q15class.divide(a, b));
        			check=true;
        			break;
        		default:
        			System.out.println("Enter a valid operation.") ;System.out.println("Input operation. ( '+' , '-' , '*' , '/' )");
        		}
        	}
        	else if(operation.length()==0) {
        	}
        	else {System.out.println("Enter a valid operation.");
        	System.out.println("Input operation. ( '+' , '-' , '*' , '/' )");}
        	
        }while(!check);
	}
}
