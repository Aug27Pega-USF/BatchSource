package com.trf.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trf.controller.ApproveController;
import com.trf.controller.HomeController;
import com.trf.controller.LoginController;
import com.trf.controller.MessageController;
import com.trf.controller.ReimbursementController;
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
		return ApproveController.bcapprove(request);
	case "/website/html/BCDeny.do":
		System.out.println("bcdeny");
		return ApproveController.bcdeny(request);
	case "/website/html/DSApprove.do":
		System.out.println("dsapprove");
		return ApproveController.dsapprove(request);
	case "/website/html/DSDeny.do":
		System.out.println("dsdeny");
		return ApproveController.dsdeny(request);
	case "/website/html/DHApprove.do":
		System.out.println("dhapprove");
		return ApproveController.dhapprove(request);
	case "/website/html/DHDeny.do":
		System.out.println("dhdeny");
		return ApproveController.dhdeny(request);
	case "/website/html/Request.do":
		System.out.println("request");
		return ApproveController.requestinfo(request);
	case "/website/html/SubmitInfo.do":
		System.out.println("submit");
		return ApproveController.submitinfo(request);
	case "/website/html/EMP_MSGviewJSON.do":
		System.out.println("empviewmessage");
		return MessageController.viewMSGJSON(request,response);
	case "/website/html/Adjust.do":
		System.out.println("adjust");
		return TRFController.adjust(request);
	case "/website/html/updateReimbursement.do":
		System.out.println("updateReimbursement");
		return ReimbursementController.viewREJSON(request,response);
	case "/website/html/UpdateReimbursement.do":
		System.out.println("UpdateReimbursement");
		return ReimbursementController.updateReimbursement(request);
	case "/website/html/AcceptChanges.do":
		System.out.println("accept changes");
		return ApproveController.acceptchanges(request);
	case "/website/html/WithdrawApplication.do":
		System.out.println("withdraw application");
		return ApproveController.withdrawapplication(request);
	case "/website/html/SubmitPresentation.do":
		System.out.println("submitPresentation");
		return TRFController.submitPresentation(request);
	case "/website/html/SubmitGradingFormat.do":
		System.out.println("submit grade");
		return TRFController.submitGrade(request);
	case "/website/html/ApproveGrade.do":
		System.out.println("approve grade");
		return ApproveController.approveGrade(request);
	case "/website/html/DenyGrade.do":
		System.out.println("deny grade");
		return ApproveController.denyGrade(request);
	case "/website/html/ApprovePresentation.do":
		System.out.println("approve presentation");
		return ApproveController.approvePresentation(request);
	case "/website/html/DenyPresentation.do":
		System.out.println("deny presentation");
		return ApproveController.denyPresentation(request);
	default:
		return "/html/Login.html";
	}
}
}
