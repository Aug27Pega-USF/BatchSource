package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Person;

public class IOWithCollections {
	//File we are reading and writing to/from
	private static final String PersonFile = "Person.txt";
	
	static public ArrayList<Person> personList = new ArrayList<Person>();
	
	public static void writePersonFile() {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream
					(new FileOutputStream(PersonFile));
			objectOut.writeObject(personList);
			objectOut.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readPersonFile() {
		try {
		ObjectInputStream objectIn;
		objectIn = new ObjectInputStream(new FileInputStream(PersonFile));
		personList = (ArrayList<Person>)objectIn.readObject();
		objectIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
