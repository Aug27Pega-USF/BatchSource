package com.trf.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trf.DAOImpl.EmployeeDaoImpl;
import com.trf.DAOImpl.ReimbursementDaoImpl;
import com.trf.DAOImpl.TRFDaoImpl;
import com.trf.DAOImpl.TRFMessageDAOImpl;
import com.trf.beans.Reimbursement;

public class ReimbursementController {

	public static String viewREJSON(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl(); 
		int trf_id = Integer.parseInt(String.valueOf(request.getSession().getAttribute("TRF_ID")));
		String a_rei= rdi.getAvailableReimbursement(trf_id);
		String t_rei= rdi.getTRFReimbursementbyID(trf_id);
		String TRF_ID = String.valueOf(trf_id);
		Reimbursement r = new Reimbursement(TRF_ID, a_rei, t_rei);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(r));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String updateReimbursement(HttpServletRequest request) { //takes in values.
		float previous_reimbursement= Float.parseFloat((String.valueOf(request.getParameter("current_re"))));
		float new_reimbursement= Float.parseFloat((String.valueOf(request.getParameter("reimbursement"))));
		float previous_available= Float.parseFloat((String.valueOf(request.getParameter("avail_re"))));
		int trf_id= Integer.parseInt((String.valueOf(request.getParameter("TRF_ID"))));
		String exceedreason= String.valueOf(request.getParameter("exceedreason"));
		TRFDaoImpl tdi = new TRFDaoImpl();
		TRFMessageDAOImpl tmdi = new TRFMessageDAOImpl();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		if (new_reimbursement==previous_reimbursement) {
			return "BenCoTRF.html";
		}
		tdi.updateTRFRei(new_reimbursement, trf_id); //update trf reimbursement
		if (new_reimbursement<previous_reimbursement) {
			tmdi.addMessage(0, trf_id, "AA");
			edi.updateInfo(trf_id); //set trf denied->'A'
		}
		if ((new_reimbursement-previous_reimbursement)> previous_available) {
				tdi.updateTRFExceed(exceedreason, trf_id);
		}
		edi.updateEmpRei(new_reimbursement-previous_reimbursement, trf_id); //update employee
		return "BenCoTRF.html";
	}

}
