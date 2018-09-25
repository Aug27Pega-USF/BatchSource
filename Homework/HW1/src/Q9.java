import java.util.ArrayList;

public class Q9 {

		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i=1;i!=101;i++) {
			numberList.add(i);
		}
		for (int i1=0; i!=numberList.size();i++) {
			boolean prime=true;
			int number = numberList.get(i);
			if (number==1)
				continue;
			for (int j=2; j<=Math.sqrt(number);j++) {
				if (number/j*j==number && j!=number) {
					prime=false;
				}
				continue;
			}
			if (prime) {
			System.out.print(number+" ");
			}
		}
		System.out.println();
		}
	}

