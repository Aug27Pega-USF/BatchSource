package com.example.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.example.ws.MessageGen", serviceName="messageGenService")
public class MessageGenImpl implements MessageGen {

	public String getMessage() {
		return "Hello everyone";
	}

}
