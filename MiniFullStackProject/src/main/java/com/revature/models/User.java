package com.revature.models;

public class User {
	private String username, password, firstname, lastname, street, city, state, country, favcolor, favanimal;
	private int userid, zipcode;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int user_id, String username, String password, String firstname, String lastname, String street, String city,
			String state, String country, int zipcode, String favcolor, String favanimal) {
		super();
		this.userid = user_id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.favcolor = favcolor;
		this.favanimal = favanimal;
		this.zipcode = zipcode;
	}
	
	public User(String username, String password, String firstname, String lastname, String street, String city,
			String state, String country, int zipcode, String favcolor, String favanimal) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.favcolor = favcolor;
		this.favanimal = favanimal;
		this.zipcode = zipcode;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavcolor() {
		return favcolor;
	}

	public void setFavcolor(String favcolor) {
		this.favcolor = favcolor;
	}

	public String getFavanimal() {
		return favanimal;
	}

	public void setFavanimal(String favanimal) {
		this.favanimal = favanimal;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}	
}