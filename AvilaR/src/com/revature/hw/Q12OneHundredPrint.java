package com.revature.hw;

public class Q12OneHundredPrint {

	public void storeNumber() {
		int num[] = new int[100];
	for (int i = 1; i <= 100; i++) {
		num[i - 1] = i;
	}
	for (int j : num) {
		if (j % 2 == 0)
			System.out.print(j +" ");
	}
}
}
