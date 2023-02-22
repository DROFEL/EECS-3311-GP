package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.components.TaskComponent;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class Project {

    @FXML
    GridPane grid;

    private int taskNum = 0;

    private com.eecs_3311_team_3.data_model.Project project;

    @FXML
    private void addTask() {
        grid.add(new TaskComponent(Integer.toString(taskNum)), (taskNum % 4), (taskNum/4));
        taskNum++;
    }
}