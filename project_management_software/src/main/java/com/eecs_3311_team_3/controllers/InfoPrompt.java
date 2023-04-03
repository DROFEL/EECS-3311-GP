package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.data_access.DAO.DAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.hibernate.tool.schema.Action;

// info prompt is for GUI for showing some text prompt
// i kept it as general as possible, as different controllers may need different functionalities out of this
public class InfoPrompt {
    @FXML Text title, desc;
    @FXML TextField title_field;
    @FXML TextArea desc_field;
    @FXML Button submit;

    public InfoPrompt(){};
    public void setTopic(String topic){                        // placeholder values would be replaced by topic
        String prompt = String.format("New %s Name:", topic);
        String desc = String.format("%s description:", topic);

        title.setText(prompt);
        this.desc.setText(desc);
    }


}
