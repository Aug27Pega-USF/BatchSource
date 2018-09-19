package core.java.assignment;

public class QuestionOne {

	public int [] bubbleSort(int [] sortThisArray) {
		int sortLength = sortThisArray.length;
		
		for(int j = 0; j < sortLength -1; j++) {
			for(int i = 0; i < sortLength - j - 1; ++i) {
				if(sortThisArray[i] > sortThisArray[i + 1]) {
					int tmpValue = sortThisArray[i];
					sortThisArray[i] = sortThisArray[i + 1];
					sortThisArray[i + 1] = tmpValue;
				}
			}
		}
		return sortThisArray;
	}
}
