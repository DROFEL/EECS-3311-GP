package com.eecs_3311_team_3.DAO;

import java.util.ArrayList;

import com.eecs_3311_team_3.data_model.Task;

public class DAO_Task implements DAO<Task> {
    
    
    /** 
     * @param id
     * @return Task
     */
    @Override
    public Task get(String id){
        return new Task();
    }

    
    /** 
     * @return ArrayList<Task>
     */
    @Override 
    public ArrayList<Task> getAll(){
        return new ArrayList<Task>();
    }

    
    /** 
     * @param task
     */
    @Override
    public void add(Task task){

    }

    
    /** 
     * @param id
     * @param task
     */
    @Override
    public void update(String id, Task task) {

    }

    
    /** 
     * @param task
     */
    @Override
    public void delete(Task task){

    }

}
