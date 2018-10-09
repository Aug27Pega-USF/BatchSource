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
		String deny_reason=request.getParameter("denyreason");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id));
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "BD", deny_reason);	
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
		String deny_reason=request.getParameter("denyreason");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id));
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "SD", deny_reason);	
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
		String deny_reason=request.getParameter("denyreason");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id));
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "DD",deny_reason);
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

	public static String withdrawapplication(HttpServletRequest request) { //set aa-> aw, denied a->y
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id)); //sets denied a-> y
		edi.withdraw_app(Integer.parseInt(trf_id));
		return "EmployeeHome.html";
	}

	public static String acceptchanges(HttpServletRequest request) { //set aa-> ax, denied a->n
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.accept_changes(Integer.parseInt(trf_id));
		return "EmployeeHome.html";
	}

	public static String approveGrade(HttpServletRequest request) { // call a awardtrf method, changes all approval to 'A'. Also moves pending reimbursement to awarded reimbursement. send a message awarded. change message from GC to something else.
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.TRFAwarded(Integer.parseInt(trf_id)); //this does everything.
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "MA");
		tmdi.approveGrade(Integer.parseInt(trf_id)); //this changes the message flag.
		return "BenCoHome.html";
	}

	public static String denyGrade(HttpServletRequest request) { //we just deny it, send a message that benco denied, change message from GC to something else.
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id));//this denies the application
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "BG"); //this sends the message.
		tmdi.denyGrade(Integer.parseInt(trf_id)); //this changes the message flag
		return "BenCoHome.html";
	}

	public static String approvePresentation(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.TRFAwarded(Integer.parseInt(trf_id)); //this does everything.
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "MA");
		tmdi.approvePresentation(Integer.parseInt(trf_id)); //this changes the message flag.
		return "EmployeeHome.html";
	}

	public static String denyPresentation(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id));//this denies the application
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		tmdi.addMessage(0, Integer.parseInt(trf_id), "PY"); //this sends the message.
		tmdi.denyPresentation(Integer.parseInt(trf_id)); //this changes the message flag
		return "EmployeeHome.html";
	}

}
