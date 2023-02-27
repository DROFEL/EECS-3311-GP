package com.eecs_3311_team_3.components;

import java.io.IOException;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.controllers.TaskController;
import com.eecs_3311_team_3.data_access.TaskRepository;
import com.eecs_3311_team_3.data_model.Task;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class TaskComponent extends VBox {

    public TaskComponent(String id) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Task.fxml"));
        loader.setRoot(this);

        try {
            loader.load();
            Task task = new TaskRepository().get(id);
            TaskController controller = loader.getController();
            controller.setTask(task);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
