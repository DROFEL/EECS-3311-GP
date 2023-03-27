package com.eecs_3311_team_3.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.eecs_3311_team_3.components.TaskComponent;
import com.eecs_3311_team_3.data_access.Repository.ProjectRepository;
import com.eecs_3311_team_3.data_access.Repository.TaskRepository;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

public class ProjectController implements Initializable {

    @FXML
    GridPane grid;

    private int taskNum = 0;

    public static Project project;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectRepository repo = new ProjectRepository();
        project = repo.get(project.projectID);
//        for (Task task : project.getTasks()){
//            grid.add(new TaskComponent(task), (taskNum % 4), (taskNum/4));
//            taskNum++;
//        }
    }

    @FXML
    public void addTask(){
        TaskRepository repo = new TaskRepository();
        Task task = repo.add(project.projectID);
        task.setName(Integer.toString(taskNum));
        grid.add(new TaskComponent(task), (taskNum % 4), (taskNum/4));
        taskNum++;

        repo.update(task);
    }
}