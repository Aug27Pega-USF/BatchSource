package com.revature.io;

import com.revature.beans.Person;

public class SerializeDemo {

	public static void main(String[] args) {
		/*
		 * if output.txt does not exist, it will create it
		 * If it doesn't exist, run it, then refresh the project explorer
		 */
		IO io = new IO();
		//io.writeOutputStreamContents("THIS IS MY TEST");
		
		//the file that data is being read FROM must exist already
		
		//System.out.println(io.readInputStreamContents());
		
		//Person p = new Person("Matt", 32, 261);
		//Person s = new Person("Kevin", 23, 600);
		//IOWithCollections.personList.add(p);
		//IOWithCollections.personList.add(s);
		
		//IOWithCollections.writePersonFile();
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.get(0).getName());
		System.out.println(IOWithCollections.personList.get(1).getName());
	}

}
