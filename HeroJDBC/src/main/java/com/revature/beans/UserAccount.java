package com.revature.beans;

public class UserAccount {
        private int userID;
        private String userName;
        private String pass;
        private int adminn;
        public UserAccount(int i, String string, String string2, int j2) {
            super();
            // TODO Auto-generated constructor stub
        }
        @Override
        public String toString() {
            return "UserAccount [User ID = " + userID + ", User Name = " + userName +"]";
        }
        public UserAccount(int userID, String userName, String pass) {
            super();
            this.userID = userID;
            this.userName = userName;
            this.pass = pass;
            this.adminn = adminn;
        }
        public int getuserID() {
            return userID;
        }
        public void setuserID(int userID) {
            this.userID = userID;
        }
        public String getuserName() {
            return userName;
        }
        public void setuserName(String userName) {
            this.userName = userName;
        }
        public String getpass() {
            return pass;
        }
        public void setpass(String pass) {
            this.pass = pass;
        }
        public int getadminn() {
            return adminn;
        }
        public void setadminn(int adminn) {
            this.adminn = adminn;
        }
    }