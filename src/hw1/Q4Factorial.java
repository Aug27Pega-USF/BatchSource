package hw1;

public class Q4Factorial {

	public void facto(int n){
		int exclamation=1;
		for(int i=n; i!=0; i--) {
			exclamation=exclamation*i;
		}

		System.out.println(n+"!="+ exclamation);
	}
}
