package com.trf.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

}
