package com.revature.hw;

import java.util.ArrayList;
import java.util.Iterator;

public class Q9 {

	//Q9 Create an array list which stores numbers 1 to 100 and prints prime numbers
	  public static ArrayList<Integer> numberList() {
	    ArrayList<Integer> intList = new ArrayList<Integer>();
	    for(int x=1;x<=100;x++) {
	      intList.add(x);
	    }
	    return intList;	
	  }
	  
	  /*
	   * Q9 create arrayList of primes
	   * creates new arrayList to add too after parameter list is iterated through and checked for primes
	   * calls isPrime function for each index of parameter list
	   */
	   public static ArrayList<Integer> createPrimeList(ArrayList<Integer> list){
	     ArrayList<Integer> thisList = new ArrayList<Integer>();
	     for(Integer x :list) {
	       if(isPrime(x)) {
	         thisList.add(x);
	       }
	     }
	     return thisList;
	   }
	   
	   /* 
	    * Q9 check if prime
	    * One isn't prime
	    * Check two seperately
	    * check if n is multiple of two
	    * then check odds
	    * only have to go to sqrt of n because it is in the middle of its factors
	    */
	    public static boolean isPrime(Integer n) {
	      if(n==1)return false;
	      else if(n==2)return true;
	      else if(n%2==0) return false;
	      for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0){
	          return false;
	        }
	      }
	      return true;
	    }
}
