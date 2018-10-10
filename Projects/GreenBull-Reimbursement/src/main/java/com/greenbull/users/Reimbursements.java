package com.greenbull.users;

public class Reimbursements {

	/*
	 * Fields
	 */
	
	/*
	CREATE TABLE REIMBURSEMENTS (
	    REIMBURSEMENT_ID INTEGER PRIMARY KEY,
	    STATUS INTEGER DEFAULT 0,
	    USER_ID INTEGER NOT NULL,
	    COURSE_ID INTEGER NOT NULL,
	    COURSE_LOCATION VARCHAR2(40) NOT NULL,
	    WORK_DESCRIPTION VARCHAR2(320) NOT NULL,
	    APPROVAL_TYPE INTEGER,
	    AMOUNT INTEGER DEFAULT 0,
	    EVENT_TYPE_ID INTEGER DEFAULT 0,
	    APPROVED_SUPERVISOR INTEGER DEFAULT 0,
	    APPROVED_DEPTHEAD INTEGER DEFAULT 0,
	    APPROVED_BENCO INTEGER DEFAULT 0,
	    APPROVED_BENCOSUPERVISOR INTEGER DEFAULT 0,
	    DATE_MADE DATE 
	 */
	
	int id;
	int status;
	int user_id;
	
	int amount;
	int event_type_id;
	
	int app_supervisor;
	int app_depthead;
	int app_benco;
	int app_bencosupervisor;
	
	String fname;
	String lname;
	
	int date_month;
	int date_day;
	int date_year;
	
	String application_method;
	String address;
	String city;
	String state;
	String zipcode;
	
	int cost;
	String worktime_missed;
	String course_name;
	int grade;
	String approval_type;
	String course_location;
	String work_description;
	
	/*
	 * Constructors
	 */
	
	public Reimbursements() {
		super();
	}
	
	public Reimbursements(int id, int status, int user_id) {
		super();
		this.id = id;
		this.status = status;
		this.user_id = user_id;
	}
	
	public Reimbursements(int id, int status, int user_id, int amount, int event_type_id, int app_supervisor,
			int app_depthead, int app_benco, int app_bencosupervisor, String fname, String lname, int date_month,
			int date_day, int date_year, String application_method, String address, String city, String state,
			String zipcode, int cost, String worktime_missed, String course_name, int grade, String approval_type,
			String course_location, String work_description) {
		super();
		this.id = id;
		this.status = status;
		this.user_id = user_id;
		this.amount = amount;
		this.event_type_id = event_type_id;
		this.app_supervisor = app_supervisor;
		this.app_depthead = app_depthead;
		this.app_benco = app_benco;
		this.app_bencosupervisor = app_bencosupervisor;
		this.fname = fname;
		this.lname = lname;
		this.date_month = date_month;
		this.date_day = date_day;
		this.date_year = date_year;
		this.application_method = application_method;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.cost = cost;
		this.worktime_missed = worktime_missed;
		this.course_name = course_name;
		this.grade = grade;
		this.approval_type = approval_type;
		this.course_location = course_location;
		this.work_description = work_description;
	}

	/*
	 * Fields
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getEvent_type_id() {
		return event_type_id;
	}

	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}

	public int getApp_supervisor() {
		return app_supervisor;
	}

	public void setApp_supervisor(int app_supervisor) {
		this.app_supervisor = app_supervisor;
	}

	public int getApp_depthead() {
		return app_depthead;
	}

	public void setApp_depthead(int app_depthead) {
		this.app_depthead = app_depthead;
	}

	public int getApp_benco() {
		return app_benco;
	}

	public void setApp_benco(int app_benco) {
		this.app_benco = app_benco;
	}

	public int getApp_bencosupervisor() {
		return app_bencosupervisor;
	}

	public void setApp_bencosupervisor(int app_bencosupervisor) {
		this.app_bencosupervisor = app_bencosupervisor;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getDate_month() {
		return date_month;
	}

	public void setDate_month(int date_month) {
		this.date_month = date_month;
	}

	public int getDate_day() {
		return date_day;
	}

	public void setDate_day(int date_day) {
		this.date_day = date_day;
	}

	public int getDate_year() {
		return date_year;
	}

	public void setDate_year(int date_year) {
		this.date_year = date_year;
	}

	public String getApplication_method() {
		return application_method;
	}

	public void setApplication_method(String application_method) {
		this.application_method = application_method;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getWorktime_missed() {
		return worktime_missed;
	}

	public void setWorktime_missed(String worktime_missed) {
		this.worktime_missed = worktime_missed;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getApproval_type() {
		return approval_type;
	}

	public void setApproval_type(String approval_type) {
		this.approval_type = approval_type;
	}

	public String getCourse_location() {
		return course_location;
	}

	public void setCourse_location(String course_location) {
		this.course_location = course_location;
	}

	public String getWork_description() {
		return work_description;
	}

	public void setWork_description(String work_description) {
		this.work_description = work_description;
	}

	@Override
	public String toString() {
		return "Reimbursements [id=" + id + ", status=" + status + ", user_id=" + user_id + ", amount=" + amount
				+ ", event_type_id=" + event_type_id + ", app_supervisor=" + app_supervisor + ", app_depthead="
				+ app_depthead + ", app_benco=" + app_benco + ", app_bencosupervisor=" + app_bencosupervisor
				+ ", fname=" + fname + ", lname=" + lname + ", date_month=" + date_month + ", date_day=" + date_day
				+ ", date_year=" + date_year + ", application_method=" + application_method + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", cost=" + cost
				+ ", worktime_missed=" + worktime_missed + ", course_name=" + course_name + ", grade=" + grade
				+ ", approval_type=" + approval_type + ", course_location=" + course_location + ", work_description="
				+ work_description + "]";
	}	
}
