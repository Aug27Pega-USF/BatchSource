package com.revature.io;

import com.revature.beans.Person;

public class SerializedDemo {

	public static void main(String[] args) {
		/*
		 * If output.txt does not exist, it will create it!
		 * If it doesn't exist, run it, and then refresh the project explorer to see it
		 * 
		 */
		
		IO io = new IO();
		//io.writeOutputStreamContents("Roll Tide");	// Writing to
		//System.out.println( io.readInputStreamContents() );
		
		Person p = new Person("Matt", 32, 260);
		Person s = new Person("Kevin", 23, 600);
		IOWithCollections.personList.add(p);
		IOWithCollections.personList.add(s);

		
		// Write person file
		IOWithCollections.writePersonFile();

		// Read from serialization?
		System.out.println(IOWithCollections.personList.get(0).getName());
		System.out.println(IOWithCollections.personList.get(1).getName());

		
	}

}
