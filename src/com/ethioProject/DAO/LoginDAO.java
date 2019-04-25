package com.ethioProject.DAO;

import com.ethioProject.Bean.User;

import java.sql.*;

public class LoginDAO {
   static boolean status = false;
   static PreparedStatement pst = null;
   static  ResultSet rs = null;
  static   boolean s=false;
  static   boolean s1=false;
    public static User validate (String email , String password){

User u = new User();



        try {

            pst = DataBaseDAO.connection()

                    .prepareStatement("select * from user where email=? and password=?");
            pst.setString(1, email);
            pst.setString(2, password);

            rs = pst.executeQuery();
            while (rs.next()) {
                    u.setPhoneNo(rs.getString("phone_no"));
                    u.setUserID(rs.getInt("userid"));
                    u.setPassword(rs.getString("password"));
                    u.setEmail(rs.getString("email"));
                    u.setFirstName(rs.getString("first_name"));
                    u.setLastName(rs.getString("last_name"));
                    u.setLocation(rs.getString("location"));
                u.setIs_admin(rs.getBoolean("is_admin"));

                 u.setIs_projectmanager(rs.getBoolean("is_project_manager"));
            }

                System.out.println(u +"gooooo -------------");
          return u;
//            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return u;


    }
}
