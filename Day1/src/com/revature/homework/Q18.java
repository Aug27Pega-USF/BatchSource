package com.revature.homework;

public abstract class Q18 {
	public abstract boolean uppercasecheck(String s);
	public abstract String makeUppercase(String s);
	public abstract int add10(String s);	
}

class myQ18 extends Q18{

	@Override
	public boolean uppercasecheck(String str) {
		// TODO Auto-generated method stub
		return !str.equals(str.toLowerCase());
	}

	@Override
	public String makeUppercase(String s) {
		// TODO Auto-generated method stub
		return s.toLowerCase();
	}

	@Override
	public int add10(String s) {
		// TODO Auto-generated method stub
		int result = Integer.parseInt(s);
		System.out.println("add10 is: " + (result + 10));
		return result+10;
		
	}
	
}