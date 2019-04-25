package com.ethioProject.DAO;

import com.ethioProject.Bean.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.sql.*;
import java.util.ArrayList;

public class AdminDAO {

  static   PreparedStatement pst = null;
 static    ResultSet rs = null;
static boolean status = false;
  static   int rowsAffected =0 ;

static  ArrayList<User> result ;
    public static int create(String email , String firstName , String lastName , String password , String phoneNumber,String locaion ,String isProject){


        try {
            if(isProject.equals("1")) {

                pst = DataBaseDAO.connection().prepareStatement("INSERT INTO user (email ,first_name, last_name,password, phone_no,location,is_admin , is_project_manager)\n" +
                        "VALUES ('" + email + "','" + firstName + "','" + lastName + "','" + password + "','" + phoneNumber + "','" + locaion + "', 0  ,1)");
            }else
                pst = DataBaseDAO.connection().prepareStatement("INSERT INTO user (email ,first_name, last_name,password, phone_no,location,is_admin , is_project_manager)\n" +
                        "VALUES ('" + email + "','" + firstName + "','" + lastName + "','" + password + "','" + phoneNumber + "','" + locaion + "', 0  ,0)");
//            pst.setString(1, email);
//            pst.setString(2, password);

            rowsAffected = pst.executeUpdate();


        } catch (Exception e) {
            System.out.println(e);
        }
        return rowsAffected;




    }
    public static ArrayList<User> read(){
        try {

                result  = new ArrayList<>();
            pst =    DataBaseDAO.connection().prepareStatement("SELECT * from user WHERE is_admin!=1");
//            pst.setString(1, email);
//            pst.setString(2, password);

            rs = pst.executeQuery();
            while (rs.next()){
            User user = new User();
               user.setUserID(rs.getInt("userid"));
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setPassword(rs.getString("password"));
                user.setPhoneNo(rs.getString("phone_no"));
                result.add(user);
            }
            return result;

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    public static int update(String email , String firstName , String lastName  , String phoneNumber,String uid){

        try {


            pst =    DataBaseDAO.connection().prepareStatement("UPDATE user SET  email='"+email+"',first_name='"+firstName+"',last_name='"+lastName+" ',phone_no ='"+ phoneNumber+ "' WHERE userid="+uid);
//            pst.setString(1, email);
//            pst.setString(2, password);

            rowsAffected= pst.executeUpdate();


        } catch (Exception e) {
            System.out.println(e);
        }
        return rowsAffected;



    }
    public static int delete(String uid){
        try {


            pst =    DataBaseDAO.connection().prepareStatement("DELETE FROM user WHERE userid="+uid);
//            pst.setString(1, email);
//            pst.setString(2, password);

            rowsAffected = pst.executeUpdate();


        } catch (Exception e) {
            System.out.println(e);
        }
        return rowsAffected;
    }

}
