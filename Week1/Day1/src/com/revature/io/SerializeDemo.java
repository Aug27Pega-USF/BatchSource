package com.revature.io;

import com.revature.beans.Person;

public class SerializeDemo {

	public static void main(String[] args) {
		/*if output.txt does not exist, it will create it!
		 * If it doesnt exist, run it, and then refresh the project
		 * explorer to see it
		 * 
		 */
		IO io =new IO();
		//io.writeOutputStreamContents("Roll Tide");
		
		//the file that data is being read FROM must exist already!
		//System.out.println(io.readInputStreamContents());
		
		Person p = new Person("Matt",32,261);
		Person s = new Person ("Kevin",23, 600);
		IOWithCollections.personList.add(p);
		IOWithCollections.personList.add(s);
		
		//IOWithCollections.writePersonFile();
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.get(0).getName());
		System.out.println(IOWithCollections.personList.get(1).getName());
	}

}
