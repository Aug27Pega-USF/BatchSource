package coreJavaHomework;

public class Q13Triangle {
	public static void triangle(){
		int height=4;
		int k=1;
		for (int i=1;i<=height;i++) {
			for(int j=1;j<=i;j++) {
				if(k==0)
					k++;
				else
					k--;
				System.out.print(k);
			}
			System.out.println();
		}
		System.out.println();
	}
}
