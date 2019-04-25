package com.ethioProject.DAO;

import com.ethioProject.Bean.Priority;
import com.ethioProject.Bean.Task;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    static Connection connect = null;
    static Statement statement= null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    public static boolean save(Task task, int userid, int teamid) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "INSERT INTO task (task_name, " +
                "task_description, " +
                "task_priority," +
                "due_date, " +
                "completed, " +
                "catagory, " +
                "current_developer_userid, " +
                "current_team_team_id) VALUES ('"+ task.getTaskName() + "', '" +task.getTaskDescription() + "', '"+ task.getTaskPriority().toString() + "', " + null + ", " + task.isCompleted() + ", '" + task.getCatagory() +  "', " + userid + ", "  + teamid +")";
        System.out.println(query);
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        statement.executeUpdate(query);
        return true;
    }

    public static List<Task> findalltasks() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "SELECT * from task ";
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        resultSet = statement.executeQuery(query);
        List<Task> tasks = new ArrayList<>();
        while(resultSet.next())
        {
            Task newt = new Task();
            newt.setTaskId(Integer.parseInt(resultSet.getString("task_id")));
            newt.setTaskName(resultSet.getString("task_name"));
            newt.setTaskDescription(resultSet.getString("task_description"));
            if(resultSet.getString("task_priority") == "HIGH")
                newt.setTaskPriority(Priority.HIGH);
            if(resultSet.getString("task_priority") == "MEDIUM")
                newt.setTaskPriority(Priority.MEDIUM);
            else
                newt.setTaskPriority(Priority.LOW);
            newt.setCompleted(Boolean.parseBoolean(resultSet.getString("completed")));
            newt.setCatagory(resultSet.getString("catagory"));
            newt.setDueDate(LocalDate.now());
            newt.setCurrentTeam(TeamDAO.findbyID(resultSet.getString("current_team_team_id")));
            newt.setCurrentDeveloper(UserDAO.finduserbyid(resultSet.getString("current_developer_userid")));
            tasks.add(newt);
        }
        return tasks;
    }

    public static List<Task> findtaskbyuserid(String userid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "SELECT * from task where current_developer_userid = " + userid;
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        resultSet = statement.executeQuery(query);
        List<Task> tasks = new ArrayList<>();
        while(resultSet.next())
        {
            Task newt = new Task();
            newt.setTaskId(Integer.parseInt(resultSet.getString("task_id")));
            newt.setTaskName(resultSet.getString("task_name"));
            newt.setTaskDescription(resultSet.getString("task_description"));
            if(resultSet.getString("task_priority") == "HIGH")
                newt.setTaskPriority(Priority.HIGH);
            if(resultSet.getString("task_priority") == "MEDIUM")
                newt.setTaskPriority(Priority.MEDIUM);
            else
                newt.setTaskPriority(Priority.LOW);
            newt.setCompleted(Boolean.parseBoolean(resultSet.getString("completed")));
            newt.setCatagory(resultSet.getString("catagory"));
            newt.setDueDate(LocalDate.now());
            newt.setCurrentTeam(TeamDAO.findbyID(resultSet.getString("current_team_team_id")));
            newt.setCurrentDeveloper(UserDAO.finduserbyid(resultSet.getString("current_developer_userid")));
            tasks.add(newt);
        }
        return tasks;
    }

    public static Task findtaskbyid(String userid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "SELECT * from task where task_id = " + userid;
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        resultSet = statement.executeQuery(query);
        Task newt = new Task();
        while(resultSet.next())
        {
            newt.setTaskId(Integer.parseInt(resultSet.getString("task_id")));
            newt.setTaskName(resultSet.getString("task_name"));
            newt.setTaskDescription(resultSet.getString("task_description"));
            if(resultSet.getString("task_priority") == "HIGH")
                newt.setTaskPriority(Priority.HIGH);
            if(resultSet.getString("task_priority") == "MEDIUM")
                newt.setTaskPriority(Priority.MEDIUM);
            else
                newt.setTaskPriority(Priority.LOW);
            newt.setCompleted(Boolean.parseBoolean(resultSet.getString("completed")));
            newt.setCatagory(resultSet.getString("catagory"));
            newt.setDueDate(LocalDate.now());
            newt.setCurrentTeam(TeamDAO.findbyID(resultSet.getString("current_team_team_id")));
            newt.setCurrentDeveloper(UserDAO.finduserbyid(resultSet.getString("current_developer_userid")));
        }
        return newt;
    }

    public static void delete(String taskid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "DELETE FROM task Where task_id = '" + taskid + "'";
        System.out.println(query + "--------------------------------------------");
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        statement.executeUpdate(query);
    }

    public static void addnewtaskforteammember(String Taskid, String UserID) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "UPDATE task SET current_developer_userid = '"+ UserID + "' WHERE task_id = '"+ Taskid + "'";
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        statement.executeUpdate(query);

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Task newt = new Task();
        newt.setTaskName("Get Task part done");
        newt.setTaskDescription("desc");
        newt.setTaskPriority(Priority.HIGH);
        newt.setCompleted(false);
        newt.setCatagory("work");
        newt.setDueDate(LocalDate.now());
        int userid = 2;
        int teamid=19;
        save(newt, userid, teamid);

    }

    public static void update(Task task, Date duedate) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query = "UPDATE task SET task_name = '" + task.getTaskName() + "', task_description = '" +  task.getTaskDescription() + "', task_priority = '" + task.getTaskPriority().toString() + "' WHERE task_id = '" + task.getTaskId() + "'";
        System.out.println(query);
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        statement.executeUpdate(query);
    }

}
