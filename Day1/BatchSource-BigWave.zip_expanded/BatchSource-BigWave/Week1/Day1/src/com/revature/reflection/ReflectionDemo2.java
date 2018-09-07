package com.revature.reflection;

import java.lang.reflect.*;
//Show public methods
public class ReflectionDemo2 {

	public static void main(String[] args) {
		try {
			A a=new A();
			Class<?> c=a.getClass();
			System.out.println("Private Methods:");
			Method methods[]= c.getDeclaredMethods();
			for(int i=0;i<methods.length;i++) {
				int modifiers =methods[i].getModifiers();
				if(Modifier.isPrivate(modifiers)) {
					System.out.println(" "+ methods[i].getName());
					
				}
			}
		}catch(Exception e) {
			System.out.println("Exception: " +e);
		
		}
		
	}

}
class A{
	public void a1() {
		
	}
	public void a2(){
	}
	protected void a3() {
	}
	private void a4() {
		System.out.println("boo");
	}
}
