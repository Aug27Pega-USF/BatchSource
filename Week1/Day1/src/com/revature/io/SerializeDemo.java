package com.revature.io;

import com.revature.beans.Person;

public class SerializeDemo {

	public static void main(String[] args) {
		/*if output.txt does not exist, it will create it!
		 * If it does not exist, run it, and then refresh the project 
		 * explorer to see it.
		 * 
		 */
		IO io= new IO();
		//io.writeOutputStreamContents("Roll Tide");
		
		//the file that that data is being read from must exist already!
		
		//System.out.println(io.readInputStreamContents());
		
		Person p= new Person("Matt", 32, 261);
		Person s= new Person("Kevin", 230, 600);
		Person k= new Person("Nick",25,188);
		IOWithCollections.personList.add(p);
		IOWithCollections.personList.add(s);
		IOWithCollections.personList.add(k);
		
		IOWithCollections.writePersonFile();
		
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.get(0).getName());
		System.out.println(IOWithCollections.personList.get(1).getName());
		System.out.println(IOWithCollections.personList.get(2).getName());
	}
}
