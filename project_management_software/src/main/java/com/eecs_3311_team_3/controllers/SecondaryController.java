package com.eecs_3311_team_3.controllers;

import com.eecs_3311_team_3.*;
import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}