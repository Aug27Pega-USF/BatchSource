package com.revature.io;

import java.io.*;
import java.util.ArrayList;

import com.revature.beans.Person;

public class IOWithCollections {

	private static final String PersonFile = "Person.txt";
	
	public static ArrayList<Person> personList = new ArrayList<Person>();
	
	public static void writePersonFile() {
		
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(PersonFile));
			objectOut.writeObject(personList);
			objectOut.close();

		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readPersonFile() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(PersonFile));
			personList = (ArrayList<Person>) objectIn.readObject();
			objectIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
