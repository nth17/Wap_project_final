package com.ethioProject.controller;

import com.ethioProject.DAO.TeamDAO;
import com.ethioProject.DAO.UserDAO;
import com.ethioProject.Bean.Team;
import com.ethioProject.Bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddusertoteamServlet", urlPatterns = "/adduser")
public class AddusertoteamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("teamid"));
        String teamid = request.getParameter("teamid");
        String userid = request.getParameter("userid");

        System.out.println(teamid + "------------------" + userid);
        try {
            UserDAO.updateteam(teamid, userid);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("teamid"));
        try {
            request.setAttribute("users", UserDAO.findallwithoutteam());
            request.setAttribute("team", TeamDAO.findbyID(request.getParameter("teamid")));
            request.getRequestDispatcher("AddUserToTeam.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
