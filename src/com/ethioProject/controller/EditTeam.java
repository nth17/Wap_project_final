package com.ethioProject.controller;

import com.ethioProject.DAO.TeamDAO;

import com.ethioProject.Bean.Team;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "EditTeam", urlPatterns = "/editteam")
public class EditTeam extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("teamid");
        String name = request.getParameter("name");
        System.out.println(id + "---------------" + name);
        try {
            TeamDAO.update(id, name);
            request.setAttribute("teams", TeamDAO.findall());
            request.getRequestDispatcher("CreateTeam.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teamid = request.getParameter("teamid");
        System.out.println("entered someshit ------------   "+teamid);
        try {
            Team team = TeamDAO.findbyID(teamid);
            System.out.println("Fuck no"+team);
            Gson gson = new Gson();
            String jsondata = gson.toJson(team);
            System.out.println("Object is "+team);
            System.out.println(jsondata);
            PrintWriter out = response.getWriter();
            System.out.println(jsondata+"---------------");
            out.println(jsondata);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
