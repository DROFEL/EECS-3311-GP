package com.eecs_3311_team_3.data_access;

import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.daos.TaskDAO;
import com.eecs_3311_team_3.data_model.Task;

public class TaskRepository implements PM_Repository<Task> {
    
    TaskDAO dao;

    public TaskRepository(){
        dao = new TaskDAO();
    }

    @Override
    public Task get(int id){
        return dao.get(id);
    }

    @Override 
    public ArrayList<Task> getAll(){
        return new ArrayList<Task>();
    }

    
    @Override
    public void add(Task task){
        dao.save(task);
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(Task task){

    }

}
