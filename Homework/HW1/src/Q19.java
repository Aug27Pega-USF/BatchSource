import java.util.ArrayList;

public class Q19 {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);
		arr.add(8);
		arr.add(9);
		arr.add(10);
	
		int sumOfEven = 0;
		int sumOfOdd = 0;
		
		for(int ii = 0; ii < arr.size(); ii++) {
			if(arr.get(ii).intValue() %2 == 0)  // if the number is even
				sumOfEven += arr.get(ii).intValue();
			else
				sumOfOdd += arr.get(ii).intValue();
			if(isPrime(arr.get(ii).intValue()))
				arr.remove(ii);
		}
		System.out.println("The sum of all even numbers is: " + sumOfEven);
		System.out.println("The sum of all odd numbers is: " + sumOfOdd);
		System.out.println("The prime numbers have been removed from the ArrayList. This is what is left: " + arr);
		System.out.println();
	}

	private static boolean isPrime(int intValue) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
