package JDBCBank.Banking.accounts;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import JDBCBank.Banking.impl.UserImpl;

public class Users extends Serial{
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger(Users.class.getName());
	
	
	//fields
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String date;
	
	//lite Constructor
	public Users() {
		super();
	}

	//Main Constructor
	public Users(int id, String username, String password, String firstname, String lastname, String date) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.date = date;
		log.info( "test" );
		
	}
	
	public Users(int id, String username, String password, String firstname, String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.date = "";
	}
	
	//Getters/Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", date=" + date + "]";
	}

	public static int AddNewUsers(Scanner scan, String user_entered, String password_entered, String first_name, String last_name, UserImpl u, ArrayList<Users> usersList) {
		
		int current_user_id = 0;

		try {
			System.out.println("*Loading...*");
			u.create(user_entered, password_entered, first_name, last_name);
			usersList.add(u.readOne(user_entered));
			current_user_id = usersList.get(usersList.size()-1).getId();
			log.info( "User Created - Username: " + user_entered + ", Password: " + password_entered + ", First Name: " + first_name + ", Last Name: " + last_name );
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("The username \"" + user_entered + "\" has been created! Welcome!");
		return current_user_id;
	}
	
	public static void updateUser(int acc_dbid, int acc_index, UserImpl u, ArrayList<Users> usersList, String first_name, String last_name) {

		try{
			//get username
			String user_name = usersList.get(acc_index).getUsername();
			
			//update array list
			usersList.get(acc_index).setFirstname(first_name);
			usersList.get(acc_index).setLastname(last_name);
			
			System.out.println("*Loading...*");
			//remove from DB
			u.update(acc_dbid, first_name, last_name);		
			
			log.info( "User Updated - Name: " + user_name);
			System.out.println("First name is now \"" + first_name + "\".");
			System.out.println("Last  name is now \"" + last_name + "\".");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	
	public static void deleteUser(int acc_dbid, int acc_index, UserImpl u, ArrayList<Users> usersList, ArrayList<Account> accountsList) {

		try{
			String user_name = usersList.get(acc_index).getUsername();
			//remove from array
			usersList.remove(acc_index);
			
			//remove associated accounts from their array
			for(int i = 0; i < accountsList.size(); i++) {
				if(accountsList.get(i).getUser_id() == acc_index) {
					accountsList.remove(i);
					i--;//decrement by one so we don't skip over anything
				}
			}
			
			System.out.println("*Loading...*");
			//remove from DB
			u.delete(acc_dbid);		
			
			log.info( "User Deleted - Name: " + user_name);
			System.out.println("Deleted user \"" + user_name + "\".");
			System.out.println("All associated accounts removed.");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
}
