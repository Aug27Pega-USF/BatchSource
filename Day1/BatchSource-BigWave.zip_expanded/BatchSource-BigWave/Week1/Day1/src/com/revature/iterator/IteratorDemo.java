package com.revature.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		//Create an array List
		ArrayList<String> a1 = new ArrayList<String>();
		//Add elements to the array
		a1.add("C");
		a1.add("A");
		a1.add("E");
		a1.add("B");
		a1.add("D");
		a1.add("F");
		
		//Use iterator to display contents of a1
		System.out.println("Original Contents of a1: ");
		Iterator<String> itr = a1.iterator();
		while (itr.hasNext()) {
			String element =itr.next();
			System.out.print(element + " ");
			}
		System.out.println();
		
		//Modify objects being iterated
		ListIterator<String> litr = a1.listIterator();
		while(litr.hasNext()) {
			String element= litr.next();
			litr.set(element + "+");
		}
		System.out.println("Modified contents of a1:");
		itr=a1.iterator();
		while(itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		
		}
		System.out.println();
		
		//Display the list backwards
		System.out.println("Modified list backwards: ");
		while(litr.hasPrevious()) {
			String element = litr.previous();
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
