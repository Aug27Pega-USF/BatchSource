package com.revature.compare;
/*Method 1 of comparing
 * Implement Comparable
 */

public class Student implements Comparable<Student>{
// implement compareTo from the Comparable interface
	public int compareTo(Student arg0) {
		//Compare studentID
		return this.getStudentID() - arg0.getStudentID();
		}
	
		private int studentID;
		private String name;
		private String major;
		private String favoriteFood;
		private String email;
		private double gpa;
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Student(int studentID, String name, String major, String favoriteFood, String email, double gpa) {
			super();
			this.studentID = studentID;
			this.name = name;
			this.major = major;
			this.favoriteFood = favoriteFood;
			this.email = email;
			this.gpa = gpa;
		}
		public Student(int studentId, String name, double gpa){
			
			this(studentId, name, "", "", "", gpa);
			
		}
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
		public String getFavoriteFood() {
			return favoriteFood;
		}
		public void setFavoriteFood(String favoriteFood) {
			this.favoriteFood = favoriteFood;
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
		@Override
		public String toString() {
			return "Student [studentID=" + studentID + ", name=" + name + ", major=" + major + ", favoriteFood="
					+ favoriteFood + ", email=" + email + ", gpa=" + gpa + "]";
		}
		
		
}
