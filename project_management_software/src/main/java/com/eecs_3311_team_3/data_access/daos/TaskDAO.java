package com.eecs_3311_team_3.data_access.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eecs_3311_team_3.data_access.DBController;
import com.eecs_3311_team_3.data_model.Task;

public class TaskDAO extends DAO<Task> {

    public TaskDAO() {
        super();
    }

    @Override
    public Task get(int id) {
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
    public ArrayList<Task> getAll(int ParentId) {
        ArrayList<Task> tasks = null;
        try {
            ResultSet result = DBController.executeGet(String.format("select * from TASK where projectID = %d;", ParentId));
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
    public void save(Task t) {
        this.getController();
        DBController.executeSet(String.format(
                "insert into TASK (taskID, taskName, taskDescription, taskStatus, projectID, isPending) values " +
                        "(%d, \"%s\", \"%s\", \"%s\", 1, true) " +
                        "on duplicate key update " +
                        "taskName = values(taskName), " +
                        "taskDescription = values(taskDescription), " +
                        "taskStatus = values(taskStatus), " +
                        "projectID = values(projectID), " +
                        "isPending = values(isPending);",
                t.getID(), t.getName(), t.getComments(), t.getStatus()));
    }

    @Override
    public void update(Task t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
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
        boolean bPending = result.getBoolean("isPending");
        return new Task(projectID, name, status, description);
    }
}
