package com.eecs_3311_team_3.data_access.daos;

import java.util.ArrayList;
import java.util.Optional;

import com.eecs_3311_team_3.data_access.DBController;

/**
 * DAO.java
 * Interface class that is used for DAO pattern implementation.
 * 
 * @author George
 * @since Feb 17 2023
 */
public abstract class DAO<T> {

    DBController controller;

    public DAO(){
        controller = DBController.getInstance();
    }

    public DBController getController() {
        return controller;
    }

    public abstract T get(int id);

    public abstract ArrayList<T> getAll(int ParentId);

    public abstract void save(T t);

    public abstract void update(T t);

    public abstract void delete(T t);
}
