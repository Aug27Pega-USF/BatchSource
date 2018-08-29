package core;

import java.util.ArrayList;

public class Q12EvenNumbers {
	public void Q12(){
	ArrayList<Integer> numberList = new ArrayList<Integer>();
	for (int i=1;i!=101;i++) { //array list from 1 to 100.
		numberList.add(i);
		}
	for (int i:numberList) { //if even, print.
		if (i%2==0) {
		System.out.print(i+" ");
			}
		}
	System.out.println();
	}
}
