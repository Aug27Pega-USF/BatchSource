package myBankingApp.userInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class IOBankUI {

	// file we are reading and writing to/from
	private static final String SerializedBankUIFile = "SerializedBankUI.txt";
	public static UserInterface serializedBankUI= new UserInterface();	
	
	
	public void writeSerializedBankUIFile() {
		try {
			ObjectOutputStream objectOut = 
					new ObjectOutputStream( new FileOutputStream(SerializedBankUIFile));
			//System.out.println("ATTEMPTING"+serializedBankUI.toString());
			objectOut.writeObject(serializedBankUI);
			objectOut.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readSerializedBankUIFile() {
		try {
			ObjectInputStream objectIn;
			objectIn = new ObjectInputStream(new FileInputStream(SerializedBankUIFile));
			serializedBankUI = (UserInterface) objectIn.readObject();
			objectIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
}
