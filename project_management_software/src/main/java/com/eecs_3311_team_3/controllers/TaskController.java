package com.eecs_3311_team_3.controllers;

import java.io.IOException;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.data_model.Task;

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

    private Task task;

    @FXML
    public void initialize() {
        
    }

    @FXML
    private void openTaskPage() throws IOException{
        App.setRoot("TaskPage");
    }

    public void setTask(Task task){
        this.task = task;
    }
}
