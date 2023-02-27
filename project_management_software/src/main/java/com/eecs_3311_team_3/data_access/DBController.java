package com.eecs_3311_team_3.data_access;

import java.sql.*;

public class DBController {
    
    private static String address;
    private static Connection connection;
    private static Statement command;
    private static ResultSet data;


    private DBController controller;

    public DBController(String address, String user, String password) {
        try{
            connection = DriverManager.getConnection(address, user, password);
            command =  connection.createStatement();
            controller = this;
            data = command.executeQuery("SELECT * FROM tasks");
            data.next();
            System.out.println(data.getString("ID"));
            data.next();
            System.out.println(data.getString("ID"));
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public DBController getInstance(){
        if(controller == null){
            System.out.print("DB connection is not instanciated");
            return null;
        }
        else
            return controller;
    }

    public static void execute(String query){
        try{
            command.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
