package com.eecs_3311_team_3.data_access.daos;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.DBController;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

public class ProjectDAO extends DAO<Project> {

    private TaskDAO taskDAO;

    public ProjectDAO() {
        super();
        this.taskDAO = new TaskDAO();
    }

    @Override
    public Project get(int id) {
        try {
            ResultSet result = this.getController().executeGet(String.format("select * from PROJECT where projectID = %d;", id));
            if(result.next()){
                String name = result.getString("projectName");
                String description = result.getString("projectDescription");
                int projectID = result.getInt("projectID");
                Project project = new Project(id, name, description);
                project.setTasks(this.taskDAO.getAll(project.getProjectId()));
                return project;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Project> getAll(int ParentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public void save(Project p) {
        this.getController();
        DBController.executeSet(String.format("insert into PROJECT (projectID, projectName, projectDescription) values" +
        "(%d, \"%s\", \"%s\")" +
        "on duplicate key update" +
        "projectName = \"%s\"," +
        "projectDescription = \"%s\";", p.getProjectId(), p.getProjectname(), p.getProjectDescription());
    }

    @Override
    public void update(Project p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Project p) {
        this.getController();
        DBController.executeGet(String.format("delete from PROJECT where projectID = %d;", p.getProjectId()));
    }
}
