package com.eecs_3311_team_3.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.data_model.Project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ProjectEntityController implements Initializable {
    @FXML
    private Label projectLabel;
    
    private Project project;
    
    @FXML
    private void openProject() throws IOException {
        App.setRoot("Project");
    }

    public void setProject(Project project){
        projectLabel.setText(project.getProjectname());
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        projectLabel.setText("aboba");
    }
}
