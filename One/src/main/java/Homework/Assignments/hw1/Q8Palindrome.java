package Homework.Assignments.hw1;
import java.util.ArrayList;

public class Q8Palindrome {
	 ArrayList<String> palindromes= new ArrayList<>();
	
	 public void Q8() {
	        ArrayList<String> names = new ArrayList<>();
	        names.add("karan");
	        names.add("madam");
	        names.add("tom");
	        names.add("civic");
	        names.add("radar");
	        names.add("jimmy");
	        names.add("kayak");
	        names.add("john");
	        names.add("refer");
	        names.add("billy");
	        names.add("did");
	        
	        
	        
			for (int i=0; i<names.size(); i++) {
				String palincheck=names.get(i);
				int temp=1;
				for (int j=0; j!=palincheck.length()/2;j++) {
					if (palincheck.charAt(j)!=palincheck.charAt(palincheck.length()-1-j)) {
						temp=0;
						break;
					}
				}
				if(temp==1) {
					palindromes.add(palincheck);
				}
				
			}
	        System.out.println("Given List:");			
	        for (int i=0; i<names.size(); i++) {
	        	System.out.print(names.get(i)+" ");
	            }     
	        System.out.println();
	        System.out.println("Palindromes List:");
	        for (int i=0; i<palindromes.size(); i++) {
	        	System.out.print(palindromes.get(i)+" ");
	            }  
			System.out.println();
	 
	 }
	 
	 
	 
	 
}
