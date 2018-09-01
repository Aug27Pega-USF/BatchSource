package com.revature.io;

import com.revature.beans.Person;

public class SerializedDemo {

	public static void main(String[] args) {
		/*
		 * if output.txt doesn't exist, it will create it!
		 * If it doesn't exist, run it, and refresh the project explorer to find it
		 */
		IO io = new IO();
		//io.writeOutputStreamContent("Huzzah!");
		//System.out.println(io.readInputStreamContents());
		Person p = new Person("Lucina", 18, 120);
		Person s = new Person("Roy", 21, 175);
		IOWithCollections.personList.add(p);
		IOWithCollections.personList.add(s);
		
//		IOWithCollections.writePersonFile();
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.get(0));
		System.out.println(IOWithCollections.personList.get(1));
	}

}
