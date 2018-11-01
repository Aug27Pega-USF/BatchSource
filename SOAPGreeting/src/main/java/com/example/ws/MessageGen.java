package com.example.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MessageGen {
	
	@WebMethod
	String getMessage();

}
