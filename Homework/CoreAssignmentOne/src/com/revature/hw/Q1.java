package com.revature.hw;

public class Q1 {

	 public static int[] bubbleSort(int[] a) {
		    int i = a.length;
		    int temp=0;
		    for(int x=0;x<i;x++) {
		      for(int j=1;j<=(i-1);j++) {
		        //swap element 
		        if(a[j-1] > a[j]) {
		          temp = a[j-1];
		          a[j-1] = a[j];
		          a[j]=temp;
		        }
		      }			
		    }
			return a;
		  }
}
