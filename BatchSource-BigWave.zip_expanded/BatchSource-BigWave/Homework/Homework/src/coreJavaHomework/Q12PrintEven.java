package coreJavaHomework;

public class Q12PrintEven {
	public static void printEven(){
		int [] nums=new int[100];
		for (int i=0;i<100;i++){
			nums[i]=i+1;}
		for(int i : nums) {
			if((i%2)==0)
				System.out.print(i +" ");
		}
		System.out.println("\n");
	}
}
