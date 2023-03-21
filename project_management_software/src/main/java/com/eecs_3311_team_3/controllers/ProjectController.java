package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.QuickDisplay;
import com.eecs_3311_team_3.components.TaskComponent;
import com.eecs_3311_team_3.data_access.TaskRepository;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import static javafx.application.Application.launch;

public class ProjectController {

    @FXML
    GridPane grid;

    private int taskNum = 0;

    public static Project project;

    public ProjectController(){
        System.out.println("XD");
    }

//    @Override
//    public void initialize(URL arg0, ResourceBundle arg1) {
//        ProjectRepository repo = new ProjectRepository();
//        project = repo.get(project.getProjectId());
//        for (Task task : project.getTasks()){
//            grid.add(new TaskComponent(task), (taskNum % 4), (taskNum/4));
//            taskNum++;
//        }
//    }

    @FXML
    public void addTask(){
        TaskRepository repo = new TaskRepository();
        Task task = repo.add(project.getProjectId());
        task.setName(Integer.toString(taskNum));
        grid.add(new TaskComponent(task), (taskNum % 4), (taskNum/4));
        taskNum++;

        repo.update(task);
    }

    public void promptEdit(){}

    public static void main (String[] args){
        QuickDisplay.show("Project.fxml");
    }
}