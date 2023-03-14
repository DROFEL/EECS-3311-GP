package com.eecs_3311_team_3.data_access.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.DBController;
import com.eecs_3311_team_3.data_model.Task;

public class TaskDAO extends DAO<Task, Integer, Integer> {

    public TaskDAO() {
        super();
    }

    @Override
    public Task get(Integer id) {
        try {
            ResultSet result = DBController.executeGet(String.format("select * from TASK where taskID = %d;", id));
            if (result.next()) {
                return assembleTask(result);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Task> getAll(Integer ParentId) {
        ArrayList<Task> tasks = null;
        try {
            ResultSet result = DBController
                    .executeGet(String.format("select * from TASK where projectID = %d;", ParentId));
            tasks = new ArrayList<>();
            while (result.next()) {
                tasks.add(assembleTask(result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public Integer create(Integer ParentId) {
        
        int generatedID = 0;
        try {
            DBController.executeSet(String.format("insert into TASK (projectID) values (%d);", ParentId));


            ResultSet response = DBController.executeGet("SELECT * FROM TASK ORDER BY taskID DESC LIMIT 1;");
            if(response.next()){
                generatedID = response.getInt("taskID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedID;
    }

    @Override
    public void update(Task t) {
        this.getController();
        DBController.executeSet(String.format(
                        "update TASK " +
                        "set taskName = \"%s\"," +
                        "taskDescription = \"%s\"," +
                        "taskStatus = \"%s\"," +
                        "projectID = %d," +
                        "isPending = true where taskID = %d;",
                t.getName(), t.getComments(), t.getStatus(), t.getProjectID(), t.getID()));
    }

    @Override
    public void delete(Task t) {
        this.getController();
        DBController.executeGet(String.format("delete from TASK where taskID = %d;", t.getID()));
    }

    private Task assembleTask(ResultSet result) throws SQLException {
        String name = result.getString("taskName");
        String description = result.getString("taskDescription");
        String status = result.getString("taskStatus");
        int projectID = result.getInt("projectID");
        int taskID = result.getInt("taskID");
        boolean bPending = result.getBoolean("isPending");
        return new Task(taskID, name, status, description, projectID);
    }
}
