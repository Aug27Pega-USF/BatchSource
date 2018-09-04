package com.revature.homework;

public class Enhanced {

	void myLoop (int array[]) {
		for (int num : array) {
			if (num%2 == 0) System.out.print("" + num + ",");
		}
	}
}
