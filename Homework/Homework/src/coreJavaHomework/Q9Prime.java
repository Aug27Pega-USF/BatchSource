package coreJavaHomework;

import java.util.ArrayList;

public class Q9Prime {
	
	public static void prime(){
		boolean prime;
			ArrayList<Integer> arr=new ArrayList<Integer>();
			System.out.println("Prime: ");
			for (int i=1;i<=100;i++){
				arr.add(i);
				prime=true;
				for(int j =2; j<(i); j++) {
					if (i%j==0){
						prime=false;
						break;}
				}
				if (prime&&(i!=1)) {
					System.out.print(i +" ");}
			}
			System.out.println("\nArray: "+ arr + "\n");
	}
}
