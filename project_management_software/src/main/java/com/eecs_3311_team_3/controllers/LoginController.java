package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.DatabaseConnection;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.sql.*;

public class LoginController {

    @FXML
    private Button loginButton;
    
    @FXML 
    private Label loginMessageLabel;
    
    @FXML
    private TextField usernameTextField;
    
    @FXML
    private PasswordField passwordPasswordField;
    
    @FXML
    private void login(ActionEvent e){
        if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
        	//loginMessageLabel.setText("Login attempted");
        	validateLogin();
        } else {
        	loginMessageLabel.setText("Please enter a username and password");
        }
    }
    
    public void validateLogin() {
    	DatabaseConnection connectNow = new DatabaseConnection();
    	Connection connectDB = connectNow.getConnection();
    	
    	String verifyLogin = "SELECT count(1) FROM UserAccounts WHERE username = '" + usernameTextField.getText() + "' AND _password = '" + passwordPasswordField.getText() + "'";
    	
    	try {
    		Statement statement = connectDB.createStatement();
    		ResultSet queryResult = statement.executeQuery(verifyLogin);
    		
    		System.out.println(queryResult.toString());
    		
    		while(queryResult.next()) {
    			if (queryResult.getInt(1) == 1) {
    				loginMessageLabel.setText("Login accepted");
    			} else {
    				loginMessageLabel.setText("Invalid login attempt");
    			}
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
