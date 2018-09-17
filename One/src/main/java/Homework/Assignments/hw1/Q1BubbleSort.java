package Homework.Assignments.hw1;

public class Q1BubbleSort {

	int[] bubblesort(int arr[]) {
		int n=arr.length; // [0 1 2 3 4] n=5
		for (int i=0;i!=n-1;i++) { //iteration number-1
			for (int j=0; j!=n-1-i;j++) { //ignore iteration number +1 numbers at the back.
				if (arr[j] > arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		} 
		return arr;
	}
}
