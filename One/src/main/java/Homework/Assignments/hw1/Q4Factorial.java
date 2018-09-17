package Homework.Assignments.hw1;

public class Q4Factorial {

	public int facto(int n){
		int exclamation=1;
		for(int i=n; i!=0; i--) {
			exclamation=exclamation*i;
		}
		return exclamation;
	}
}
