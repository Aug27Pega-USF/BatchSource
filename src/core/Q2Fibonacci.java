package core;

public class Q2Fibonacci {
	void Fib(int number) {
		int f=0;
		int f2=1;
		int temp;

		for(int i=0;i!=number+1;i++) {
			System.out.print(f+" ");
			temp=f;
			f+=f2;
			f2=temp;
		}
		System.out.println();
	}
}
