package com.revatue.constructor;

public class ConstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C();
	}
}
	class A{
		A(){
			System.out.println("Inside A's constructor");
		}
	}
	
	class B extends A{ // extends A means inheritance from class A
		B(){
			System.out.println("Inside B's constructor");
		}
	}
	
	class C extends B{ //extends B means inheritance from class B
		C(){
			System.out.println("Inside C's constructor");
		}
	}

