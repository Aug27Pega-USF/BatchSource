package com.revature.support;

public class Transactions {
	public static double withdrawal(double bal, double w){
		double new_bal = bal-w;
		if(new_bal < 0)
			System.out.println("Insufficient funds to complete transaction");
		return new_bal;
	}
	public static double deposit(double bal, double d){
		double new_bal = bal+d;
		return new_bal;
	}
//	public static double transfer(double a, double b, double t) {
//		double t1 = a-t;
//		if(t1 < 0)
//			System.out.println("Insufficient funds to complete transaction");
//		double t2 = b+t;
//		return t2;
//	}
}
