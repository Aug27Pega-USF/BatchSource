package core.java.assignment;

import core.java.assignment.utility.FifteenInterface;

public class QuestionFifteen implements FifteenInterface{

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
