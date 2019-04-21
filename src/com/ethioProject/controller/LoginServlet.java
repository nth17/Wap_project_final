package com.ethioProject.controller;

import com.ethioProject.DAO.LoginDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
   System.out.println("--------------------------------------");
        String n=request.getParameter("email");
        String p=request.getParameter("userpass");

        HttpSession session = request.getSession(false);
        if(session!=null)
            session.setAttribute("name", n);

        if(LoginDAO.validate(n, p)){
            RequestDispatcher rd=request.getRequestDispatcher("dashboard.html");
            rd.forward(request,response);
           out.println("success");
        }
        else{
            out.print("<p style=\"color:red\">Sorry username or password error</p>");
            RequestDispatcher rd=request.getRequestDispatcher("login.html");
            rd.include(request,response);
        }

        out.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
