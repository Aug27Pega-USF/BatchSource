package coreJavaHomework;

public class Q10TernaryMin {
	public static int TernaryMinCheck(int x, int y) {
		int min = (x<y) ? x: y;
		return min;
	}
	public static void TernaryMin() {
		int x = 10;
		int y = 25;
		System.out.println("Comparing "+ x + " and " + y +
				", The smaller is " + (TernaryMinCheck(x,y)) +"\n");
	}
}
