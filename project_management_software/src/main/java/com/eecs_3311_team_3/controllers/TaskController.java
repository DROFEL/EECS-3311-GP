package com.eecs_3311_team_3.controllers;

import java.io.IOException;

import com.eecs_3311_team_3.App;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class TaskController{
    
    @FXML
    private Label taskLable;
    @FXML
    private Text textDescription;
    @FXML
    private Text status;
    @FXML
    private Text teamName;

    @FXML
    public void initialize() {
        taskLable.setText("Lable_1");
    }

    @FXML
    private void openTaskPage() throws IOException{
        App.setRoot("TaskPage");
    }
}
