package com.ethioProject.Bean;

public class User {
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phone_no;

    User(String userId , String email , String firstName , String lastName , String password , String phone_no){
        this.userId = userId ;
        this.email= email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone_no = phone_no;
    }
}
