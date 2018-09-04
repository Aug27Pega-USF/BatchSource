package com.revature.hw;

import java.util.ArrayList;

public class Q19 {

	//Q19 populate Array List of Integers with given list and number of ints
	  public static ArrayList<Integer> addIntegersToArrayList(ArrayList<Integer> list, Integer num){
	    for(int x=1;x<=num;x++) {
	      list.add(x);
	    }
	    return list;  
	  }
	  
	//Q19 Return sum of even integers in list
	  public static Integer sumEvens(ArrayList<Integer> list) {
	    Integer sum=0;
	    for(Integer x : list) {
	      if(Q6.isEven(x))
	      sum += x;
	    }
	    return sum;
	  }
	  //Q19 Return sum of odd integers in list
	  public static Integer sumOdds(ArrayList<Integer> list) {
	    Integer sum=0;
	    for(Integer x : list) {
	      if(!Q6.isEven(x))
	      sum += x;
	    }
	    return sum;
	  }
	  
	  //Q19 Remove Prime Numbers From List
	  //Checks list index for primes
	  //if not prime, store in new composites list and return
	  public static ArrayList<Integer> removePrimes(ArrayList<Integer> list) {
	    boolean checkPrime = false;
	    for(int i=0;i<list.size();i++) {
	      checkPrime = Q9.isPrime(list.get(i));
	      if(checkPrime) {
	        list.remove(i);
	      }
	    }
	    return list; 
	  }
}
