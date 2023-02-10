package com.eecs_3311_team_3.controllers;

import java.io.IOException;
import com.eecs_3311_team_3.App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ProjectBrowser {

    @FXML
    private VBox projectsList;
    @FXML
    private void createProject() throws IOException {
        Pane projectEntity =  FXMLLoader.load(App.class.getResource("BrowserEntity.fxml"));
        projectsList.getChildren().add(projectEntity);
    }
}
