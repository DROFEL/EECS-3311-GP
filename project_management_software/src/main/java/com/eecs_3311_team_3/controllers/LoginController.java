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
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
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
