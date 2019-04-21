package com.ethioProject.DAO;

import java.sql.*;

public class LoginDAO {

    public static boolean validate (String email , String password){
        Connection con =null ;
        boolean status = false;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url ="jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


        String userName = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager
                    .getConnection(url, userName, pass);

            pst = con

                    .prepareStatement("select * from user where email=? and password=?");
            pst.setString(1, email);
            pst.setString(2, password);

            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        return status;


    }
}
