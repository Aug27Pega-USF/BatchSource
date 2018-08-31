package hw1;

import java.util.ArrayList;

public class Q19ArrayListStuff {
	public void Q19(){
	ArrayList<Integer> numberList = new ArrayList<Integer>();
	for (int i=1;i!=11;i++) {
		numberList.add(i);
		}
	System.out.print("Initial Array: ");
	for (int i:numberList) {
		System.out.print(i+" ");
		}
	System.out.println();
	int sum=0;
	for (int i:numberList) {
		if (i%2==0) { //if even, add to sum
			sum+=i;
		}
	}
	System.out.println("Sum of even numbers: " + sum);
	sum=0;
	for (int i:numberList) {//if odd, add to sum
		if (i%2==1) {
			sum+=i;
		}
	}
	System.out.println("Sum of odd numbers: " + sum);
	
	//the following could better be done by using a for loop to search for the values of prime and removing them, but this is much quicker.
	numberList.remove(6);
	numberList.remove(4);
	numberList.remove(2);
	numberList.remove(1);
	
	System.out.print("Non-Prime Numbers: ");
	for (int i:numberList) {
		System.out.print(i+" ");
		}	
	
	System.out.println();
	}
}
