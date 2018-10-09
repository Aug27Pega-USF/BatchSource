package com.runtime.dao;


import java.util.List;

import com.runtime.bean.Reimbursement;



public interface ReimbursementDao {
	public int insertReimbursement(Reimbursement reimbursement);

	public List<Reimbursement> getReimbursementList(int userId);

	public Reimbursement getReimbursementById(int userId);

	public int updateReimbursementById(int reimbursementId);

	public int deleteReimbursementById(int reimbursementId);

	List<Reimbursement> getReimbursementListByJobType(int jobType);

}
