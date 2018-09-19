package core.java.assignment;

import java.util.ArrayList;
import java.util.List;

public class QuestionNine {
	ArrayList<Integer> numList = new ArrayList<Integer>();
	
	public QuestionNine(int lastNumber) {
		for(int i = 0; i < lastNumber; i++) {
			numList.add(new Integer(i + 1));
		}
	}
	
	public List<Integer> findPrimes() {
		List<Integer> primeList = new ArrayList<Integer>();
		for(Integer i : numList) {
			if(i >= 2) {
				for(int d = 2; d <= i; d++) {
					if(d == i) {
						primeList.add(i);
					} else if(i % d == 0) {
						break;
					}
				}
			}
		}
		return primeList;
	}
}
