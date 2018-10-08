package com.trf.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trf.DAOImpl.ReimbursementDaoImpl;
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
		// TODO Auto-generated method stub
		return null;
	}

}
