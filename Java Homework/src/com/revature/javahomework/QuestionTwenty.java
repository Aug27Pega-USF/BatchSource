package com.revature.javahomework;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionTwenty {
	private static final String inFile = "Data.txt";
	
	List<PersonData> personList = new ArrayList<PersonData>();
	
	public class PersonData{
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

		@Override
		public String toString() {
			return "Name: " + name + "\n" + "Age: " + age + " years\n" + "State: " + state + "\n";
		}
		
	}
	
	public List<PersonData> readFileLines(String regex) throws Exception{
		File file = new File(inFile);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str;
		
		while((str = reader.readLine()) != null) {
			personList.add(new PersonData(str.split(regex)));
		}
		reader.close();
		
		return personList;
	}
}