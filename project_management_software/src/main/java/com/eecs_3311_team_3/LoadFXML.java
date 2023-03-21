package com.eecs_3311_team_3;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

// for some odd reason can only load FXMLLoader only works for classes in the base package
public class LoadFXML {
    public static Parent load(String fxml){
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
