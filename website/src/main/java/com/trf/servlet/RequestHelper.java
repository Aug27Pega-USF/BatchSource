package com.trf.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trf.controller.ApproveController;
import com.trf.controller.HomeController;
import com.trf.controller.LoginController;
import com.trf.controller.TRFController;

public class RequestHelper {
	public static String process(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request.getRequestURI());
	switch(request.getRequestURI()) {
	case "/website/html/Login.do":
		System.out.println("in login do");
		return LoginController.Login(request);
	case "/website/html/EmpJSON.do":
		System.out.println("in empjson do");
		return HomeController.EmployeeJSON(request, response);
	case "/website/html/TRFviewJSON.do":
		System.out.println("trfview");
		return TRFController.viewTRFJSON(request, response);
	case "/website/html/BC_TRFviewJSON.do":
		System.out.println("bc_trfview");
		return TRFController.BC_viewTRFJSON(request, response);
	case "/website/html/DSDH_viewJSON.do":
		System.out.println("dsdh_trfview");
		return TRFController.DSDH_viewTRFJSON(request,response);
	case "/website/html/TRF.do":
		System.out.println("in trf do");
		return TRFController.submitTRF(request);
	case "/website/html/BCApprove.do":
		System.out.println("bcapprove");
		return ApproveController.bcapprovedeny(request);
	case "/website/html/BCDeny.do":
		System.out.println("bcdeny");
		return ApproveController.bcdeny(request);
	case "/website/html/DSApprove.do":
		System.out.println("dsapprove");
		return ApproveController.dsapprovedeny(request);
	case "/website/html/DSDeny.do":
		System.out.println("dsdeny");
		return ApproveController.dsdeny(request);
	case "/website/html/DHApprove.do":
		System.out.println("dhapprove");
		return ApproveController.dhapprovedeny(request);
	case "/website/html/DHDeny.do":
		System.out.println("dhdeny");
		return ApproveController.dhdeny(request);
	default:
		return "/html/Login.html";
	}
}
}
