package com.ethioProject.controller;

import com.ethioProject.DAO.TaskDAO;
import com.ethioProject.DAO.TeamDAO;
import com.ethioProject.DAO.UserDAO;
import com.ethioProject.Bean.Priority;
import com.ethioProject.Bean.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "CreateTaskServlet", urlPatterns = "/createtask")
public class CreateTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String task_id = request.getParameter("task_id");
        String task_name = request.getParameter("task_name");
        String task_description = request.getParameter("task_descrption");
        String priority = request.getParameter("task_priority");
        String catagory = request.getParameter("catagory");
        String complete = request.getParameter("completed");
        boolean completed = false;
        if(complete.equalsIgnoreCase("true")){
            completed=true;
        }

        Date due_date = null;
        try {
            String d = request.getParameter("due_date");
            java.util.Date due = new SimpleDateFormat("MM-dd-MM-yyyy").parse(d);
            due_date = new Date(due.getTime());
        }catch(ParseException e){
            e.printStackTrace();
        }
        String current_developer_userid = request.getParameter("current_developer_userid");
        String current_team_team_id = request.getParameter("current_team_team_id");
        try {
            Task newTask = TaskDAO.findtaskbyid(task_id);
            newTask.setTaskName(task_name);
            newTask.setTaskDescription(task_description);
            if(priority == "HIGH")
                newTask.setTaskPriority(Priority.HIGH);
            else if(priority == "MEDIUM")
                newTask.setTaskPriority(Priority.MEDIUM);
            else
                newTask.setTaskPriority(Priority.LOW);
            newTask.setCatagory(catagory);
            newTask.setCompleted(completed);
            TaskDAO.save(newTask, Integer.parseInt(current_developer_userid), Integer.parseInt(current_team_team_id));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            request.setAttribute("tasks", TaskDAO.findalltasks());
            request.getRequestDispatcher("ManageTasks.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
