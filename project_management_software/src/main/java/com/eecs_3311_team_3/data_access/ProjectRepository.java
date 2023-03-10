package com.eecs_3311_team_3.data_access;

import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.daos.ProjectDAO;
import com.eecs_3311_team_3.data_access.daos.TaskDAO;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

public class ProjectRepository implements PM_Repository<Project> {

    ProjectDAO projectDAO;
    TaskDAO taskDAO; 


    public ProjectRepository(){
        projectDAO = new ProjectDAO();
        taskDAO = new TaskDAO();
    }

    @Override
    public Project get(int id) {
        Project project = projectDAO.get(id);
        project.initTasks(taskDAO.getAll(project.getProjectId()));
        return project;
    }

    @Override
    public ArrayList<Project> getAll() {
        ArrayList<Project> projects = projectDAO.getAll(0);
        for (Project project : projects) {
            project.initTasks(taskDAO.getAll(project.getProjectId()));
        }
        return projects;
    }

    @Override
    public void add(Project instance) {
        projectDAO.save(instance);
        for (Task i : instance.getTasks()) {
            taskDAO.update(i);
        }
    }

    @Override
    public void update(Project instance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Project instance) {
        projectDAO.delete(instance);
    }
    
}
