package com.revature.inheritenceTest;

public class Bird {
	
	//instance block 
	{
		System.out.println("b1");
	}

	public Bird(){
		System.out.println("b2");
	}
	
	//static block
	static {
		System.out.println("b3");
	}
}

//class Bird{
//	  { 
//		  System.out.println("b1"); 
//		  }   	
//	  
//	  Bird() {
//	 	 //super();
//	 	 System.out.println("b2");
//	  }
//	  static {   			 
//	 	 System.out.println("b3");
//	  }	 
//	}
