/*
 * Q6. Write a program to determine if an integer is even without using the modulus operator (%)
 */
public class Q6 {
	
	// check for even or odd
	 
	     
	    // Returns true if n 
	    // is even, else odd
	    static boolean isEven(int n)
	    {
	        boolean isEven = true;
	         
	        for (int i = 1; i <= n; i++) 
	            isEven = !isEven;
	             
	        return isEven;
	    }
	     
	     
	    // Driver Code
	    public static void main(String args[])
	    {
	         
	        int n = 13;
	        if(isEven(n))
	            System.out.println("Even");
	        else
	            System.out.println("Odd");
	         
	    }
	}


