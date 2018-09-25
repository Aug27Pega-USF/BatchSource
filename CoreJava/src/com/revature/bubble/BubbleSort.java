package com.revature.bubble;

public class BubbleSort {

	public static void main(String[] args) {
		
		int [] bubble = {1,0,5,6,3,2,3,7,9,8,4};
		//{0,1,2,3,3,4,5,6,7,8,9}
		int temp;
		for(int i = 1; i < bubble.length; i++) {
			if(bubble[i-1] > bubble[i]) {
				temp = bubble[i];
				bubble[i] = bubble[i-1];
				bubble[i-1] = temp;
			}	
		}
		for(int y: bubble) {
			System.out.print(" " +y);
		}
	}

}
