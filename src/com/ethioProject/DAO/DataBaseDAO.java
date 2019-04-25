package com.ethioProject.DAO;

import java.sql.*;

public class DataBaseDAO {


    public static Connection connection(){
        Connection con =null ;
      

//        String url ="jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

String url="https://www.db4free.net/phpMyAdmin/db_structure.php?server=1&db=maindbmum4";
        String userName = "waproot";
        String pass = "1c845800";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager
                .getConnection(url, userName, pass);
    }catch (Exception e) {
        System.out.println(e);
    }

        return con;

    }







}
