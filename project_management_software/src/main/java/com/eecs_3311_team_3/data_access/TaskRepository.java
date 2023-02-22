package com.eecs_3311_team_3.data_access;

import java.util.ArrayList;

import com.eecs_3311_team_3.data_model.Task;

public class TaskRepository implements PM_Repository<Task> {
    
    @Override
    public Task get(String id){
        return new Task();
    }

    @Override 
    public ArrayList<Task> getAll(){
        return new ArrayList<Task>();
    }

    
    @Override
    public void add(String id,Task task){

    }

    @Override
    public void update(String id, Task task) {

    }

    @Override
    public void delete(String id){

    }

}
