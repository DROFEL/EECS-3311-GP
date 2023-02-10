module com.eecs_3311_team_3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.eecs_3311_team_3.controllers to javafx.fxml;
    exports com.eecs_3311_team_3;
    exports com.eecs_3311_team_3.controllers;
}
