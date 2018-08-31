package hw1;

public class Q16StringLength {

	    public static void main(String[] args)
	    {
	    	if(args.length==0) {
	    		System.out.println("No input string.");
	    	}
	    	else if (args.length>1) {
	    		System.out.println("More than one input.");
	    	}
	    	else System.out.println("The number of characters in the inputted string is: "+ args[0].length()+".");
	            
	    }
}
