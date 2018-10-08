package com.trf.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trf.DAOImpl.EmployeeDaoImpl;
import com.trf.DAOImpl.TRFDaoImpl;
import com.trf.DAOImpl.TRFFullDaoImpl;
import com.trf.DAOImpl.TRFMessageDAOImpl;
import com.trf.DAOImpl.TRFPacketDaoImpl;
import com.trf.beans.TRFPacket;
import com.trf.beans.Employee;
import com.trf.beans.TRF;
import com.trf.beans.TRFFull;

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
		if(grading_format.equals("Letter Grade")) {
			passing_grade=request.getParameter("letter_pass");
		}else if(grading_format.equals("Percentage")){	
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
		Employee emp = (Employee) request.getSession().getAttribute("Employee");
		String id = emp.getUser_type_id();
		if (id.equals("H")) {
			dh_approval="Y";
			ds_approval="Y";
		}else if (id.equals("S")) {
			ds_approval="Y";
		}
		String projected_reimbursement=request.getParameter("projected_reimbursement");	
		String employee_id = String.valueOf(request.getSession().getAttribute("EmployeeID"));
		TRFDaoImpl trfDaoImpl = new TRFDaoImpl();
		TRF trf= new TRF(first_name,last_name,employee_info,datetime,location,description,cost,grading_format,passing_grade,event_type,justification,eventfiles,ds_approval,dh_approval, work_missed,projected_reimbursement,employee_id);
		trfDaoImpl.insertTRF(trf);
		int employeeid=Integer.parseInt(employee_id);
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		emp = employeeDaoImpl.getEmployeebyId(employeeid);
		request.getSession().setAttribute("Employee", emp);
		return "EmployeeHome.html";
	}
	
	public static String viewTRFJSON(HttpServletRequest request, HttpServletResponse response) {
		TRFPacketDaoImpl tpdi = new  TRFPacketDaoImpl();
		System.out.println(request.getSession().getAttribute("EmployeeID"));
		ArrayList<TRFPacket> trf_list=tpdi.getTRFPacketsbyID(Integer.parseInt(String.valueOf(request.getSession().getAttribute("EmployeeID"))));
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(trf_list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String BC_viewTRFJSON(HttpServletRequest request, HttpServletResponse response) {
		TRFFullDaoImpl tfdi = new  TRFFullDaoImpl();
		ArrayList<TRFFull> trf_list=tfdi.getTRFFullbyID_BC(String.valueOf(request.getSession().getAttribute("Level")));
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(trf_list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String DSDH_viewTRFJSON(HttpServletRequest request, HttpServletResponse response) {
		TRFFullDaoImpl tfdi = new  TRFFullDaoImpl();
		ArrayList<TRFFull> trf_list = null;
		if (String.valueOf(request.getSession().getAttribute("Level")).equals("H")) {
			System.out.println("returning head in dsdh_viewtrfjson in trfcontroller");
			trf_list=tfdi.getTRFFullbyID_DH(Integer.parseInt(String.valueOf(request.getSession().getAttribute("EmployeeID"))));
		} else if (String.valueOf(request.getSession().getAttribute("Level")).equals("S")) {
			System.out.println("returning supervisor in dsdh_viewtrfjson in trfcontroller");
			trf_list=tfdi.getTRFFullbyID_DS(Integer.parseInt(String.valueOf(request.getSession().getAttribute("EmployeeID"))));
		}
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(trf_list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String adjust(HttpServletRequest request) {
		String trf_id = request.getParameter("TRF_ID");
		request.getSession().setAttribute("TRF_ID", trf_id);
		return "BenCoApproval.html";
	}

	public static String submitPresentation(HttpServletRequest request) {//change the supervisor_approval_exist on trf from Y to A, send a message to direct supervisor asking for presentation approval.
		String trf_id = request.getParameter("TRF_ID");
		TRFDaoImpl tdi= new TRFDaoImpl();
		tdi.submitPresentation(Integer.parseInt(trf_id));// changes supervisor_approval_exist
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		int supervisor= edi.get_boss(Integer.parseInt(trf_id), 2);
		tmdi.addMessage(supervisor, Integer.parseInt(trf_id), "PR");
		return "EmployeeHome.html";
	}

	public static String submitGrade(HttpServletRequest request) {//change the benco approval from y to a, and send message to benco (-1) with message GC
		String trf_id = request.getParameter("TRF_ID");
		TRFDaoImpl tdi= new TRFDaoImpl();
		tdi.submitGrade(Integer.parseInt(trf_id));// changes benco approval
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(-1, Integer.parseInt(trf_id), "GC");
		return "EmployeeHome.html";
	}
}
