package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.components.TaskComponent;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class Project {

    @FXML
    GridPane grid;

    private int taskNum = 0;

    @FXML
    private void addTask() {
        grid.add(new TaskComponent(), (taskNum % 4), (taskNum/4));
        taskNum++;
    }
}