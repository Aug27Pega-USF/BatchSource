package com.runtime.bean;

public class Reimbursement {
	private int reimbursementId;
	private int userId;
	private int jobType;
	private String reason;
	private String date;
	private String srtTime;
	private String endTime;
	private int status;
	private String statusTime;
	private double availAmount;
	private double pendingAmount;
	private double reimAmount;
	private String resetTime;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getJobType() {
		return jobType;
	}
	public void setJobType(int jobType) {
		this.jobType = jobType;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSrtTime() {
		return srtTime;
	}
	public void setSrtTime(String srtTime) {
		this.srtTime = srtTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusTime() {
		return statusTime;
	}
	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}
	public double getAvailAmount() {
		return availAmount;
	}
	public void setAvailAmount(double availAmount) {
		this.availAmount = availAmount;
	}
	public double getPendingAmount() {
		return pendingAmount;
	}
	public void setPendingAmount(double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}
	public double getReimAmount() {
		return reimAmount;
	}
	public void setReimAmount(double reimAmount) {
		this.reimAmount = reimAmount;
	}
	public String getResetTime() {
		return resetTime;
	}
	public void setResetTime(String resetTime) {
		this.resetTime = resetTime;
	}
	
	public Reimbursement() {
		// TODO Auto-generated constructor stub
	}
	
	public int getReimbursementId() {
		return reimbursementId;
	}
	
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", userId=" + userId + ", jobType=" + jobType
				+ ", reason=" + reason + ", date=" + date + ", srtTime=" + srtTime + ", endTime=" + endTime
				+ ", status=" + status + ", statusTime=" + statusTime + ", availAmount=" + availAmount
				+ ", pendingAmount=" + pendingAmount + ", reimAmount=" + reimAmount + ", resetTime=" + resetTime + "]";
	}
	public Reimbursement(int reimbursementId, int userId, int jobType, String reason, String date, String srtTime,
			String endTime, int status, String statusTime, double availAmount, double pendingAmount, double reimAmount,
			String resetTime) {
		super();
		this.reimbursementId = reimbursementId;
		this.userId = userId;
		this.jobType = jobType;
		this.reason = reason;
		this.date = date;
		this.srtTime = srtTime;
		this.endTime = endTime;
		this.status = status;
		this.statusTime = statusTime;
		this.availAmount = availAmount;
		this.pendingAmount = pendingAmount;
		this.reimAmount = reimAmount;
		this.resetTime = resetTime;
	}
	
	


}
