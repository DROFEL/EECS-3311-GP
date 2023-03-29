package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.data_access.DAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

// info prompt is for GUI for editing some entry in the table
public abstract class InfoPrompt {
    @FXML Text promptName, descName;
    @FXML TextField prompt;
    @FXML TextArea desc;

    public InfoPrompt(){};

    public void setTopic(String topic){                        // placeholder values would be replaced by topic
        String prompt = String.format("New %s Name:", topic);
        String desc = String.format("%s description:", topic);

        promptName.setText(prompt);
        descName.setText(desc);
    }

    public String getPrompt(){

    }

    // functional interface: if u want to add some functionality when button clicked
    public void submit(PromptAction e){
        e.handle();
    }
}
