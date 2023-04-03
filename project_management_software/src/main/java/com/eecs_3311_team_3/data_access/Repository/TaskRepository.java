package com.eecs_3311_team_3.data_access.Repository;

import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.DAO.TaskDAO;
import com.eecs_3311_team_3.data_model.Task;

public class TaskRepository implements PM_Repository<Task, Integer, Integer> {

    @Override
    public Task get(Integer id){
        TaskDAO dao = new TaskDAO();
        Task result = dao.get(id);
        dao.close();
        return result;
    }

    @Override 
    public ArrayList<Task> getAll(Integer ParentId){
        TaskDAO dao = new TaskDAO();
        ArrayList<Task> result = dao.getAll(ParentId);
        dao.close();
        return result;
    }

    
    @Override
    public Task add(Integer ParentId){
        TaskDAO dao = new TaskDAO();
        Task result = dao.create(ParentId);
        dao.close();
        return result;
    }

    @Override
    public void update(Task task) {
        TaskDAO dao = new TaskDAO();
        dao.update(task);
        dao.close();
    }

    @Override
    public void delete(Task task){
        TaskDAO dao = new TaskDAO();
        dao.delete(task);
        dao.close();
    }

}
