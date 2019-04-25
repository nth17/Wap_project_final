package com.ethioProject.controller;

import com.ethioProject.DAO.TeamDAO;
import com.ethioProject.Bean.Team;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "/CreateTeam", urlPatterns = "/CreateTeam")
public class CreateTeam extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if(request.getSession().getAttribute("user_id") == null)
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        else{
            Team newteam = new Team();
            newteam.setTeamName(request.getParameter("TeamName"));
            try {
                TeamDAO.save(newteam);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
//        }
        try {
            request.setAttribute("teams", TeamDAO.findall());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("CreateTeam.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if(request.getSession().getAttribute("user_id") == null)
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        else{

                try {
                    System.out.println(TeamDAO.findall());
                    request.setAttribute("teams", TeamDAO.findall());
                    request.getRequestDispatcher("CreateTeam.jsp").forward(request, response);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

//        }
    }
}
