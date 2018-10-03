package com.trf.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import com.trf.DAOImpl.EmployeeDaoImpl;
import com.trf.DAOImpl.TRFDaoImpl;
import com.trf.beans.Employee;
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
		Timestamp ts=Timestamp.valueOf(dateStr+" "+timeStr+":00");
		String location=request.getParameter("location");
		String description=request.getParameter("description");
		double cost=Double.parseDouble(request.getParameter("cost"));
		String grading_format=request.getParameter("grading_format");
		
		String passing_grade="";
		if(grading_format=="Letter Grade") {
			passing_grade=request.getParameter("letter_pass");
		}else if(grading_format=="Percentage"){
			passing_grade=request.getParameter("percentage_pass");
		}
		String event_type=request.getParameter("event_type");
		int event_type_id=0;
		switch(event_type) {
			case "university_courses":
				event_type_id=1;
				break;
			case "seminars":
				event_type_id=2;
				break;
			case "cp_classes":
				event_type_id=3;
				break;
			case "certification":
				event_type_id=4;
				break;
			case "technical_training":
				event_type_id=5;
				break;
			case "other":
				event_type_id=6;
				break;
			default:
				return "EmployeeHome.html";
		}
		String justification=request.getParameter("justification");
		String work_missed=request.getParameter("work_missed");
		int work_missed_num=0;
		if (work_missed!="") {
			work_missed_num=Integer.parseInt(work_missed);
		}
		double projected_reimbursement=Double.parseDouble(request.getParameter("projected_reimbursement"));
		TRFDaoImpl trfDaoImpl = new TRFDaoImpl();
		TRF trf= new TRF(1,first_name,last_name,employee_info,ts,location,description,cost,grading_format,passing_grade,event_type_id,justification,'N','N','N', work_missed_num,projected_reimbursement);
		
		
		
		return "EmployeeHome.html";
	}
}
