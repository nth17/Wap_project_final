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

@WebServlet(name = "GetTeamMemebersServlet", urlPatterns = "/gettemmembers")
public class GetTeamMemebersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teamid = request.getParameter("teamid");
        try {
            List<User> users = UserDAO.getteammembers(teamid);
            Team team = TeamDAO.findbyID(teamid);
            System.out.println(team);
            request.setAttribute("users", users);
            request.setAttribute("team", team);
            request.getRequestDispatcher("ViewTeamMemebers.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
