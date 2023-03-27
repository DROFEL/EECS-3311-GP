package com.eecs_3311_team_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLOutput;

import com.eecs_3311_team_3.data_access.DBController;
import com.eecs_3311_team_3.data_model.Task;

import static com.eecs_3311_team_3.LoadFXML.load;

/**
 * JavaFX App
 */
// TODO: enable back build of this class later, just for quick ui launch times
public class App extends Application {

    private static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(load("Project.fxml"), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(load(fxml));
    }


    public static void main(String[] args) {
        launch();
    }

}