package com.revature.interfacez;

public class Calculator implements CalculatorInterface {

	@Override
	public int addition(int a, int b) {
		int c = a + b;
		System.out.println(c);
		return c;
	}

	@Override
	public int substraction(int a, int b) {
		int c = a - b;
		System.out.println(c);

		return c;
	}

	@Override
	public int multiplication(int a, int b, int... c) {
		int cd = 0;
		int d = a * b;
		for(int i = 0; i < c.length; i++) {
			cd = d * c[i];
		}
		System.out.println(cd);

		return cd;

	}

	@Override
	public int division(int a, int b) {
		int c = a/b;
		System.out.println(c);
		return c;
	}

}
