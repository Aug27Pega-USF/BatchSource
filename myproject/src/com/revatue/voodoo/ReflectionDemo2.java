package com.revatue.voodoo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo2 {

	public static void main(String[] args) {
		A a = new A();
		Class <?> c = a.getClass();
		
		System.out.println("Public Methods: ");
		Method j[] = c.getDeclaredMethods();
		for(int i =0; i<j.length; i++) {
			int modifiers = j[i].getModifiers();
			if(Modifier.isPublic(modifiers)) {
				System.out.println(" "+ j[i].getName());
			}
		}
		
		
		System.out.println("Protected Methods: ");
		Method m[] = c.getDeclaredMethods();
		for(int i =0; i<m.length; i++) {
			int modifiers = m[i].getModifiers();
			if(Modifier.isProtected(modifiers)) {
				System.out.println(" "+ m[i].getName());
			}
		}
		
		
		System.out.println("Private Methods: ");
		Method b[] = c.getDeclaredMethods();
		for(int i =0; i<b.length; i++) {
			int modifiers = b[i].getModifiers();
			if(Modifier.isPrivate(modifiers)) {
				System.out.println(" "+ b[i].getName());
			}
		}
	}
}
	
	class A{
		public void a1() {
			
		}
		
		public void a2() {
			
		}
		
		protected void a3() {
			
		}
		
		private void a4() {
			
		}
	}
