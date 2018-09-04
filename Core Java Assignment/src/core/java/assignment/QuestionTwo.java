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
	
		public void findFibonacciNumber() {
			System.out.println("0: " + startNum + "\n1: " + nextNum);
			findFibonacciNumber(startNum, nextNum, 2);
			System.out.println();
		}
	
		public void findFibonacciNumber(int startNum, int nextNum, int currentSequence) {
			System.out.println(currentSequence + ": " + (startNum + nextNum));
			if(currentSequence < stopSequence) {
				findFibonacciNumber(nextNum, startNum + nextNum, currentSequence + 1);
			}
		}
	}
	
	public Fibonacci fb;
	
	public QuestionTwo() {
		fb = new Fibonacci(25);
	}
	
}
