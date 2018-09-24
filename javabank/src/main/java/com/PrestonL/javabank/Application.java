package com.PrestonL.javabank;

import java.io.Serializable;
import java.util.ArrayList;

public class Application implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5643223443360652745L;
	private int accountid;
	private ArrayList<String> nameList;
	private String username;

	public boolean isJoint() {
		return joint;
	}


	public boolean isExisting() {
		return existing;
	}


	private boolean joint=false;
	private boolean existing=false;

	public Application(String username, int accountid, String name) {
		this.nameList=new ArrayList<String>();
		this.username=username;
		this.accountid=accountid;
		this.nameList.add(name);
	}

	public Application(String username, int accountid, String name, boolean joint, boolean existing) {
		this(username,accountid,name);
		this.joint=joint;
		this.existing=existing;
	}


	public int getAccountid() {
		return accountid;
	}

	public void addName(String name) {
		this.nameList.add(name);
		this.joint=true;
	}

	public ArrayList<String> getNames(){
		return nameList;
	}

	public String getNameList() {
		String name = "("; 
		for (int i=0; i!=nameList.size(); i++) {
			name+=nameList.get(i);
			if (i!=nameList.size()-1) {
				name+=",";
			}
		}
		name+=")";
		return name;
	}

	@Override
	public String toString() {
		String temp="";
		String temp2="";
		String temp3=", Customers Applying=";
		if (joint) {
			temp= "Joint Account ";
		}
		if (existing) {
			temp2=" to existing account ";
		}
		return temp+ "Application" + temp2 +"[Applying for account " + accountid + temp3 + getNameList() +"]";
	}



}
