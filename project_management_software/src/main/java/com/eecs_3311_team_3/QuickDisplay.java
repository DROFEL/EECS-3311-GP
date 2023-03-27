package com.eecs_3311_team_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.eecs_3311_team_3.LoadFXML.load;

// for displaying some secondary GUI once app has started
// for mainly testing
public class QuickDisplay  {

    public static void show(String fxml){
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root, root.prefWidth(-1), root.prefHeight(-1));     // display with prefwidth/prefheight
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
