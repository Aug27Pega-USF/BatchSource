package com.revature.DAOImpl;

    import java.sql.CallableStatement;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.List;
    
    import com.revature.beans.UserAccount;
    import com.revature.DAO.UserAccountDAO;
    import com.revature.util.ConnFactory;

    public class UserAccountDAOImpl implements UserAccountDAO{
        
        public static ConnFactory cf = ConnFactory.getInstance();
        
        public void createUserAccount(int userID, String userName, String pass, int adminn) throws SQLException {
            Connection conn = cf.getConnection();
            String sql= "INSERT INTO USERACCOUNT VALUES(?,?,?,?)";
            CallableStatement call= conn.prepareCall(sql);
            call.setInt(1, userID);
            call.setString(2,userName);
            call.setString(3, pass);
            call.setInt(4, adminn);
            call.execute();
        }
        
        public List<UserAccount> getUserAccountList() throws SQLException {
            List<UserAccount> userAccountList =
                    new ArrayList<UserAccount>();
            Connection conn = cf.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERACCOUNT");//conn.createStatement();
            ResultSet rs = stmt.executeQuery();
            UserAccount u = null;
            
            while(rs.next()) {
                u = new UserAccount(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4));
                userAccountList.add(u);
            }
            return userAccountList;
        }
    
}