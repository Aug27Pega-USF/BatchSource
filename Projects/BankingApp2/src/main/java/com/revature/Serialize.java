package com.revature;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.NoSuchElementException;

public final class Serialize implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*write many User objects to file*/
	public <T> void writeToFile(HashMap<?, ?> customerMap, File file) {
		ObjectOutputStream outStream = null;
				try {
					outStream = new ObjectOutputStream(new FileOutputStream(file));	
					outStream.writeObject(customerMap);
				} catch (IOException e) {
					System.out.println("Error Opening File.");
				} catch(NoSuchElementException e) {
					System.out.println("Invalid input.");
				} finally {
					try {
						if(outStream != null)
							outStream.close();	
				} catch (IOException e) {
					System.out.println("Error Closing File");
				}
	}

	}
	
	/*Read users from file*/
	@SuppressWarnings("unchecked")
	public <T> HashMap<Integer,T> readFromFile(File file){
		HashMap<Integer, T> map = new HashMap<Integer,T>();
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(file));
			while(true) {
			 map = (HashMap<Integer, T>) inputStream.readObject();				
			}
		} catch(EOFException e) {
			return map;
		} catch (ClassNotFoundException e) {
			System.out.println("Object creation failed.");
		} catch(IOException e) {
			System.out.println("Error opening file.");
			e.printStackTrace();
		} finally {
			try {
				if(inputStream != null)
					inputStream.close();
			} catch(IOException e) {
				System.out.println("Error closing file.");
			}
		}
		return map;
	}
	}
