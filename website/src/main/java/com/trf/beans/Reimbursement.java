package com.trf.beans;

public class Reimbursement {
	String trf_id;
	String available_reimbursement;
	String trf_reimbursement;
	@Override
	public String toString() {
		return "Reimbursement [trf_id=" + trf_id + ", available_reimbursement=" + available_reimbursement
				+ ", trf_reimbursement=" + trf_reimbursement + "]";
	}
	public Reimbursement(String trf_id, String available_reimbursement, String trf_reimbursement) {
		super();
		this.trf_id = trf_id;
		this.available_reimbursement = available_reimbursement;
		this.trf_reimbursement = trf_reimbursement;
	}
	public String getTrf_id() {
		return trf_id;
	}
	public void setTrf_id(String trf_id) {
		this.trf_id = trf_id;
	}
	public String getAvailable_reimbursement() {
		return available_reimbursement;
	}
	public void setAvailable_reimbursement(String available_reimbursement) {
		this.available_reimbursement = available_reimbursement;
	}
	public String getTrf_reimbursement() {
		return trf_reimbursement;
	}
	public void setTrf_reimbursement(String trf_reimbursement) {
		this.trf_reimbursement = trf_reimbursement;
	}
	
}
