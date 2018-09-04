package coreJavaHomework;

public class Q2Fibonacci {
	static int fibo(int n)
	{
		if (n <= 1) {
			return n;}
		return fibo(n-1) + fibo(n-2);
	}
	      
	public static void fiboCounter(){
		for(int i=0;i<24;i++) {
			System.out.print(fibo(i) + ", ");}
		System.out.print((fibo(22) + fibo(23)));
		System.out.print("\n\n");
	}
}