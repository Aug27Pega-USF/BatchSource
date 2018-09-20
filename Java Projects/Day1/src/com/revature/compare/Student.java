package com.revature.compare;

// Method 1 of Comparing
/*
 * Implement Comparable
 */
// Inheriting an interface here.
public class Student implements Comparable<Student> {

	// Implement compareTo from the Comparable Interface
	public int compareTo(Student arg0){
		// Compare studentID
		return this.getStudentID() - arg0.getStudentID();
	}
	
	
	private int studentID;
	private String name;
	private String major;
	private String favFood;
	private String email;
	private double gpa;
	
	// Constructor
	public Student(int studentID, String name, String major, String favFood, String email, double gpa) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.major = major;
		this.favFood = favFood;
		this.email = email;
		this.gpa = gpa;
	}
	// Constructor
	public Student(int studentId, String name, double gpa) {
		this(studentId, name, "", "", "", gpa);
	}
	
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", major=" + major + ", favFood=" + favFood
				+ ", email=" + email + ", gpa=" + gpa + "]";
	}
	
	// Getters and Setters
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getFavFood() {
		return favFood;
	}
	public void setFavFood(String favFood) {
		this.favFood = favFood;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	
	
	
}
