package com.eecs_3311_team_3;

public class DBController {
    
    private DBController controller;

    public DBController getInstance(){
        if(controller == null)
            controller = new DBController();

        return controller;
    }
}
