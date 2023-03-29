package com.eecs_3311_team_3.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.eecs_3311_team_3.components.BrowserEntityComponent;
import com.eecs_3311_team_3.data_access.Repository.ProjectRepository;
import com.eecs_3311_team_3.data_model.Project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ProjectBrowser implements Initializable{

    @FXML
    private VBox projectsList;

    @FXML
    private void createProject() throws IOException {
        // Pane projectEntity =  FXMLLoader.load(App.class.getResource("BrowserEntity.fxml"));
        // projectsList.getChildren().add(projectEntity);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectRepository repo = new ProjectRepository();
        ArrayList<Project> projects = repo.getAll(1);
        System.out.println(repo.get(1));
        for (Project project : projects) {
            Pane projectEntity =  new BrowserEntityComponent(project);
            projectsList.getChildren().add(projectEntity);
        }
    }
}
