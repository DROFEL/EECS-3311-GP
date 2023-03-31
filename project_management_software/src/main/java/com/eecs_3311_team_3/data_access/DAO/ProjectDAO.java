package com.eecs_3311_team_3.data_access.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.DBController;
import com.eecs_3311_team_3.data_model.Project;

public class ProjectDAO extends DAO<Project, Integer, String> {

    public ProjectDAO() {
        super();
    }

    
    /** 
     * @param id
     * @return Project
     */
    @Override
    public Project get(Integer id) {
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
    public ArrayList<Project> getAll(String ParentId) {
        ArrayList<Project> projects = null;
        try {
            ResultSet result = DBController
                    .executeGet(String.format("select * from PROJECT;" /*where username = %s;*/, ParentId));
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
    public Project create(String ParentId) {
        int generatedID = 0;
        try {
            DBController.executeSet("insert into TASK (taskID) values (null);");

            ResultSet response = DBController.executeGet("SELECT * FROM PROJECT ORDER BY projectID DESC LIMIT 1;");
            if(response.next()){
                generatedID = response.getInt("projectID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Project();
    }

    
    /** 
     * @param p
     */
    @Override
    public void update(Project p) {
        DBController.executeSet(String.format(
        "update PROJECT " +
        "set  " +
        "projectName = \"%s\", " +
        "projectDescription = \"%s\" " +
        "where projectID = \"%d\"", p.getProjectname(), p.getProjectDescription(), p.getProjectId()));
    }

    
    /** 
     * @param p
     */
    @Override
    public void delete(Project p) {
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
