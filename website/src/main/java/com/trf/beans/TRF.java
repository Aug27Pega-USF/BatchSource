package com.trf.beans;

import java.sql.Timestamp;

public class TRF {
	int TRF_id;
	String first_name;
	String last_name;
	String basic_info_placeholder;
	Timestamp datetime;
	String location;
	String description;
	double cost;
	String grading_format;
	String passing_grade;
	int event_type_id;
	String justification;
	char optional_attachments_exist; 
    char supervisor_approval_exist;
    char head_approval_exist;
    int work_time_missed;
    double projected_reimbursement;
	public int getTRF_id() {
		return TRF_id;
	}
	public void setTRF_id(int tRF_id) {
		TRF_id = tRF_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getBasic_info_placeholder() {
		return basic_info_placeholder;
	}
	public void setBasic_info_placeholder(String basic_info_placeholder) {
		this.basic_info_placeholder = basic_info_placeholder;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getGrading_format() {
		return grading_format;
	}
	public void setGrading_format(String grading_format) {
		this.grading_format = grading_format;
	}
	public int getEvent_type_id() {
		return event_type_id;
	}
	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}
	public String getPassing_grade() {
		return passing_grade;
	}
	public void setPassing_grade(String passing_grade) {
		this.passing_grade = passing_grade;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public char getOptional_attachments_exist() {
		return optional_attachments_exist;
	}
	public void setOptional_attachments_exist(char optional_attachments_exist) {
		this.optional_attachments_exist = optional_attachments_exist;
	}
	public char getSupervisor_approval_exist() {
		return supervisor_approval_exist;
	}
	public void setSupervisor_approval_exist(char supervisor_approval_exist) {
		this.supervisor_approval_exist = supervisor_approval_exist;
	}
	public char getHead_approval_exist() {
		return head_approval_exist;
	}
	public void setHead_approval_exist(char head_approval_exist) {
		this.head_approval_exist = head_approval_exist;
	}
	public int getWork_time_missed() {
		return work_time_missed;
	}
	public void setWork_time_missed(int work_time_missed) {
		this.work_time_missed = work_time_missed;
	}
	public double getProjected_reimbursement() {
		return projected_reimbursement;
	}
	public void setProjected_reimbursement(double projected_reimbursement) {
		this.projected_reimbursement = projected_reimbursement;
	}
	
	public TRF(int tRF_id, String first_name, String last_name, String basic_info_placeholder, Timestamp datetime,
			String location, String description, double cost, String grading_format, String passing_grade,
			int event_type_id, String justification, char optional_attachments_exist, char supervisor_approval_exist,
			char head_approval_exist, int work_time_missed, double projected_reimbursement) {
		super();
		TRF_id = tRF_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.basic_info_placeholder = basic_info_placeholder;
		this.datetime = datetime;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.grading_format = grading_format;
		this.passing_grade = passing_grade;
		this.event_type_id = event_type_id;
		this.justification = justification;
		this.optional_attachments_exist = optional_attachments_exist;
		this.supervisor_approval_exist = supervisor_approval_exist;
		this.head_approval_exist = head_approval_exist;
		this.work_time_missed = work_time_missed;
		this.projected_reimbursement = projected_reimbursement;
	}
	@Override
	public String toString() {
		return "TRF [TRF_id=" + TRF_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", basic_info_placeholder=" + basic_info_placeholder + ", datetime=" + datetime + ", location="
				+ location + ", description=" + description + ", cost=" + cost + ", grading_format=" + grading_format
				+ ", event_type_id=" + event_type_id + ", passing_grade=" + passing_grade + ", justification="
				+ justification + ", optional_attachments_exist=" + optional_attachments_exist
				+ ", supervisor_approval_exist=" + supervisor_approval_exist + ", head_approval_exist="
				+ head_approval_exist + ", work_time_missed=" + work_time_missed + ", projected_reimbursement="
				+ projected_reimbursement + "]";
	}
    
    
}
