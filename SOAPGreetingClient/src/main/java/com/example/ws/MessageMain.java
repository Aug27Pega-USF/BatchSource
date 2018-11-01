package com.example.ws;

public class MessageMain {

	public static void main(String[] args) {


		MessageGenService msgen = new MessageGenService();
		
		MessageGen msport = msgen.getMessageGenImplPort();
		
		System.out.println(msport.getMessage());

	}

}
