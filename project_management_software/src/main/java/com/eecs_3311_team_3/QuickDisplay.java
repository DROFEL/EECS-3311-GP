package com.eecs_3311_team_3;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.eecs_3311_team_3.LoadFXML.load;

// for testing purposes
public class QuickDisplay extends Application {

    static String FXML;

    @Override
    public void start(Stage stage) throws Exception {
        // testing purposes
        Stage stage1 = new Stage();
        Parent root = load(FXML);
        Scene scene = new Scene(root, root.prefWidth(-1), root.prefHeight(-1));     // display with prefwidth/prefheight

        stage1.setScene(scene);
        stage1.show();
    }
    public static void show(String fxml){
        FXML = fxml;
        launch();
    }
}
