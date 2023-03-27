package com.eecs_3311_team_3;

import java.sql.*;

public class DatabaseConnection {
	public Connection databaseLink;
	
	public Connection getConnection() {
		String databaseName = "PMS";
		String databaseUser = "root";
		String databasePassword = "1234";
		String url = "jdbc:mysql://localhost/" + databaseName;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return databaseLink;
	}
}
