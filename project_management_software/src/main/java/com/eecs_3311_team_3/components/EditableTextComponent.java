package com.eecs_3311_team_3.components;

import java.io.IOException;

import com.eecs_3311_team_3.App;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class EditableTextComponent extends Pane {
    public EditableTextComponent(@NamedArg("fontSize") int fontSize){

        FXMLLoader loader = new FXMLLoader(App.class.getResource("Task.fxml"));
        loader.setRoot(this);

        try {
            loader.load();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
