package com.eecs_3311_team_3.DAO;

import java.util.ArrayList;

/**
 * DAO.java
 * Interface class that is used for DAO pattern implementation.
 * 
 * @author George
 * @since Feb 17 2023
 */
public interface DAO<T> {

    /** 
     * @param id Unique Identification number for element <T>
     * @return T that is a object of specified type T
     */
    T get(String id);

    /** 
     * @return returns all objects of specified type T
     */
    ArrayList<T> getAll();

    /** 
     * 
     * @return returns all objects of specified type T
     */
    void add(T t);

    void update(String id, T t);

    void delete(T t);
}
