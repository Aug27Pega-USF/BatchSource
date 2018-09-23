package com.revature.javahomework;

import interfaces.QFifteenInterface;

public class QFifteen implements QFifteenInterface{

	@Override
	public int addition(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int subtraction(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int multiplication(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public double division(double num1, double num2) {
		return num1 / num2;
	}
	
}