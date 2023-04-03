package com.eecs_3311_team_3.data_access.Repository;

import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.DAO.ProjectDAO;
import com.eecs_3311_team_3.data_access.DAO.TaskDAO;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

public class ProjectRepository implements PM_Repository<Project, Integer, Integer> {


    @Override
    public Project get(Integer id) {

        ProjectDAO dao = new ProjectDAO();
        Project result = dao.get(id);
        dao.close();
        return result;

    }

    @Override
    public ArrayList<Project> getAll(Integer ParentId) {

        ProjectDAO dao = new ProjectDAO();
        ArrayList<Project> result = dao.getAll(ParentId);
        dao.close();
        return result;

    }

    @Override
    public Project add(Integer ParentId) {
        ProjectDAO dao = new ProjectDAO();
        Project result = dao.create(ParentId);
        dao.close();
        return result;
    }

    @Override
    public void update(Project instance) {
        ProjectDAO dao = new ProjectDAO();
        dao.update(instance);
        dao.close();
    }

    @Override
    public void delete(Project instance) {

        ProjectDAO dao = new ProjectDAO();
        dao.delete(instance);
        dao.close();
    }

}
