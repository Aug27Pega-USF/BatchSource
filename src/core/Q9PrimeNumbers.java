package core;

import java.util.ArrayList;
import java.lang.Math;

public class Q9PrimeNumbers{
	public void Q9(){
	ArrayList<Integer> numberList = new ArrayList<Integer>();
	for (int i=1;i!=101;i++) {
		numberList.add(i);
	}
	for (int i=0; i!=numberList.size();i++) {
		boolean prime=true;
		int number = numberList.get(i);
		if (number==1)
			continue;
		for (int j=2; j<=Math.sqrt(number);j++) {
			if (number/j*j==number && j!=number) {
				prime=false;
			}
			continue;
		}
		if (prime) {
		System.out.print(number+" ");
		}
	}
	System.out.println();
	}
}
