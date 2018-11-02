package com.example.servlet;

public class MasterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException,IOException{
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException,IOException{
		String targetURL=RequestHelper.process(request,response);
	}
}
