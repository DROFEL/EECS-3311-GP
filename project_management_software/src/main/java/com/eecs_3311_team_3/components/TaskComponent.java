package com.eecs_3311_team_3.components;

import java.io.IOException;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.controllers.TaskController;
import com.eecs_3311_team_3.data_model.Task;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class TaskComponent extends VBox {

    public TaskComponent(Task task) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Task.fxml"));
        loader.setRoot(this);

        try {
            loader.load();
            TaskController controller = loader.getController();
            controller.setTask(task);
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
