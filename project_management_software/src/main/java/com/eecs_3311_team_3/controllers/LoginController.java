package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.App;

import com.eecs_3311_team_3.CacheSinglenton;
import com.eecs_3311_team_3.LoadGUI;
import com.eecs_3311_team_3.data_access.Repository.ProjectRepository;
import com.eecs_3311_team_3.data_access.Repository.UserRepository;
import com.eecs_3311_team_3.data_model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import java.io.IOException;

import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;

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

    @FXML
    private void signup(ActionEvent e){
        System.out.println("signup attempted");

        LoadGUI gui = initPrompt();
        CreateNewAccountPromptController prompt = (CreateNewAccountPromptController) gui.getController();

        prompt.submit.setOnAction((event) -> {
            UserRepository repo = new UserRepository();
            User user = repo.add(prompt.username.getText());
            user.password = prompt.password.getText();
            repo.update(user);

            gui.getStage().close();
        });
        gui.show();

    }

    public LoadGUI initPrompt(){
        LoadGUI gui = new LoadGUI("good/RegisterPrompt.fxml");
        gui.getStage().initModality(Modality.APPLICATION_MODAL);
        return gui;
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
                    CacheSinglenton.userID = user.userID;
                    App.setRoot("ProjectBrowser");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
