package core.java.assignment;


public class QuestionTwo {
	public class Fibonacci{
		public int startNum, nextNum, stopSequence;
	
		public Fibonacci(int sequenceNum) {
			this(0, 1, sequenceNum);
		}
	
		public Fibonacci(int firstNum, int secondNum, int sequenceNum) {
			startNum = firstNum;
			nextNum = secondNum;
			stopSequence = sequenceNum;
		}
	
		public int findFibonacciNumber() {
			return findFibonacciNumber(startNum, nextNum, 2);
		}
	
		int findFibonacciNumber(int startNum, int nextNum, int currentSequence) {
			if(currentSequence < stopSequence) {
				return findFibonacciNumber(nextNum, startNum + nextNum, currentSequence + 1);
			}
			return startNum + nextNum;
		}
	}
	
	public Fibonacci fb;
	
	public QuestionTwo() {
		fb = new Fibonacci(25);
	}
	
}
