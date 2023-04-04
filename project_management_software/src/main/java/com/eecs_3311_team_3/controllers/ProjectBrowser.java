package com.eecs_3311_team_3.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.CacheSinglenton;
import com.eecs_3311_team_3.LoadGUI;
import com.eecs_3311_team_3.components.BrowserEntityComponent;
import com.eecs_3311_team_3.data_access.Repository.ProjectRepository;
import com.eecs_3311_team_3.data_model.Project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

public class ProjectBrowser implements Initializable {

    @FXML
    private VBox projectsList;

    @FXML
    private void createProject() throws IOException
    {
        LoadGUI gui = initPrompt();
        InfoPrompt prompt = (InfoPrompt) gui.getController();
        prompt.setTopic("New Project");

        prompt.submit.setOnAction((event) -> {
            ProjectRepository repo = new ProjectRepository();
            Project pr = repo.add(CacheSinglenton.userID);
            System.out.println(pr.projectID);

            pr.projectName = prompt.title_field.getText();
            pr.projectDescription = prompt.desc_field.getText();
            gui.getStage().close();

            System.out.println(pr.projectID);
            repo.update(pr);

            BrowserEntityComponent cp = new BrowserEntityComponent(pr);
            projectsList.getChildren().add(cp);
        });

        gui.show();
    }

    @FXML
    private void logout() throws IOException {
        App.setRoot("good/Login");
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectRepository repo = new ProjectRepository();
        ArrayList<Project> projects = repo.getAll(CacheSinglenton.userID);
        System.out.println(projects.size());
        for (Project project : projects) {
            BrowserEntityComponent cp = new BrowserEntityComponent(project);
            projectsList.getChildren().add(cp);

//            Pane projectEntity =  new BrowserEntityComponent(project);
//            projectsList.getChildren().add(projectEntity);
        }
    }

    public LoadGUI initPrompt() {
        LoadGUI gui = new LoadGUI("good/infoPrompt.fxml");
        gui.getStage().initModality(Modality.APPLICATION_MODAL);
        return gui;
    }
}
