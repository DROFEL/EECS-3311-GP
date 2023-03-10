package com.eecs_3311_team_3.data_access.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.DBController;
import com.eecs_3311_team_3.data_model.Project;

public class ProjectDAO extends DAO<Project> {

    public ProjectDAO() {
        super();
    }

    
    /** 
     * @param id
     * @return Project
     */
    @Override
    public Project get(int id) {
        try {
            ResultSet result = DBController.executeGet(String.format("select * from PROJECT where projectID = %d;", id));
            if (result.next()) {
                return assemblProject(result);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    /** 
     * @param ParentId
     * @return ArrayList<Project>
     */
    @Override
    public ArrayList<Project> getAll(int ParentId) {
        ArrayList<Project> projects = null;
        try {
            ResultSet result = DBController
                    .executeGet(String.format("select * from PROJECT;" /*where projectID = %d;*/, ParentId));
            projects = new ArrayList<>();
            while (result.next()) {
                projects.add(assemblProject(result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projects;
    }

    
    /** 
     * @param p
     */
    @Override
    public void save(Project p) {
        DBController.executeSet(String.format("insert into PROJECT (projectID, projectName, projectDescription) values " +
        "(%d, \"%s\", \"%s\") " +
        "on duplicate key update " +
        "projectName = values(projectName), " +
        "projectDescription = values(projectDescription);", p.getProjectId(), p.getProjectname(), p.getProjectDescription()));
    }

    
    /** 
     * @param p
     */
    @Override
    public void update(Project p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    
    /** 
     * @param p
     */
    @Override
    public void delete(Project p) {
        this.getController();
        DBController.executeGet(String.format("delete from PROJECT where projectID = %d;", p.getProjectId()));
    }

    
    /** 
     * Takes Result set with project info and returns Projec java object 
     * @param ResultSet result
     * @return Project
     * @throws SQLException
     */
    private Project assemblProject(ResultSet result) throws SQLException {
        String name = result.getString("projectName");
        String description = result.getString("projectDescription");
        int projectID = result.getInt("projectID");
        Project project = new Project(projectID, name, description);
        return project;
    }
}
