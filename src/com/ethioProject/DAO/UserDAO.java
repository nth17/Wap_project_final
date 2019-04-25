package com.ethioProject.DAO;

import com.ethioProject.Bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    static Connection connect = null;
    static Statement statement= null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    public static List<User> findallwithoutteam() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "SELECT * from user where ( is_admin = " + 0 + " and  is_project_manager = " +  0 + ")";
        System.out.println(query);
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        resultSet = statement.executeQuery(query);
        List<User> users = new ArrayList<>();
        while(resultSet.next()){
            User user = new User();
            user.setUserID(Integer.parseInt(resultSet.getString("userid")));
            user.setEmail(resultSet.getString("email"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setPhoneNo(resultSet.getString("phone_no"));
            if(resultSet.getString("team_team_id") == null){
                users.add(user);
            }
            System.out.println(user);
        }
        return users;
    }

    public static boolean updateteam(String TeamID, String UserID) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query = "UPDATE user SET team_team_id = '" + TeamID + "' WHERE userid = '" + UserID + "'";
        System.out.println(query);
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        statement.executeUpdate(query);
        return true;
    }

    public static List<User> getteammembers(String TeamID) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "SELECT * from user where ( team_team_id = '" + TeamID + "')";
        System.out.println(query);
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        resultSet = statement.executeQuery(query);
        System.out.println(resultSet);
        List<User> users = new ArrayList<>();
        while(resultSet.next()){
            User user = new User();
            user.setUserID(Integer.parseInt(resultSet.getString("userid")));
            user.setEmail(resultSet.getString("email"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setPhoneNo(resultSet.getString("phone_no"));
            users.add(user);
        }
        System.out.println(users.size());
        return users;
    }

    public static User finduserbyid(String userid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "SELECT * from user where userid = " + userid ;
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        resultSet = statement.executeQuery(query);
        User user = new User();
        while(resultSet.next()){
            user.setUserID(Integer.parseInt(resultSet.getString("userid")));
            user.setEmail(resultSet.getString("email"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setPhoneNo(resultSet.getString("phone_no"));
        }
        return user;
    }
}
