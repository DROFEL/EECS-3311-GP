package com.eecs_3311_team_3.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CreateNewAccountPromptController {

    @FXML
    TextField username, password;
    @FXML
    Button submit;

    public void setTopic(String topic){                        // placeholder values would be replaced by topic
        String prompt = String.format("%s Name:", topic);
        String desc = String.format("%s description:", topic);
    }

}
