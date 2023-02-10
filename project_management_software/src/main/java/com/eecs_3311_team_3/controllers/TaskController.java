package com.eecs_3311_team_3.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
}
