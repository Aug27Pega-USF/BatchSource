package com.revature.please;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileWriteRead {
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner s= new Scanner(System.in);
		String uname="Jimbo";
		//String name=s.nextLine();
	//	String pswrd=s.nextLine();
	//	double balance=s.nextDouble();
		String filepath="Account.txt";
		
		saveAccount(uname,filepath);
		
	}
	
	public static void saveAccount(String uname, String filepath)
	{
		try
		{
			FileWriter fw= new FileWriter(filepath, true);
			BufferedWriter bw= new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(uname);
			pw.flush();
			pw.close();
			
			JOptionPane.showMessageDialog(null,"Record Saved");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Record Failed");
		}
	}

}
