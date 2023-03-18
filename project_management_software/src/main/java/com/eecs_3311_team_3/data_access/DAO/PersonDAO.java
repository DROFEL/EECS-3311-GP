package com.eecs_3311_team_3.data_access.DAO;

import java.util.ArrayList;

import com.eecs_3311_team_3.data_model.Person;

public class PersonDAO extends DAO<Person, Integer, Integer> {

    @Override
    public Person get(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ArrayList<Person> getAll(Integer ParentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Person create(Integer ParentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Person t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Person t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
