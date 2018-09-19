package com.revature.io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.revature.accounts.Accounts;


public class IOBank {

	private static final String AccountFile = "Accounts.txt";
	
	static public ArrayList<Accounts> accountList = new ArrayList<Accounts>();
	
//	public static void writeFile(String c, String file)
//	{
//		OutputStream os= null;
//		
//	}
	 public static void writeAccountFile() {
		 try {
			ObjectOutputStream objectOut= 
					 new ObjectOutputStream(new FileOutputStream(AccountFile));
			objectOut.writeObject(accountList);
			objectOut.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public static void readAccountFile() {
		 try {
		 ObjectInputStream objectIn;
		 objectIn= new ObjectInputStream( new FileInputStream(AccountFile));
		 accountList = (ArrayList<Accounts>) objectIn.readObject();
		 objectIn.close();
		 }
		 catch(EOFException e)
		 {
			 System.out.println("Empty File or reached end of file with no data");
		 } 
		 catch (IOException e) {
			 e.printStackTrace();
		 }catch (ClassNotFoundException e) {
			 e.printStackTrace();
		 }
	 }
	
}
