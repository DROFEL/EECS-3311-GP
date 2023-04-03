package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.DatabaseConnection;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.sql.*;
import javafx.scene.control.Alert.AlertType;

public class LoginController {

	// values are dyamically injected as they change
	// initalize() vs constructor() https://stackoverflow.com/questions/34785417/javafx-fxml-controller-constructor-vs-initialize-method
    @FXML private Label title;
    
    @FXML private Label loginMessageLabel;
    
    @FXML private TextField usernameTextField;
    
    @FXML private PasswordField passwordPasswordField;

	// "The initialize method is called after all @FXML annotated members have been injected."


    @FXML
    private void login(ActionEvent e){
		System.out.println("login attempted");
        if (!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {		// valid login
        	validateLogin();
        } else {		// notify user
        	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Enter the username/password!");// line 3
			alert.setContentText("You must fill out both fields");// line 4
			alert.showAndWait(); // line 5
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
