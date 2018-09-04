package core.java.assignment;

public class QuestionThirteen {
	public void printBinaryTriangle(boolean startingBinary, int tiers) {
		for(int i = 1; i <= tiers; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print((startingBinary ? 1 : 0 )+ " ");
				startingBinary = !startingBinary;
			}
			System.out.println();
		}
	}
}
