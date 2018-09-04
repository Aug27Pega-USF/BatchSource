package Homework;

public class calculate implements math{

	public int answer;
	@Override
	public void add() {
		// TODO Auto-generated method stub
		answer = num1 + num2;	
		System.out.println(answer);
	}

	@Override
	public void sub() {
		answer = num2 - num1;
		
		System.out.println(answer);
	}

	@Override
	public void multiply() {
		// TODO Auto-generated method stub
		answer = num1 * num2;
		
		System.out.println(answer);
	}

	@Override
	public void divide() {
		// TODO Auto-generated method stub
		 answer = num1/num2;
		 
		 System.out.println(answer);
	}
	

}
