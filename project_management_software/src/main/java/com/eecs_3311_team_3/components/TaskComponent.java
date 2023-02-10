package com.eecs_3311_team_3.components;

import java.io.IOException;

import com.eecs_3311_team_3.App;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class TaskComponent extends VBox {
    
    public TaskComponent(){
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Task.fxml"));
        loader.setRoot(this);

        try {
            loader.load();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
