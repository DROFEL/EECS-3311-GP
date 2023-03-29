package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.DatabaseConnection;

import com.eecs_3311_team_3.data_access.Repository.UserRepository;
import com.eecs_3311_team_3.data_model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import java.io.IOException;
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

		UserRepository repo = new UserRepository();
		User user = repo.get(usernameTextField.getText());
		if(user == null) {
            loginMessageLabel.setText("Invalid login attempt");
        } else {
            if(user.password.equals(passwordPasswordField.getText()) ){
                loginMessageLabel.setText("Login accepted");
                try {
                    App.setRoot("Project");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
