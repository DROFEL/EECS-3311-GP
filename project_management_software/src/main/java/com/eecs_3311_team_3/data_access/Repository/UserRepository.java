package com.eecs_3311_team_3.data_access.Repository;

import com.eecs_3311_team_3.data_access.DAO.UserDAO;
import com.eecs_3311_team_3.data_model.User;

import java.util.ArrayList;

public class UserRepository implements PM_Repository<User, String, String>{
    @Override
    public User get(String id) {
        UserDAO dao = new UserDAO();
        User result = dao.get(id);
        dao.close();
        return result;
    }

    @Override
    public ArrayList<User> getAll(String mainKey) {
        UserDAO dao = new UserDAO();
        dao.getAll(mainKey);
        dao.close();
        return null;
    }

    @Override
    public User add(String username) {
        UserDAO dao = new UserDAO();
        User result = dao.create(username);
        dao.close();
        return result;
    }

    @Override
    public void update(User instance) {
        UserDAO dao = new UserDAO();
        dao.update(instance);
        dao.close();
    }

    @Override
    public void delete(User instance) {
        UserDAO dao = new UserDAO();
        dao.delete(instance);
        dao.close();
    }
}
