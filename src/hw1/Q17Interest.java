package hw1;

import java.math.BigDecimal;
import java.util.Scanner;


public class Q17Interest {
		static Scanner sc;
	    public static void main(String[] args)
	    {
	    	boolean check=false;
	    	
	        sc = new Scanner(System.in);
	        double principal = 0;
	        double rate=0;
	        int time=0;
	        do{
	        	System.out.println("Principal in $:");
	        	if(sc.hasNextDouble()) {
	        	principal= sc.nextDouble();
	        	check=true;
	        	boolean decimalcheck=(BigDecimal.valueOf(principal).scale() > 2);
	        	if (decimalcheck) { //checks input is valid $ value.
	        		check=false; 
	        		System.out.println("Enter a valid $ value.");
	        	}
	        }else {
	        	sc.nextLine();
	        	System.out.println("Enter a valid $ value.");
	        }
	        }while(!check);
	        check=false;
	        do{
	        	System.out.println("Rate in % per year:");
	        	if(sc.hasNextDouble()) {
	        	rate= sc.nextDouble();
	        	check=true;
	        }else {
	        	sc.nextLine();
	        	System.out.println("Enter a valid rate.");
	        }
	        }while(!check);
	        check=false;
	        do{
	        	System.out.println("Time in months:");
	        	if(sc.hasNextInt()) {
	        	time= sc.nextInt();
	        	check=true;
	        }else {
	        	sc.nextLine();
	        	System.out.println("Enter a valid integer of months.");
	        }
	        }while(!check);	        

	 
	        // Print the values to check if input was correctly obtained.
	        System.out.print("Interest=");
	        double interest= principal*rate/100*(double)time/12; 
	        System.out.printf("$%.2f",interest);
	        System.out.println();
	    }
}
