package com.trf.DAO;

import com.trf.beans.Employee;

public interface EmployeeDao {
    public Employee getEmployeebyId(int id);
    public int login(String username, String password);
    public String getLevel(int employeeid);
    public void DSApprove(int trfid);
    public void DHApprove(int trfid);
    public void BCApprove(int trfid);
    public void denied(int trfid);
    public int requestinfo(String trf_id, String user_level);
    public int submitinfo(String trf_id);
    public void updateEmpRei(float rei_change, int trf_id);
    public void updateInfo(int trf_id);
    public void withdraw_app(int trf_id);
    public void accept_changes(int trf_id);
    public int get_boss(int trf_id, int employee_level);
    public void TRFAwarded(int trf_id);
}