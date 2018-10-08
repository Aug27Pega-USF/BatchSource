package com.trf.controller;

import javax.servlet.http.HttpServletRequest;
import com.trf.DAOImpl.EmployeeDaoImpl;
import com.trf.DAOImpl.TRFMessageDAOImpl;
public class ApproveController {

	public static String bcapprove(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.BCApprove(Integer.parseInt(trf_id));
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "BA");	
		return "BenCoTRF.html";
	}

	public static String bcdeny(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id));
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "BD");	
		return "BenCoTRF.html";
	}
	
	public static String dsapprove(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.DSApprove(Integer.parseInt(trf_id));
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "SA");	
		return "ApprovalPage.html";
	}

	public static String dsdeny(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id));
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "SD");	
		return "ApprovalPage.html";
	}
	
	public static String dhapprove(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.DHApprove(Integer.parseInt(trf_id));
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "DA");	
		return "ApprovalPage.html";
	}

	public static String dhdeny(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id));
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "DD");
		return "ApprovalPage.html";
	}

	public static String requestinfo(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		String user_level = request.getParameter("user_level");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		int user_send = edi.requestinfo(trf_id, user_level); //THIS RETURNS AN INTEGER OF USER TO MESSAGE.
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(user_send, Integer.parseInt(trf_id), "RI");
		String employee_level = String.valueOf(request.getSession().getAttribute("Level"));
		if (employee_level.equals("B")) {
			return "BenCoTRF.html";
		} else {
			return "ApprovalPage.html";
		}
	}

	public static String submitinfo(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.submitinfo(trf_id);
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(-1, Integer.parseInt(trf_id), "UP");
		return "EmployeeHome.html";
	}

}
