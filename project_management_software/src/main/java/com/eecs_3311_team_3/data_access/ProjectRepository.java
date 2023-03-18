package com.eecs_3311_team_3.data_access;

import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.DAO.ProjectDAO;
import com.eecs_3311_team_3.data_access.DAO.TaskDAO;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

public class ProjectRepository implements PM_Repository<Project, Integer, String> {

    ProjectDAO projectDAO;
    TaskDAO taskDAO; 


    public ProjectRepository(){
        projectDAO = new ProjectDAO();
        taskDAO = new TaskDAO();
    }

    @Override
    public Project get(Integer id) {
        Project project = projectDAO.get(id);
        project.initTasks(taskDAO.getAll(project.getProjectId()));
        return project;
    }

    @Override
    public ArrayList<Project> getAll(String ParentId) {
        ArrayList<Project> projects = projectDAO.getAll(ParentId);
        for (Project project : projects) {
            project.initTasks(taskDAO.getAll(project.getProjectId()));
        }
        return projects;
    }

    @Override
    public Project add(String ParentId) {
        return projectDAO.create(ParentId);
    }

    @Override
    public void update(Project instance) {
        projectDAO.update(instance);
        for (Task i : instance.getTasks()) {
            taskDAO.update(i);
        }
    }

    @Override
    public void delete(Project instance) {
        for (Task t : instance.getTasks()) {
            taskDAO.delete(t);
        }
        projectDAO.delete(instance);
    }
    
}
