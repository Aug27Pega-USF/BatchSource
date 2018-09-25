package com.revature.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo2 {
	
	public static void main (String[] args)
	{
		A a= new A();
		Class<?> c= a.getClass();
		System.out.println("Private methods:");
		Method m[]= c.getDeclaredMethods();
		for(int i=0; i<m.length;i++)
		{
			int modifiers= m[i].getModifiers();
			if(Modifier.isPrivate(modifiers))
			{
			System.out.println(" " + m[i].getName());
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


