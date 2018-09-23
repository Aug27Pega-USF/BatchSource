package com.revature.javahomework;

public class QuestionFour {
	public class MathFunctions{
		public int factorial(int startNum) {
			if(startNum == 0 || startNum == 1) {
				return 1;
			}
			return startNum * factorial(startNum - 1);
		}

	}

	public MathFunctions mf;
	
	public QuestionFour() {
		mf = new MathFunctions();
	}

}
