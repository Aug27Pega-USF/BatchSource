package coreJavaHomework;

public class Q1BubbleSort {

	public static void bubbleSort(int array[]) {
		System.out.print("Array before Sort: ");
		printNumbers(array);
		
		int n = array.length;
		int k;
		for (int m = n; m >= 0; m--) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (array[i] > array[k]) {
					switchNumbers(i, k, array);
				}
			}
		}
		System.out.print("Array after Sort: ");
		printNumbers(array);
	}
 
	private static void switchNumbers(int i, int j, int[] array) {
		int bucket;
		bucket = array[i];
		array[i] = array[j];
		array[j] = bucket;
	}
 
	private static void printNumbers(int[] input) {
		for (int i = 0; i < input.length-1; i++) {
			System.out.print(input[i] + ", ");
		}
		System.out.print(input[input.length-1]);
		System.out.println("\n");
	}
 
	public static void main(String[] args) {
	
	}
}