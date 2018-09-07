package coreJavaHomework;

public class Q19NumberFun {
	
	public static void NumberFun(){
		int [] nums= {1,2,3,4,5,6,7,8,9,10};
		int even=0;
		int odd=0;
	
		for (int i:nums)
			System.out.print(i + " ");
		System.out.println("\n");
	
		for (int i:nums) {
			if((i%2)==0)
				even+=i;
			if((i%2)!=0)
				odd+=i;
		}	
		System.out.println("Total Even Numbers: "+even);
		System.out.println("Total Odd Numbers: "+odd);
		
		for (int i :nums){
			boolean prime=true;
			for(int j =2; j>(i); j++) {
				if ((i)%j==0){
					prime=false;
					break;}
				if (prime)
				nums[i]=0;
			}
				
		}
		for(int i: nums)
			if (i!=0)
				System.out.println(i+" ");
		}
}

	

