package com.eecs_3311_team_3;

import com.eecs_3311_team_3.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// class for wrapping all the components nessacary for configuring GUI
public class loadGUI {
    private FXMLLoader loader;
    private Stage stage;
    public loadGUI(String fxml){
        loader = new FXMLLoader(App.class.getResource(fxml));
        try {
            Parent root = loader.load();
            stage = new Stage();
            Scene scene = new Scene(root, root.prefWidth(-1), root.prefHeight(-1));     // display with prefwidth/prefheight
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Stage getStage(){ return this.stage;}
    public FXMLLoader getLoader(){
        return this.loader;
    }

    public Object getController(){
        return this.loader.getController();
    }

    public Scene getScene(){
        return this.stage.getScene();
    }

    // after all configurations are done, can then show
    public void show(){
        stage.show();
    }
}
