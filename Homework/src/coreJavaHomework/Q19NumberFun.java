package coreJavaHomework;

import java.util.ArrayList;
import java.util.List;

public class Q19NumberFun {
	
	public static void NumberFun(){
		List<Integer> numbers = new ArrayList<>();
		int testNumber;
		for (int i=0;i<10;i++) {
			numbers.add(i+1);
		}
		System.out.println(numbers);
		int even=0;
		int odd=0;
		for (int i=9;i>=0;i--){
			testNumber = numbers.get(i);
			if( ( testNumber %2)==0 ) 
				even+=testNumber;
			if( ( testNumber %2)!=0 )
				odd+=testNumber;
	
			boolean flag = false;
	        for(int j = 2; j <= testNumber/2; ++j)
	        {
	            // condition for nonprime number
	            if(testNumber % j == 0)
	            {
	                flag = true;
	                break;
	            }
	        }
	        	if (flag ==false&&testNumber!=1)
	        		numbers.remove(i);
		}	
		System.out.println("Total Even Numbers: "+even);
		System.out.println("Total Odd Numbers: "+odd);
		System.out.println(numbers);
	}
}

	

