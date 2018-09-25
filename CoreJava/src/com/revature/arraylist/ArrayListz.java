package com.revature.arraylist;

import java.util.List;
import java.util.*;

public class ArrayListz {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");	
		
		
		for(String s : list) {
			System.out.println( s);;
			 reverse(s);
		}
	}
	
	public static void reverse(String str) {
		for(int i = str.length() -1; (i < str.length() && i >= 0); i-- ) {
			System.out.print(str.charAt(i));
		}
	}
	/*for prime removable
	 * for (int i = 0; i<lista.size()-1; i++){
                    if (!isPrime(lista.get(i))){
                        lista.remove(lista.get(i));
                        i--;
                    }
                }
	 */

}
