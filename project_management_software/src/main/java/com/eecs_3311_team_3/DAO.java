package com.eecs_3311_team_3;

public class DAO {

    private static DAO dao = null;

    private DAO(){
    }

    public static DAO getInstance(){
        if(dao == null) {
            dao = new DAO();
        }
        return dao;
    }
}
