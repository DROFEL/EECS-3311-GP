package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.components.TaskComponent;
import com.eecs_3311_team_3.data_access.TaskRepository;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

import com.eecs_3311_team_3.loadGUI;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class ProjectController {

    @FXML
    GridPane grid;

    private int taskNum = 0;

    public static Project project;

    public ProjectController(){
        System.out.println("Project View Opened");
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

    // pops open a prompt to enter info about project
    public void promptEdit(){
        loadGUI xd = new loadGUI("good/infoPrompt.fxml");
        Stage stage = xd.getStage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOnCloseRequest(event -> {
            event.
        });
        InfoPrompt xd1 = xd.getLoader().getController();
        xd1.setTopic("Project");
//        xd1.setDAO(new ProjectDAO());
        xd.show();
    }



}