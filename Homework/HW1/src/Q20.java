import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Q20 {
	InputStream is = null;
	File file = new File(inFile);
	StringBuilder s = new StringBuilder();
	StringBuilder B = new StringBuilder();
	
	String firstName = "";
	String lastName = "";
	String age = "";
	String state = "";
	
	try {
		is = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	int c = 0;
	int colonCount = 0;
	
	try {
		while((c=is.read())!=-1) {
			
			if((char)c == '\n') {
				state = B.substring(0, B.length()-1);
				System.out.println("Name: " + firstName + " " + lastName);
				System.out.println("Age: " + age + " years");
				System.out.println("State: " + state + " State");
				B.delete(0,B.length());
				System.out.println();
			}
			else
			if((char)c == ':')
			{
				if(colonCount == 0) {
					firstName = B.toString();
					colonCount++;
				}
				else
				if(colonCount == 1) {
					lastName = B.toString();
					colonCount++;
				}
				else
				if(colonCount == 2) {
					age = B.toString();
					colonCount = 0;
				}
				B.delete(0,B.length());
			}
			else
			if((char)c != ' ' && (char)c != '\n') {
				B.append((char)c);
			}

			// Add the char to the string that holds ALL text file contents 'as is' 
			char c = (char) c;	// this casts the byte number to a char
			s.append(c);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	if(is!=null) {
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	System.out.println();
	System.out.println("The original contents of the text file are: " + s);
	System.out.println();
}

}
