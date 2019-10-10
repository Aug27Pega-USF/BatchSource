package com.revature.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.revature.ws.MessageGen",
serviceName="messageGenService")
public class MessageGenImpl implements MessageGen{

	public String getMessage() {
		
		return "Hi Brian...";
	}

}