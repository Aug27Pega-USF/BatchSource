package core.java.assignment;

import java.util.ArrayList;
import java.util.List;

public class QuestionNineteen {
	List<Integer> numList = new ArrayList<Integer>();

	public QuestionNineteen(int size) {
		super();
		for(int i = 0; i < size; i++) {
			numList.add(new Integer(i + 1));
		}
	}
	
	public int addEvenNumbers() {
		int total = 0;
		for(Integer i : numList) {
			if((i.intValue() & 1) == 0) {
				total += i;
			}
		}
		return total;
	}
	
	public int addOddNumbers() {
		int total = 0;
		for(Integer i : numList) {
			if((i.intValue() & 1) == 1) {
				total += i;
			}
		}
		return total;
	}
	
	public List<Integer> removePrimes(){
		boolean [] marker = new boolean[numList.size()];
		
		for(int i = 0; i < numList.size(); i++) {
			if(numList.get(i) >= 2) {
				for(int d = 2; d <= numList.get(i); d++) {
					if(d == numList.get(i)) {
						marker[i] = true;
					} else if(numList.get(i) % d == 0) {
						break;
					}
				}
			}
		}
		
		for(int i = marker.length - 1; i >= 0; i--) {
			if(marker[i]) {
				numList.remove(i);
			}
		}
		return numList;
	}
}
