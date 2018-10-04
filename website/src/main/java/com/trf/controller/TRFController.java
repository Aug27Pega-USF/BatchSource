package com.trf.controller;

import javax.servlet.http.HttpServletRequest;

import com.trf.DAOImpl.TRFDaoImpl;
import com.trf.beans.TRF;

public class TRFController {
	public static String submitTRF(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "Login.html";
		}
		String first_name= request.getParameter("first_name");
		String last_name= request.getParameter("last_name");
		String employee_info= request.getParameter("employee_info");
		String dateStr= request.getParameter("date");
		String timeStr= request.getParameter("time");
		String datetime=dateStr+" "+timeStr;
		String location=request.getParameter("location");
		String description=request.getParameter("description");
		String cost=request.getParameter("cost");
		String grading_format=request.getParameter("grading_format");
		
		String passing_grade="";
		if(grading_format=="Letter Grade") {
			passing_grade=request.getParameter("letter_pass");
		}else if(grading_format=="Percentage"){
			passing_grade=request.getParameter("percentage_pass");
		}
		String event_type=request.getParameter("event_type");
		switch(event_type) {
			case "university_courses":
				event_type="1";
				break;
			case "seminars":
				event_type="2";
				break;
			case "cp_classes":
				event_type="3";
				break;
			case "certification":
				event_type="4";
				break;
			case "technical_training":
				event_type="5";
				break;
			case "other":
				event_type="6";
				break;
			default:
				return "EmployeeHome.html";
		}
		String justification=request.getParameter("justification");
		String work_missed=request.getParameter("work_missed");
		
		if (work_missed=="") {
			work_missed="0";
		}
		String eventfiles=request.getParameter("eventfile");
		if (eventfiles!="") {
			eventfiles="Y";
		}else {
			eventfiles="N";
		}
		String ds_approval=request.getParameter("dsapprovalfile");
		if (ds_approval!="") {
			ds_approval="Y";
		}else {
			ds_approval="N";
		}
		
		String dh_approval=request.getParameter("dhapprovalfile");
		if (dh_approval!="") {
			dh_approval="Y";
		}else {
			dh_approval="N";
		}
		
		String projected_reimbursement=request.getParameter("projected_reimbursement");	
		
		TRFDaoImpl trfDaoImpl = new TRFDaoImpl();
		TRF trf= new TRF(1,first_name,last_name,employee_info,datetime,location,description,cost,grading_format,passing_grade,event_type,justification,eventfiles,ds_approval,dh_approval, work_missed,projected_reimbursement);
		trfDaoImpl.insertTRF(trf);
		return "EmployeeHome.html";
	}
}
