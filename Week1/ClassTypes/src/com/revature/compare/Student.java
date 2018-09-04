package com.revature.compare;
/*
 * Method 1 of comparing
 * Implement Comparable
 * 
 * 
 */
public class Student implements Comparable<Student>{
	//implement compareTo from the Comparable interface
	@Override
	public int compareTo(Student arg0) {
		//compare studentID
		return this.getStudentID() - arg0.getStudentID();		
	}
	
	private int studentID;
	private String major;
	private String name;
	private double gpa;
	private String email;
	private String favoriteFood;
	
	
	public Student(int studentID,  String name,String major, String email, String favoriteFood, double gpa) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.major = major;		
		this.email = email;
		this.favoriteFood = favoriteFood;
		this.gpa = gpa;
	}
	
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", major=" + major + ", name=" + name + ", gpa=" + gpa + ", email="
				+ email + ", favoriteFood=" + favoriteFood + "]";
	}

	public Student(int studentID, String name, double gpa) {
		this(studentID, name, "","","", gpa);
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFavoriteFood() {
		return favoriteFood;
	}
	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	
	
	
}
