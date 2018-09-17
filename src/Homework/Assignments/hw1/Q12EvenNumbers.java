package Homework.Assignments.hw1;

public class Q12EvenNumbers {
	public void Q12(){
	int[] numberList = new int[100];
	for (int i=1;i!=101;i++) { //array list from 1 to 100.
		numberList[i-1]=i;
		}
	for (int i:numberList) { //if even, print.
		if (i%2==0) {
		System.out.print(i+" ");
			}
		}
	System.out.println();
	}
}
