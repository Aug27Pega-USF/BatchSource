package question.twenty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//question 20
//class for opening the iostream and getting external file data
public class IO {
	//reference to the file we're getting
	private static final String inString = "Data.txt";
	
	//function to get the data from the file
	public String readFile(){
		//reference to our stream for getting data 
		InputStream is = null;
		//reference object for the file
		File file = new File(inString);
		//reference object for manipulating the string data itself
		StringBuilder s = new StringBuilder();
		
		//generating a try-catch in case the file's not found
		try {
			//pass in a stream to our file
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//temp variable to make sure file's been read
		int b = 0;
		
		try {
			//goes through the file until it reaches the end
			while ( (b=is.read()) != -1) {
				char c = (char) b;
				//adds each character to the string
				s.append(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//if our stream is still open, close it
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//give us the string
		return s.toString();
	}
}
