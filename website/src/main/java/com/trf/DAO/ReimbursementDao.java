package com.trf.DAO;

public interface ReimbursementDao {
    public String getTRFReimbursementbyID(int trf_id);
    public String getAvailableReimbursement(int trf_id);
}