package homework;

public class example {

	public static double add(int a, double b){
        double sum = (double) a + b;
        return sum;
    }
	public static int add(int ...a ){
        int sum = 0;
        for(int i: a)
        	sum += i;
        return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(5,7.9));
		System.out.println(add(1,2,3,4,5,6,7));
	}
	
}
