package com.revature.homework;

public class TriangleBits {
	int num;
	void PrintTriangleBits () {
	int arr [] = {0,1,0,1,0,1,0,1,0,1};
	int next = 1;
	int inc = 2;
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
	  		if (i + 1 == next){
	  			next += inc;
	  			inc++;       
	  			System.out.println();
	  		}
		}
	}
}
