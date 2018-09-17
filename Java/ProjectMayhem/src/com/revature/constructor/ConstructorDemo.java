package com.revature.constructor;

public class ConstructorDemo {

	public static void main(String[] args) {
		C c = new C();

	}
}
	class A{
		A(){
			System.out.println("Inside A's constructor");
		}
	}
	
	class B extends A{
		B(){
			System.out.println("Inside B's constructor");
		}
	}
	 class C extends B{
		 C(){
			 System.out.println("Inside C's Constructor");
		 }
	 }
	

