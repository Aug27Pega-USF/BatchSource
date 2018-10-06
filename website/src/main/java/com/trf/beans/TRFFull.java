package com.trf.beans;

public class TRFFull {
	String TRF_ID, first_Name, last_name, basic_info_placeholder, event_datetime, event_location
	,event_description, event_cost, grading_format, passing_grade, event_type_id, justification, attachments_exist,
	ds_approval, dh_approval, bc_approval, denied, exceed_reason, work_missed, projected_reimbursement, user_id;

	public TRFFull(String tRF_ID, String first_Name, String last_name, String basic_info_placeholder,
			String event_datetime, String event_location, String event_description, String event_cost,
			String grading_format, String passing_grade, String event_type_id, String justification,
			String attachments_exist, String ds_approval, String dh_approval, String bc_approval, String denied,
			String exceed_reason, String work_missed, String projected_reimbursement, String user_id) {
		super();
		TRF_ID = tRF_ID;
		this.first_Name = first_Name;
		this.last_name = last_name;
		this.basic_info_placeholder = basic_info_placeholder;
		this.event_datetime = event_datetime;
		this.event_location = event_location;
		this.event_description = event_description;
		this.event_cost = event_cost;
		this.grading_format = grading_format;
		this.passing_grade = passing_grade;
		this.event_type_id = event_type_id;
		this.justification = justification;
		this.attachments_exist = attachments_exist;
		this.ds_approval = ds_approval;
		this.dh_approval = dh_approval;
		this.bc_approval = bc_approval;
		this.denied = denied;
		this.exceed_reason = exceed_reason;
		this.work_missed = work_missed;
		this.projected_reimbursement = projected_reimbursement;
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "TRFFull [TRF_ID=" + TRF_ID + ", first_Name=" + first_Name + ", last_name=" + last_name
				+ ", basic_info_placeholder=" + basic_info_placeholder + ", event_datetime=" + event_datetime
				+ ", event_location=" + event_location + ", event_description=" + event_description + ", event_cost="
				+ event_cost + ", grading_format=" + grading_format + ", passing_grade=" + passing_grade
				+ ", event_type_id=" + event_type_id + ", justification=" + justification + ", attachments_exist="
				+ attachments_exist + ", ds_approval=" + ds_approval + ", dh_approval=" + dh_approval + ", bc_approval="
				+ bc_approval + ", denied=" + denied + ", exceed_reason=" + exceed_reason + ", work_missed="
				+ work_missed + ", projected_reimbursement=" + projected_reimbursement + ", user_id=" + user_id + "]";
	}

	public String getTRF_ID() {
		return TRF_ID;
	}

	public void setTRF_ID(String tRF_ID) {
		TRF_ID = tRF_ID;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
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

	public String getEvent_datetime() {
		return event_datetime;
	}

	public void setEvent_datetime(String event_datetime) {
		this.event_datetime = event_datetime;
	}

	public String getEvent_location() {
		return event_location;
	}

	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}

	public String getEvent_description() {
		return event_description;
	}

	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}

	public String getEvent_cost() {
		return event_cost;
	}

	public void setEvent_cost(String event_cost) {
		this.event_cost = event_cost;
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

	public String getAttachments_exist() {
		return attachments_exist;
	}

	public void setAttachments_exist(String attachments_exist) {
		this.attachments_exist = attachments_exist;
	}

	public String getDs_approval() {
		return ds_approval;
	}

	public void setDs_approval(String ds_approval) {
		this.ds_approval = ds_approval;
	}

	public String getDh_approval() {
		return dh_approval;
	}

	public void setDh_approval(String dh_approval) {
		this.dh_approval = dh_approval;
	}

	public String getBc_approval() {
		return bc_approval;
	}

	public void setBc_approval(String bc_approval) {
		this.bc_approval = bc_approval;
	}

	public String getDenied() {
		return denied;
	}

	public void setDenied(String denied) {
		this.denied = denied;
	}

	public String getExceed_reason() {
		return exceed_reason;
	}

	public void setExceed_reason(String exceed_reason) {
		this.exceed_reason = exceed_reason;
	}

	public String getWork_missed() {
		return work_missed;
	}

	public void setWork_missed(String work_missed) {
		this.work_missed = work_missed;
	}

	public String getProjected_reimbursement() {
		return projected_reimbursement;
	}

	public void setProjected_reimbursement(String projected_reimbursement) {
		this.projected_reimbursement = projected_reimbursement;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	

}
