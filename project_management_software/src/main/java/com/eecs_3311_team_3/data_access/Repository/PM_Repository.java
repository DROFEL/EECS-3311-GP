package com.eecs_3311_team_3.data_access.Repository;

import java.util.ArrayList;

public interface PM_Repository<T, U, P> {
    
    /** 
     * @param id Unique Identification number for element <T>
     * @return T that is a object of specified type T
     */
    T get(U id);

    /** 
     * @return returns all objects of specified type T from DB
     */
    ArrayList<T> getAll(P ParentId);

    /** 
     * Adds new object to the DB by specified id
     * @param id Unique Identification number for element <T>
     * @param instance Instance of object of type T
     */
    T add(P ParentId);

    /** 
     * Updates/replaces elemnt by id with provided instance of object with type T
     * @param id Unique Identification number for element <T>
     * @param instance Instance of object of type T
     */
    void update(T instance);

    /** 
     * Removes object with id from DB
     * @param id Unique Identification number for element <T>
     */
    void delete(T instance);
}
