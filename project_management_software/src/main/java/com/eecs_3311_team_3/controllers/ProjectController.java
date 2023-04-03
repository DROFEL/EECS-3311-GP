package com.eecs_3311_team_3.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.eecs_3311_team_3.components.TaskComponent;
import com.eecs_3311_team_3.data_access.Repository.ProjectRepository;
import com.eecs_3311_team_3.data_access.Repository.TaskRepository;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

import com.eecs_3311_team_3.loadGUI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class ProjectController implements Initializable {

    @FXML
    GridPane grid;
    @FXML
    Label projectLabel;
    @FXML
    Button newTaskButton;

    private int taskNum = 0;

    public static Project project;

    public ProjectController(){
        System.out.println("Project View Opened");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectRepository repo = new ProjectRepository();
        projectLabel.setText(project.projectName);
//        project = repo.get(project.getProjectId());
//        for (Task task : project.getTasks()){
//            grid.add(new TaskComponent(task), (taskNum % 4), (taskNum/4));
//            ta    skNum++;
//        }
    }

    public void addTask(){
        TaskRepository repo = new TaskRepository();
        Task task = repo.add(project.projectID);
        task.setName(Integer.toString(taskNum));
        grid.add(new TaskComponent(task), (taskNum % 4), (taskNum/4));
        taskNum++;

        repo.update(task);
    }

    // pops open a prompt to enter info about project
    public void promptEdit(){
        System.out.println("Project prompt opened");
        System.out.println(projectLabel.getText());
        loadGUI gui = initPrompt();
        InfoPrompt prompt = (InfoPrompt) gui.getController();

        prompt.setTopic("Project");
        prompt.submit.setOnAction((event) -> {
            projectLabel.setText(prompt.title_field.getText());
            System.out.println("add project instance to DB");
            gui.getStage().close();
        });
        gui.show();
    }

    public void promptTask(){
        System.out.println("Task prompt opened");
        loadGUI taskPopup = initPrompt();
        InfoPrompt prompt = (InfoPrompt) taskPopup.getController();
        prompt.setTopic("Task");
        prompt.submit.setOnAction((event) -> {
            System.out.println("add new task to db");
            // show task on GUI on gridpane
            taskPopup.getStage().close();
        });
    }

    public loadGUI initPrompt(){
        loadGUI gui = new loadGUI("good/infoPrompt.fxml");
        gui.getStage().initModality(Modality.APPLICATION_MODAL);
        return gui;
    }




}