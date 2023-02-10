package com.eecs_3311_team_3.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.eecs_3311_team_3.*;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
