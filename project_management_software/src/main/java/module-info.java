module com.eecs_3311_team_3 {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.eecs_3311_team_3.controllers to javafx.fxml;
    exports com.eecs_3311_team_3;
    exports com.eecs_3311_team_3.data_model;
    exports com.eecs_3311_team_3.controllers;
}
