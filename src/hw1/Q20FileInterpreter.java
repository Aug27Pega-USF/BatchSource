package hw1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q20FileInterpreter {
	public void Q20(){
	String directory= System.getProperty("user.dir");
	File data= new File(directory+"\\src\\hw1\\Data.txt");
	Scanner sc = null;
	try {
		sc = new Scanner(data);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("No data.txt found in same directory.");
	}
	while (sc.hasNextLine()){
		String[] collector= (sc.nextLine()).split(":");
		if (collector.length==4) {
			System.out.printf("Name: %s %s\nAge: %s years\nState: %s State\n\n", collector[0], collector[1], collector[2],collector[3]);
		}
		else System.out.println("This line has incorrect format. First:Last:Age:State");
	}
	
	}
}
