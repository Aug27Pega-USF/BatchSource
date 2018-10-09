package com.trf.DAOImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.trf.DAO.EmployeeDao;
import com.trf.beans.Employee;
import com.trf.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Employee getEmployeebyId(int id) {
		Employee emp = null;
		Connection conn = cf.getConnection();
		try {
			PreparedStatement prest = conn.prepareStatement("SELECT USER_ID, REFERSTO, USER_TYPE_ID, FIRST_NAME, LAST_NAME, BASIC_INFO_PLACEHOLDER, AVAILABLE_REIMBURSEMENT, PENDING_REIMBURSEMENT, AWARDED_REIMBURSEMENT FROM EMPLOYEE WHERE USER_ID=?");
			prest.setString(1, Integer.toString(id));
			ResultSet rs = prest.executeQuery();
			rs.next();
			emp = new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8), rs.getString(9));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public int login(String username, String password) {
		Connection conn = cf.getConnection();
		String sql = "SELECT LOGIN(?,?) FROM DUAL";
		try {
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, username);
			prest.setString(2, password);
			ResultSet rs = prest.executeQuery();
			rs.next();
			int account_id = rs.getInt(1);
			if (account_id != 0) {
				System.out.println("Succesfully logged in " + username + ".");
			}
			conn.close();
			return account_id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public String getLevel(int employeeid) {
		Connection conn = cf.getConnection();
		String sql = "SELECT GET_EMP_LEVEL(?) FROM DUAL";
		try {
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setInt(1, employeeid);;
			ResultSet rs = prest.executeQuery();
			rs.next();
			String account_level = rs.getString(1);
			conn.close();
			return account_level;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void DSApprove(int trfid) {
        Connection conn = cf.getConnection();
        String sql = "{call DSAPPROVE(?)";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, trfid);
            cs.execute();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void DHApprove(int trfid) {
        Connection conn = cf.getConnection();
        String sql = "{call DHAPPROVE(?)}";
        try {
            DSApprove(trfid);
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, trfid);
            cs.execute();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void BCApprove(int trfid) {
        Connection conn = cf.getConnection();
        String sql = "{call BCAPPROVE(?)}";
        try {
            DSApprove(trfid);
            DHApprove(trfid);
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, trfid);
            cs.execute();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void denied(int trfid) {
        Connection conn = cf.getConnection();
        String sql = "{call TRF_DENIED(?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, trfid);
            cs.execute();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	public int requestinfo(String trf_id, String user_level) {
		Connection conn = cf.getConnection();
		String sql = "{call TRF_REQUESTINFO(?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, trf_id);
            cs.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		sql = "SELECT GET_BOSS(?,?) FROM DUAL";
		try {
			PreparedStatement prest = conn.prepareStatement(sql);
			String employee_level="1"; //if employee
			switch(user_level){
				case "Direct Supervisor":
					employee_level="2";
					break;
				case "Department Head":
					employee_level="3";
					break;
			}
			prest.setString(1, employee_level);
			prest.setString(2, trf_id);
			ResultSet rs = prest.executeQuery();
			rs.next();
			int employee_id = rs.getInt(1);
			conn.close();
			return employee_id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	public int submitinfo(String trf_id) {
		Connection conn = cf.getConnection();
		String sql = "{call TRF_GIVENINFO(?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, trf_id);
            cs.execute();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return 0;
	}

	public void updateEmpRei(float rei_change, int trf_id) { //if positive, available rei-rei_change, pendingrei+rei_change.
		System.out.println("Rei_change:" + rei_change);
		Connection conn= cf.getConnection();
		if (rei_change > 0 ) {
		try {
			CallableStatement cs = conn.prepareCall("{call REIINCREASE(?,?)");
			cs.setInt(1, trf_id);
			cs.setFloat(2, rei_change);
			cs.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}else if (rei_change < 0 ) {
		try {
			rei_change=-rei_change;
			CallableStatement cs = conn.prepareCall("{call REIDECREASE(?,?)");
			cs.setInt(1, trf_id);
			cs.setFloat(2, rei_change);
			cs.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}

	public void updateInfo(int trf_id) {
		Connection conn = cf.getConnection();
		String sql = "{call TRF_REQUESTINFO(?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, trf_id);
            cs.execute();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}
	
	public void withdraw_app(int trf_id) {
		Connection conn = cf.getConnection();
		String sql = "{call TRF_WITHDRAW(?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, trf_id);
            cs.execute();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public void accept_changes(int trf_id) {
		Connection conn = cf.getConnection();
		String sql = "{call TRF_ACCEPT(?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, trf_id);
            cs.execute();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public int get_boss(int trf_id, int employee_level) {
		Connection conn = cf.getConnection();
		String sql = "SELECT GET_BOSS(?,?) FROM DUAL";
		try {
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setInt(1, employee_level);
			prest.setInt(2, trf_id);
			ResultSet rs = prest.executeQuery();
			rs.next();
			int employee_id = rs.getInt(1);
			conn.close();
			return employee_id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void TRFAwarded(int trf_id) {
		Connection conn = cf.getConnection();
		String sql = "{call TRF_AWARD(?)}";
		try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, trf_id);
            cs.execute();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}
	
	public void auto_approve(){
		Connection conn = cf.getConnection();
		String sql = "{call UPDATE_TRF_WITH_TIME}";
		try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.execute();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
}
