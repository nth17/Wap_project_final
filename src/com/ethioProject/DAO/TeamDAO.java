package com.ethioProject.DAO;

import com.ethioProject.Bean.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {
    static Connection connect = null;
    static Statement statement= null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    public static boolean save(Team team) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "INSERT INTO team (team_name) VALUES ('"+ team.getTeamName() +"')";
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        statement.executeUpdate(query);
        return true;
    }



    public static List<Team> findall() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "SELECT * from team";
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        resultSet = statement.executeQuery(query);
        List<Team> teams = new ArrayList<>();
        while(resultSet.next()){
            Team team = new Team();
            team.setTeamId(Integer.valueOf(resultSet.getString("team_id")));
            team.setTeamName(resultSet.getString("team_name"));
            teams.add(team);
        }
        return teams;
    }

    public static Team findbyID(String TeamID) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "SELECT * from team where team_id='" + TeamID + "'";
        System.out.println(query + "*********************************************************");
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        resultSet = statement.executeQuery(query);
        List<Team> teams = new ArrayList<>();
        Team team = new Team();
        while(resultSet.next()){
            team.setTeamId(Integer.valueOf(resultSet.getString("team_id")));
            team.setTeamName(resultSet.getString("team_name"));
        }
        System.out.println(team);
        return team;
    }

    public static void delete(String TeamID) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;

        query = "DELETE FROM team Where team_id = '" + TeamID + "'";
        System.out.println(query + "--------------------------------------------");
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        statement.executeUpdate(query);
    }

    public static void addnewteammember(String TeamID, String UserID) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String query;
        query = "UPDATE user SET team_team_id = '"+ TeamID + "' WHERE userid = '"+ UserID + "'";
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        statement.executeUpdate(query);

    }
    public static boolean update(String id, String name) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String query = "UPDATE team SET team_name = '" + name + "' WHERE team_id = '" + id + "'";
        System.out.println(query);
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MAINDBMUM3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root" );
        statement = connect.createStatement();
        statement.executeUpdate(query);
        return true;
    }

}
