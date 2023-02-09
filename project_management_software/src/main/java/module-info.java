module com.eecs_3311_team_3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.eecs_3311_team_3 to javafx.fxml;
    exports com.eecs_3311_team_3;
}
