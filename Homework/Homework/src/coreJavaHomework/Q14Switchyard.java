package coreJavaHomework;

import java.time.LocalDate;

public class Q14Switchyard {

	public static void switchyard(int choice) {
		switch(choice) {
		case 1:
			System.out.println("Square root of 5 = "+ java.lang.Math.sqrt(5));
			break;
		case 2:
			System.out.println(LocalDate.now());
			break;
		case 3:
			String str="I am learning Core Java";
			String[]words=str.split(" ");
			for (String a:words)
				System.out.println(a);
			break;
		}
		System.out.println();
	}
}
	
