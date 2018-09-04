package core.java.assignment;

public class QuestionFour {
	class MathFunctions{
		public int factorial(int startNum) {
			if(startNum == 0 || startNum == 1) {
				return 1;
			}
			return startNum * factorial(startNum - 1);
		}

	}

	MathFunctions mf;
	
	public QuestionFour() {
		mf = new MathFunctions();
	}
	
	public void findFactorial(int x) {
		System.out.println(x + " Factorial: " + mf.factorial(x));
	}
}
