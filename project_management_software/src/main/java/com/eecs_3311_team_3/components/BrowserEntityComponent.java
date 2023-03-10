package com.eecs_3311_team_3.components;

import java.io.IOException;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.controllers.ProjectEntityController;
import com.eecs_3311_team_3.data_model.Project;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class BrowserEntityComponent extends Pane {

    public BrowserEntityComponent(Project p) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("BrowserEntity.fxml"));
        loader.setRoot(this);

        try {
            loader.load();
            ProjectEntityController controller = loader.getController();
            controller.setProject(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
