package com.ethioProject.controller;

import com.ethioProject.Bean.User;
import com.ethioProject.DAO.AdminDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpRequest;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet" , urlPatterns = {"/userAdd","/getUser","/delete","/update"})
public class AdminServlet extends HttpServlet {
    private ObjectMapper mapper;
    @Override
    public void init() throws ServletException {
        this.mapper = new ObjectMapper();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String action = request.getRequestURI();
System.out.println(action);

 if(action.equals("/ProjectFinal/delete")){
     String id = request.getParameter("idSelected");
     System.out.println("My id is "+id);
     int result = AdminDAO.delete(id);
     System.out.println(result + " rows affected Successfully Created");
 }else if(action.equals("/ProjectFinal/update")){
//     col_name="userId"><c:out value="${dataItem.getUserID()}"/></div></td>
//                                                <td><div class="row_data" edit_type="click" col_name="firstName"><c:out value="${dataItem.getFirstName()}"/></div></td>
//                                                <td><div class="row_data" edit_type="click" col_name="lastName"><c:out value="${dataItem.getLastName()}"/></div></td>
//                                                <td><div class="row_data" edit_type="click" col_name="email"><c:out value="${dataItem.getEmail()}"/></div></td>
//                                                <td><div class="row_data" edit_type="click" col_name="phoneNo"><c:out value="${dataItem.getPhoneNo()}"/></div></td>
        String firstName = request.getParameter("firstName");
     String userId = request.getParameter("userId");
     String lastName = request.getParameter("lastName");
     String email = request.getParameter("email");
     String phoneNo = request.getParameter("phoneNo");
     int result = AdminDAO.update(email,firstName,lastName,phoneNo,userId);

        System.out.println(result+" Updated successfully");
 }
 else {
     String email = request.getParameter("email");
     String fistName = request.getParameter("firstName");
     String lastName = request.getParameter("lastName");
     String address = request.getParameter("pass");
     String phoneNo = request.getParameter("phoneNumber");
     String location = request.getParameter("location");
     String check="0";
     int result=0;
     if(request.getParameter("projectManager")!=null){
          result = AdminDAO.create(email, fistName, lastName, address, phoneNo,location,"1");
         request.getRequestDispatcher("user.jsp").forward(request, response);
     }else {
         result = AdminDAO.create(email, fistName, lastName, address, phoneNo, location, check);
         System.out.println(result + " rows affected Successfully Created");
         request.getRequestDispatcher("user.jsp").forward(request, response);
     }
 }
    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ArrayList<User> rs  = AdminDAO.read();
       request.setAttribute("datag",null);

        System.out.println(rs);

       mapper = new ObjectMapper();
    mapper.writeValueAsString(rs);

   ;

        PrintWriter out = response.getWriter();
//        out.println(js);//use toString() to convert to JSON

        request.setAttribute("datag",rs);

        System.out.println( "Please"+request.getAttribute("datag"));


        request.getRequestDispatcher("something.jsp").forward(request, response);

    }
}
