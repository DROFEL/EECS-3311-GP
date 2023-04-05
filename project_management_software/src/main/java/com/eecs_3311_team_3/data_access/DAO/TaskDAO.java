package com.eecs_3311_team_3.data_access.DAO;

import java.util.ArrayList;
import java.util.List;

import com.eecs_3311_team_3.data_model.Task;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TaskDAO extends DAO_ParentDependant<Task, Integer, Integer> {

    public TaskDAO() {
        super();
    }

    @Override
    public ArrayList<Task> getAll(Integer ParentId) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Task> cr = cb.createQuery(Task.class);
        Root<Task> root = cr.from(Task.class);
        cr.select(root).where(root.get("projectID").in(ParentId));

        Query<Task> query = session.createQuery(cr);
        List<Task> results = query.getResultList();

        return new ArrayList<Task>(results);
    }

}
