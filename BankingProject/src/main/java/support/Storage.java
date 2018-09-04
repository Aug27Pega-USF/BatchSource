package support;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Storage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	String path = "C://Users//HHGregg//Desktop//jsullivan93//BatchSource//BankingProject//banking_storage.text";
//	File file = new File(path);
	public void writeToFile(ArrayList<User> list, File file) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		//PrintWriter ps = null;
		try {
			fout = new FileOutputStream(file);
			oos = new ObjectOutputStream(fout);
			for(User u: list) {
				oos.writeObject(u);
			}
			//ps.
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<User> readFromFile(File file) {
		ArrayList<User> ulist = new ArrayList<User>();
		User u = null;
		//FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			while(true) {
				u =(User)ois.readObject();
				ulist.add(u);
			}
			//System.out.println(u.toString());
		} catch(EOFException e) {
			e.printStackTrace();
			return ulist;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ulist;

	}
}
