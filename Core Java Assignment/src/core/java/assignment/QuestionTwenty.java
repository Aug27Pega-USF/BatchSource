package core.java.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class QuestionTwenty {
	private static final String inFile = "Data.txt";
	
	ArrayList<PersonData> personList = new ArrayList<PersonData>();
	
	class PersonData{
		private String name;
		private String state;
		private int age;
		
		public PersonData(String ...str) {
			int counter = 0;
			for(String s : str) {
				switch(counter) {
				case 0:
					this.name = s;
					break;
				case 1:
					this.name += " " + s;
					break;
				case 2:
					this.age = Integer.parseInt(s);
					break;
				case 3:
					this.state = s;
					break;
				default:
					break;
				}
				counter++;
			}
		}
	}
	
	public void readFileLines(String regex) throws Exception{
		File file = new File(inFile);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str;
		
		while((str = reader.readLine()) != null) {
			personList.add(new PersonData(str.split(regex)));
		}
		reader.close();
	}
	
	public void printData() {
		for(PersonData person : personList) {
			System.out.println("\nName: " + person.name);
			System.out.println("Age: " + person.age + " years");
			System.out.println("State: " + person.state);
		}
	}
}
