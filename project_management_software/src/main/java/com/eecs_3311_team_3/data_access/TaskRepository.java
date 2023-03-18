package com.eecs_3311_team_3.data_access;

import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.DAO.TaskDAO;
import com.eecs_3311_team_3.data_model.Task;

public class TaskRepository implements PM_Repository<Task, Integer, Integer> {
    
    TaskDAO dao;

    public TaskRepository(){
        dao = new TaskDAO();
    }

    @Override
    public Task get(Integer id){
        return dao.get(id);
    }

    @Override 
    public ArrayList<Task> getAll(Integer ParentId){
        return dao.getAll(ParentId);
    }

    
    @Override
    public Task add(Integer ParentId){
        return dao.create(ParentId);
    }

    @Override
    public void update(Task task) {
        dao.update(task);
    }

    @Override
    public void delete(Task task){
        dao.delete(task);
    }

}
