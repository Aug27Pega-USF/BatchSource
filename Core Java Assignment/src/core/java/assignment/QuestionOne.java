package core.java.assignment;

import java.util.Arrays;

public class QuestionOne {

	public static void bubbleSort(int [] sortThisArray) {
		int sortLength = sortThisArray.length; //finds the length of the array that is going to be sorted
		 //outer loop to iterate through the length of the array, stopping at the last element in the array
		for(int j = 0; j < sortLength -1; j++) {
			//inner loop to sort the elements within the array, optimizing the algorithm a little bit by 
			//reducing the inner loop iteration with the outer loop iteration. each iteration of the outer loop
			//moves the highest unsorted element to the last position so we can skip the unnecessary step of checking
			//the previous iteration's check;
				for(int i = 0; i < sortLength - j - 1; ++i) {
					if(sortThisArray[i] > sortThisArray[i + 1]) { //compares the current element with the next element if it is greater
						int tmpValue = sortThisArray[i]; //temporarily stores the value of the greater element
						sortThisArray[i] = sortThisArray[i + 1]; //sets the value of the current element to the lower value of the next element
						sortThisArray[i + 1] = tmpValue; //sets the next value of the 
						System.out.println(Arrays.toString(sortThisArray));
					} //end if
				} //end inner loop
			} //end outer loop
	}
}
