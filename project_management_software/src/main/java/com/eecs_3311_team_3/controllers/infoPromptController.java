package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.data_access.DAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

// info prompt is for GUI for editing some entry in the table
public class infoPromptController {
    @FXML Text promptName, descName;
    @FXML TextField prompt;
    @FXML TextArea desc;
    DAO dao;

    public infoPromptController(){};


    public void setDAO(DAO table){
        this.dao = table;
    }

    public void setTopic(String topic){                        // placeholder values would be replaced by topic
        String prompt = String.format("New %s Name:", topic);
        String desc = String.format("%s description:", topic);

        promptName.setText(prompt);
        descName.setText(desc);
    }


    // add task/project/topic  to database
    public void submit(){
        System.out.println("subbmited");
//        dao.create("desc/prompt");
    }
}
