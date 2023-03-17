package com.eecs_3311_team_3.data_access.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eecs_3311_team_3.data_access.DBController;
import com.eecs_3311_team_3.data_model.ParentDependant;
import com.eecs_3311_team_3.data_model.Task;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class TaskDAO extends DAO_ParentDependant<Task, Integer, Integer> {

    public TaskDAO() {
        super();
    }

    @Override
    public ArrayList<Task> getAll(Integer ParentId) {
        Query query = session.createQuery("from Task where projectID = :id");
        query.setParameter("id", ParentId);
        ArrayList<Task> tasks = new ArrayList<>(query.getResultList());
        return tasks;
    }

}
