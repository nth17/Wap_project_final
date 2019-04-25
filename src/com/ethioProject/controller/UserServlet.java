package com.ethioProject.controller;

import com.ethioProject.Bean.User;
import com.ethioProject.DAO.AdminDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "UserServlet" , urlPatterns = {"/userProfile"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<User> rs  = AdminDAO.read();
        request.setAttribute("datag",null);

        System.out.println(rs);



        ;

        PrintWriter out = response.getWriter();
//        out.println(js);//use toString() to convert to JSON

        request.setAttribute("datag",rs);

        System.out.println( "Please"+request.getAttribute("datag"));


        request.getRequestDispatcher("something.jsp").forward(request, response);

    }
}
