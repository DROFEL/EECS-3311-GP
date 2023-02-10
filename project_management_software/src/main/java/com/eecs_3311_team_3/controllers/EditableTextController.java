package com.eecs_3311_team_3.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class EditableTextController {
    private boolean bEditing = false;
    @FXML
    private Text text;
    @FXML
    private TextField field;
    @FXML
    private Button button;
    
    
    @FXML
    private void switchState(){
        if(bEditing){
            field.setDisable(true);
            text.setDisable(false);
            field.setVisible(false);
            text.setVisible(true);
            text.setText(field.getText());

            button.setText("Edit");
            bEditing = !bEditing;
        } else {
            field.setDisable(false);
            text.setDisable(true);
            field.setVisible(true);
            text.setVisible(false);
            field.setText(text.getText());

            button.setText("Save");
            bEditing = !bEditing;
        }
    }
}
