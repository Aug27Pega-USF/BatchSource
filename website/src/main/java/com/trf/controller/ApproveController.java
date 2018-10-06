package com.trf.controller;

import javax.servlet.http.HttpServletRequest;
import com.trf.DAOImpl.EmployeeDaoImpl;
public class ApproveController {

	public static String bcapprovedeny(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.BCApprove(Integer.parseInt(trf_id));
		return "BenCoTRF.html";
	}

	public static String bcdeny(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id));
		return "BenCoTRF.html";
	}
	
	public static String dsapprovedeny(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.DSApprove(Integer.parseInt(trf_id));
		return "ApprovalPage.html";
	}

	public static String dsdeny(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id));
		return "ApprovalPage.html";
	}
	
	public static String dhapprovedeny(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.DHApprove(Integer.parseInt(trf_id));
		return "ApprovalPage.html";
	}

	public static String dhdeny(HttpServletRequest request) {
		String trf_id= request.getParameter("TRF_ID");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.denied(Integer.parseInt(trf_id));
		return "ApprovalPage.html";
	}

}
