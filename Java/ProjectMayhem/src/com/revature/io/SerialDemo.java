package com.revature.io;

import com.revature.beans.Person;

public class SerialDemo {

	public static void main(String[] args) {
		/*if output.txt does not exist, it will create it!
		 * If it doesnt exist, run it, and then refresh the project
		 * explorer to see it
		 * 
		 */
		IO io=new IO();
		//io.writeOutputStreamContents(" Roll Tide");
		// the file that is being read from must exist!
		//System.out.println(io.readInputStreamContents());
		Person p= new Person("Matt",32, 265);
		Person s =  new Person("Tony",48,220);
		Person t= new Person("Robin", 40,268);
		IOWIthCollections.personList.add(p);
		IOWIthCollections.personList.add(s);
		IOWIthCollections.personList.add(t);
		
		//IOWIthCollections.writePersonFile();
		IOWIthCollections.readPersonFile();
		System.out.println(IOWIthCollections.personList.get(0).getName());
		System.out.println(IOWIthCollections.personList.get(1).getName());
		System.out.println(IOWIthCollections.personList.get(2).getName());
	}

}
