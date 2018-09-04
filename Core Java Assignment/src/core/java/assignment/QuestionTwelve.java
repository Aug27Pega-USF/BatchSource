package core.java.assignment;

import java.util.ArrayList;

public class QuestionTwelve {
	ArrayList<Integer> numList = new ArrayList<Integer>();
	
	public QuestionTwelve(int lastNumber) {
		for(int i = 0; i < lastNumber; i++) {
			numList.add(new Integer(i + 1));
		}
	}
	
	public void printEvenNumbers() {
		System.out.println("Evens between 1-" + (numList.size()) + ": ");
		for(Integer i : numList) {
			if((i & 1) == 0) {
				System.out.print(i + ", ");
			}
		}
	}
}
