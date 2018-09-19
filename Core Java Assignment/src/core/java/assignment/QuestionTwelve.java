package core.java.assignment;

import java.util.ArrayList;
import java.util.List;

public class QuestionTwelve {
	List<Integer> numList = new ArrayList<Integer>();
	
	public QuestionTwelve(int lastNumber) {
		for(int i = 0; i < lastNumber; i++) {
			numList.add(new Integer(i + 1));
		}
	}
	
	public List<Integer> getEvenNumbers() {
		List<Integer> evenNumList = new ArrayList<Integer>();
		for(Integer i : numList) {
			if((i & 1) == 0) {
				evenNumList.add(i);
			}
		}

		return evenNumList;
	}
}
