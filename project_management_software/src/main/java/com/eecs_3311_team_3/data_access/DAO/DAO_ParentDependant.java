package com.eecs_3311_team_3.data_access.DAO;

import com.eecs_3311_team_3.data_model.ParentDependant;
import com.eecs_3311_team_3.data_model.User;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO_ParentDependant<T extends ParentDependant<P, U>, U, P> extends DAO<T, U, P>{
    public T get(U id){
        T result = session.get(thisClass, (Serializable) id);
        tx.commit();
        return result;
    }

    public abstract ArrayList<T> getAll(P ParentId);

    public T create(P ParentId){
        try {
            ParentDependant<P, U> result = thisClass.getDeclaredConstructor().newInstance();
            result.setParentID(ParentId);
            U resultID = (U)session.save(result);
            result.setID(resultID);
            tx.commit();

            return (T) result;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


    public void update(T instance) {
        session.merge(instance);
        tx.commit();
    }

    public void delete(T instance){
        session.delete(instance);
        tx.commit();
    }
}
