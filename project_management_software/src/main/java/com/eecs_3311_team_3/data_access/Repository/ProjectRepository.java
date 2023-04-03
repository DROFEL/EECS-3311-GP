package com.eecs_3311_team_3.data_access.Repository;

import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.DAO.ProjectDAO;
import com.eecs_3311_team_3.data_access.DAO.TaskDAO;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

public class ProjectRepository implements PM_Repository<Project, Integer, Integer> {

    ProjectDAO projectDAO;
    TaskDAO taskDAO; 


    public ProjectRepository(){
        projectDAO = new ProjectDAO();
        taskDAO = new TaskDAO();
    }

    @Override
    public Project get(Integer id) {
        Project project = projectDAO.get(id);
        project.setTaskList(taskDAO.getAll(project.projectID));
        return project;
    }

    @Override
    public ArrayList<Project> getAll(Integer ParentId) {
        ArrayList<Project> projects = projectDAO.getAll(ParentId);
        for (Project project : projects) {
            project.setTaskList(taskDAO.getAll(project.projectID));
        }
        return projects;
    }

    @Override
    public Project add(Integer ParentId) {
        return projectDAO.create(ParentId);
    }

    @Override
    public void update(Project instance) {
        projectDAO.update(instance);
        for (Task i : instance.getTaskList()) {
            taskDAO.update(i);
        }
    }

    @Override
    public void delete(Project instance) {
        for (Task t : instance.getTaskList()) {
            taskDAO.delete(t);
        }
        projectDAO.delete(instance);
    }

}
