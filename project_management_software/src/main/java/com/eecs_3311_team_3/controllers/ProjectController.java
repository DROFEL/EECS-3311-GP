package com.eecs_3311_team_3.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.eecs_3311_team_3.App;
import com.eecs_3311_team_3.CacheSinglenton;
import com.eecs_3311_team_3.components.TaskComponent;
import com.eecs_3311_team_3.data_access.Repository.ProjectRepository;
import com.eecs_3311_team_3.data_access.Repository.TaskRepository;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

import com.eecs_3311_team_3.LoadGUI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;

import static javafx.application.Application.launch;

public class ProjectController implements Initializable {

    @FXML
    GridPane grid;
    @FXML
    Label projectLabel;
    @FXML
    Button newTaskButton;

    private int taskNum = 4;

    public static Project project;

    public ProjectController(){
        System.out.println("Project View Opened");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectRepository repo = new ProjectRepository();
        TaskRepository taskRepo = new TaskRepository();
        projectLabel.setText(project.projectName);
        project = repo.get(CacheSinglenton.projectID);
        System.out.println(project.projectID);
        for (Task task : taskRepo.getAll(project.projectID)){
            grid.add(new TaskComponent(task), taskNum%4, taskNum/4);
            taskNum++;
        }
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
        LoadGUI gui = initPrompt();
        InfoPrompt prompt = (InfoPrompt) gui.getController();
        prompt.setTopic("Project");

        prompt.submit.setOnAction((event) -> {
            projectLabel.setText(prompt.title_field.getText());
            project.projectName = prompt.title_field.getText();

            ProjectRepository repo = new ProjectRepository();
            repo.update(project);

            System.out.println("add project instance to DB");
            gui.getStage().close();
        });
        gui.show();
    }

    public void promptTask(){
        System.out.println("Task prompt opened");
        LoadGUI gui = initPrompt();
        InfoPrompt prompt = (InfoPrompt) gui.getController();
        prompt.setTopic("Task");

        prompt.submit.setOnAction((event) -> {
            System.out.println("add new task to db");
            TaskRepository repo = new TaskRepository();
            Task task = repo.add(CacheSinglenton.projectID);
            task.setName(prompt.title_field.getText());
            task.setDescription(prompt.desc_field.getText());
            grid.add(new TaskComponent(task), (taskNum % 4), (taskNum/4));
            taskNum++;

            repo.update(task);
            gui.getStage().close();
        });
        gui.show();
    }

    public void exitProject() throws IOException {
        App.setRoot("ProjectBrowser");
    }

    public LoadGUI initPrompt(){
        LoadGUI gui = new LoadGUI("good/infoPrompt.fxml");
        gui.getStage().initModality(Modality.APPLICATION_MODAL);
        return gui;
    }




}