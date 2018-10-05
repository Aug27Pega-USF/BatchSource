package com.trf.beans;

public class TRFPacket {
	int TRF_id;
	String datetime;
	String location;
	String description;
	String grading_format;
	String passing_grade;
	String event_type_id;
	String justification;
    String supervisor_approval_exist;
    String head_approval_exist;
    String benco_approval_exist;
    String work_time_missed;
    String projected_reimbursement;
	@Override
	public String toString() {
		return "TRFPacket [TRF_id=" + TRF_id + ", datetime=" + datetime + ", location=" + location + ", description="
				+ description + ", grading_format=" + grading_format + ", passing_grade=" + passing_grade
				+ ", event_type_id=" + event_type_id + ", justification=" + justification
				+ ", supervisor_approval_exist=" + supervisor_approval_exist + ", head_approval_exist="
				+ head_approval_exist + ", benco_approval_exist=" + benco_approval_exist + ", work_time_missed="
				+ work_time_missed + ", projected_reimbursement=" + projected_reimbursement + "]";
	}
	public int getTRF_id() {
		return TRF_id;
	}
	public void setTRF_id(int tRF_id) {
		TRF_id = tRF_id;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
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
	public String getGrading_format() {
		return grading_format;
	}
	public void setGrading_format(String grading_format) {
		this.grading_format = grading_format;
	}
	public String getPassing_grade() {
		return passing_grade;
	}
	public void setPassing_grade(String passing_grade) {
		this.passing_grade = passing_grade;
	}
	public String getEvent_type_id() {
		return event_type_id;
	}
	public void setEvent_type_id(String event_type_id) {
		this.event_type_id = event_type_id;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getSupervisor_approval_exist() {
		return supervisor_approval_exist;
	}
	public void setSupervisor_approval_exist(String supervisor_approval_exist) {
		this.supervisor_approval_exist = supervisor_approval_exist;
	}
	public String getHead_approval_exist() {
		return head_approval_exist;
	}
	public void setHead_approval_exist(String head_approval_exist) {
		this.head_approval_exist = head_approval_exist;
	}
	public String getBenco_approval_exist() {
		return benco_approval_exist;
	}
	public void setBenco_approval_exist(String benco_approval_exist) {
		this.benco_approval_exist = benco_approval_exist;
	}
	public String getWork_time_missed() {
		return work_time_missed;
	}
	public void setWork_time_missed(String work_time_missed) {
		this.work_time_missed = work_time_missed;
	}
	public String getProjected_reimbursement() {
		return projected_reimbursement;
	}
	public void setProjected_reimbursement(String projected_reimbursement) {
		this.projected_reimbursement = projected_reimbursement;
	}
	public TRFPacket(int tRF_id, String datetime, String location, String description, String grading_format,
			String passing_grade, String event_type_id, String justification, String supervisor_approval_exist,
			String head_approval_exist, String benco_approval_exist, String work_time_missed,
			String projected_reimbursement) {
		super();
		TRF_id = tRF_id;
		this.datetime = datetime;
		this.location = location;
		this.description = description;
		this.grading_format = grading_format;
		this.passing_grade = passing_grade;
		this.event_type_id = event_type_id;
		this.justification = justification;
		this.supervisor_approval_exist = supervisor_approval_exist;
		this.head_approval_exist = head_approval_exist;
		this.benco_approval_exist = benco_approval_exist;
		this.work_time_missed = work_time_missed;
		this.projected_reimbursement = projected_reimbursement;
	}
    
}
