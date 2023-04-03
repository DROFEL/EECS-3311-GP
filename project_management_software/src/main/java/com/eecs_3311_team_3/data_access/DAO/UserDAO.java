package com.eecs_3311_team_3.data_access.DAO;

import com.eecs_3311_team_3.data_model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<User, String, String>{
    @Override
    public User get(String username) {

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root).where(root.get("userName").in(username));

        Query<User> query = session.createQuery(cr);
        List<User> results = query.getResultList();

        if(results.size() != 1)
            return null;
        return results.get(0);
    }

    @Override
    public ArrayList<User> getAll(String mainKey) {
        throw new RuntimeException("Getting all users is restricted");
    }

    @Override
    public User create(String username) {
            User result = new User();
            result.userName = username;
            int resultID = (int)session.save(result);
            result.userID = resultID;
            return result;
    }

    @Override
    public void update(User instance) {
        session.merge(instance);
        tx.commit();
    }

    @Override
    public void delete(User instance) {
        session.delete(instance);
        tx.commit();
    }
}
