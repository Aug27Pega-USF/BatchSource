package com.revature.homework;

public class Q13 {
	void display(int row) {
		System.out.println("\n\nQ13: Displaying a triangle of 1's and 0's.");
		
		int count = 1;
        for(int i=1;i<=row;i++) {
            for(int j=0;j<i;j++) {
                if(count%2!=0) {
                    System.out.print("0");
                }
                else {
                    System.out.print("1");
                }
                count++;
            }
            System.out.print("\n");
        } 
	}
}
