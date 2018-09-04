package com.revature.bank;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.account.Account;



public class IOBank {
	//file we are reading and writing to/from
	
		private static final String BankFile="BankAccounts.txt";
		
		static public ArrayList<Account> accountList = new ArrayList<Account>();
		
		
		
		public static void writeAccountFile() {
			try {
				ObjectOutputStream objectOut= new ObjectOutputStream(new FileOutputStream(BankFile, true));
				objectOut.writeObject(accountList);
				objectOut.close();
			} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void readBankFile()
		{
			//Account a= new Account();
			//ArrayList<Account> a= new ArrayList<Account>();
			try {
				ObjectInputStream objectIn;
				objectIn= new ObjectInputStream(new FileInputStream(BankFile));			
				accountList = (ArrayList<Account>) objectIn.readObject();					
				objectIn.close();
				//accountList.addAll(a);//a= (ArrayList<Account>) objectIn.readObject();
				
			}
				catch(EOFException e)
				{
					return;
				}
			 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
