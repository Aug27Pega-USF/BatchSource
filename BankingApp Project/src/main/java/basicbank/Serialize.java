//package basicbank;
//
////public final class Serialize implements Serializable {
////	private static final long serialVersionUID = 1L;
////}
//
//import java.io.EOFException;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//import com.revature.beans.BankUser;
//
//public final class Serialize implements Serializable {
//	private static final long serialVersionUID = 1L;
//	
//	//write many BankUser objects to file
//	public void writeToFile(List<BankUser> list, File file) {
//		ObjectOutputStream outStream = null;
//		try {
//			outStream = new ObjectOutputStream(new FileOutputStream(file));
//			for (BankUser u : list){
//				outStream.writeObject(u);
//			}
//		} catch (IOException e) {
//			System.out.println("Error Opening File.");
//		} catch(NoSuchElementException e) {
//			System.out.println("Invalid input.");
//		} finally {
//			try {
//				if(outStream != null) {
//					outStream.close();	
//				}
//			} catch (IOException e) {
//				System.out.println("Error Closing File");
//			}
//		}
//	}
//
//  //read BankUsers from File
//  public List<BankUser> readFromFile(File file){
//    List<BankUser> list = new ArrayList<BankUser>();
//    ObjectInputStream inputStream = null;
//    try {
//      inputStream = new ObjectInputStream(new FileInputStream(file));
//      while(true) {
//        BankUser u = (BankUser)inputStream.readObject();
//        list.add(u);
//      }
//    } catch(EOFException e) {
//      return list;
//    } catch (ClassNotFoundException e) {
//      System.out.println("Object creation failed.");
//    } catch(IOException e) {
//      System.out.println("Error opening file.");
//      e.printStackTrace();
//    } finally {
//      try {
//        if(inputStream != null)
//        inputStream.close();
//      } catch(IOException e) {
//        System.out.println("Error closing file.");
//      }
//    }
//    return list;
//  }
//}