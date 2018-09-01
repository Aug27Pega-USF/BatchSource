package homework;

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter principal:");
		int prin = scan.nextInt();
		System.out.println("Please enter rate:");
		int rate = scan.nextInt();
		System.out.println("Please enter years:");
		int yr = scan.nextInt();
		
		int interest = prin*rate*yr;
		System.out.println("Interest: " + interest);
		scan.close();
	}

}
