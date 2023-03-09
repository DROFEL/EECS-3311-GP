package com.eecs_3311_team_3.data_access;

import java.sql.*;

public class DBController {
    private static Connection connection;
    private static Statement command;
    private static DBController controller;

    public DBController(String address, String user, String password) {
        try{
            connection = DriverManager.getConnection(address, user, password);
            command =  connection.createStatement();
            controller = this;
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBController getInstance(){
        if(controller == null){
            System.out.print("DB connection is not instanciated");
            return null;
        }
        else
            return controller;
    }

    public static ResultSet executeGet(String query){
        try{
            return command.executeQuery(query);
        } catch(SQLException e) {
            System.out.println("in DBController.executionGet()");
            e.printStackTrace();
        }

        return null;
    }

    public static void executeSet(String query){
        try{
            command.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
