package com.revature.homework;

import java.util.*;

public class Q9 {
	void showPrimes() {
		System.out.println("\nQ9: Printing out only prime numbers between 1 and 100.");
		ArrayList<Integer> range = new ArrayList<Integer>();
		// Adding the values from 1 to 100 into the int ArrayList
		for(int i = 1; i <= 100; i++) {
			range.add(i);
		}
		
		for(int num : range) {
			if(isPrime(num)) {
				System.out.print(num + " ");
			}
			else {
				continue;
			}
		}
	}
	
	static boolean isPrime(int num) {
		//check if num is 1
		if(num == 1) {
			return false; //this is false because 1 is technically NOT a true prime number
		}
		//check if num is 2
		if(num == 2) {
			return true;
		}
	    //check if num is a multiple of 2
	    if(num % 2 == 0) {
	    	return false;
	    }
	    //if not, then just check the odds
	    for(int i = 3; i * i <= num; i += 2) {
	        if(num % i == 0) {
	        	return false;
	        }
	    }
	    return true;
	}

}
////Another method of checking for primes up to a certain number that makes
////it easier to check again at a future moment in the program's lifetime.

////will contain true or false values for the first 10,000 integers
//boolean[] primes=new boolean[10000]; 
////set up the prime sieve
//public void fillSieve() {
// Arrays.fill(primes,true);        // assume all integers are prime.
// primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.
// for (int i=2;i<primes.length;i++) {
//     //if the number is prime, 
//     //then go through all its multiples and make their values false.
//     if(primes[i]) {
//         for (int j=2;i*j<primes.length;j++) {
//             primes[i*j]=false;
//         }
//     }
// }
//}
//
//public boolean isPrime(int n) {
// return primes[n]; //simple, huh?
//}

