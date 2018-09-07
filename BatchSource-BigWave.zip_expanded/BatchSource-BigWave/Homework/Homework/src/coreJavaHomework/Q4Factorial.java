package coreJavaHomework;

public class Q4Factorial {
	public static void factorial(int n) {
		int f=1;
		for (int i=1;i<(n+1);i++) {
			f*=i;
		}
		System.out.println(n + " factorial = " + f +"\n");
	}
}
