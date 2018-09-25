package com.revature.hw;

public class Q4Factorial {

	void GetFactorial(int n) {
		  int i,f=1;  
		  int num=n;   
		  for(i=1;i<=num;i++){    
		      f=f*i;    
		  } 
		  System.out.println(+num+"'s Factorial is: "+f);
		
	}

	
}
