package com.greenbull.users;

/*
 * Base class for storing data for the current user 
 * Can be an employee, Direct supervisor, dept manager, or a BenCo Man
 */
public class User {
	
	/*
	 * Fields
	 */


	/*from our Database:
	USER_ID INTEGER PRIMARY KEY NOT NULL,
    USER_NAME VARCHAR(20) UNIQUE NOT NULL,
    PASS_WORD VARCHAR(20) NOT NULL,
    TYPE_OF_ID INTEGER DEFAULT 0,
    REPORTS_TO INTEGER DEFAULT 0,
    FIRST_NAME VARCHAR(24) NOT NULL,
    LAST_NAME VARCHAR(24) NOT NULL,
    
    --could this be separated into a table for employees?
    PENDING_REIMBURSEMENTS INTEGER DEFAULT 0,
    AWARDED_REIMBURSEMENTS INTEGER DEFAULT 0
	 */
	String username;
	String password;
	int id;
	int type_of_id;
	
	String firstName;
	String lastName;
	
	int current_form_id;

	/*
	 * Constructor
	 */
	public User() {
		super();
	}


	/*
	 * Getters/Setters
	 */
	
	public User(String username, String password, int id, int type_of_id, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.type_of_id = type_of_id;
		this.firstName = firstName;
		this.lastName = lastName;
		current_form_id = 0; //new field I added to track which form to pull up between menus
	}


	public int getType_of_id() {
		return type_of_id;
	}
	public void setType_of_id(int type_of_id) {
		this.type_of_id = type_of_id;
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


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCurrent_form_id() {
		return current_form_id;
	}
	public void setCurrent_form_id(int current_form_id) {
		this.current_form_id = current_form_id;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + ", type_of_id=" + type_of_id
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
