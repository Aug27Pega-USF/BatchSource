package com.revature.interfacez;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		int a = 7;
		int b = 3;
		int c = 5;
		calc.addition(a,b);
		calc.substraction(a, b);
		calc.multiplication(a, b, c);
		calc.division(a, b);

	}

}
