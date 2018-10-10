package com.greenbull;

public class WorkerPages {

	public WorkerPages() {

	}

	public static String getWorkerPage(int type_of) {
		switch(type_of) {
			case 0:
			default:
				return "/html/Employee.html";
			case 1:
				return "/html/directsupervisor.html";
			case 2:
				return "/html/departmentManager.html";
			case 3:
				return "/html/Benco.html";
			case 4:
				return "/html/bencoSupervisor.html";
		}
	}
}
