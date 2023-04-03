package com.eecs_3311_team_3.data_access.DAO;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import com.eecs_3311_team_3.data_model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationBinder;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;


/**
 * DAO.java
 * Interface class that is used for DAO pattern implementation.
 * 
 * @author George
 * @since Feb 17 2023
 */
public abstract class DAO<T, U, P> {

    protected Session session;
    protected Class<T> thisClass;
    protected Transaction tx;

    public DAO(){
        thisClass= (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(thisClass);
        SessionFactory sf = config.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
    }

    public void close(){
        if (session.getTransaction().getStatus() != TransactionStatus.COMMITTED){
            tx.commit();
        }
        session.close();
    }

    public abstract T get(U id);

    public abstract ArrayList<T> getAll(P mainKey);

    public abstract T create(P ParentId);


    public abstract void update(T instance);

    public abstract void delete(T instance);
}
