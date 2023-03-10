package com.eecs_3311_team_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.ArrayList;
import com.eecs_3311_team_3.data_access.DBController;
import com.eecs_3311_team_3.data_access.ProjectRepository;
import com.eecs_3311_team_3.data_access.TaskRepository;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("ProjectBrowser"), 1280, 720);
        stage.setScene(scene);
        stage.show();
        new DBController("jdbc:mysql://0.0.0.0:3306/PMS", "root", "1234");

        TaskRepository taskDAO = new TaskRepository();
        Task task = taskDAO.get(1);
        if(task == null)
            System.out.println("null :(");
        else
            System.out.println(task.getName());
        task.setName("new name");
        taskDAO.add(task);
        // task = taskDAO.get(2);

        if(task == null)
            System.out.println("null :(");
        else
            System.out.println(task.getName());
        task.setName("Haha");
        ProjectRepository dao = new ProjectRepository();
        Project project = dao.get(1);
        ArrayList<Task> tasks = project.getTasks();
        System.out.println(" Tasks 1 "+tasks.get(0).getName());
        tasks.set(0, task);
        dao.add(project);
        project = dao.get(1);
        tasks = project.getTasks();
        System.out.println(" Tasks 2 "+tasks.get(0).getName());

    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}