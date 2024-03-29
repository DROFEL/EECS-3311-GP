module com.eecs_3311_team_3 {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires junit;

    opens com.eecs_3311_team_3.controllers to javafx.fxml;
    opens com.eecs_3311_team_3.data_access to org.hibernate.orm.core;
    exports com.eecs_3311_team_3;
    exports com.eecs_3311_team_3.data_model;
    exports com.eecs_3311_team_3.controllers;
    opens com.eecs_3311_team_3 to javafx.fxml;
}
