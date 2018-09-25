package support;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TheBank {

	static Storage s = new Storage();
	static LoginLogic l = new LoginLogic();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "banking_storage.txt";
		File file = new File(path);
		User jon = new User("Jon", "Sully", "js93", "password1", "Customer", "2020009", 75000.57, 2000.00);
		User deb = new User("Debbie", "Downer", "ddsad", "felineaids", "Customer", "20012008", 80000.57,
				3000.00);
		User lois = l.register();
		ArrayList<User> list = new ArrayList<User>();
		list.add(jon);
		list.add(deb);
		list.add(lois);
		//File file = new File("C://Users//HHGregg//Desktop//jsullivan93//BatchSource//BankingProject//bank_storage.txt");
			//File file = new File("C://Users//HHGregg//Desktop//jsullivan93//BatchSource//BankingProject//src//main//resourses//bank_storage.txt");
		
		s.writeToFile(list, file);
		ArrayList<User> check = s.readFromFile(file);
		System.out.println(check.size());
		for(User u: check) {
			System.out.println(u.toString());
		}
	}
}
