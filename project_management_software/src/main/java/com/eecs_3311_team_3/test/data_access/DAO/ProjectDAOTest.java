package com.eecs_3311_team_3.test.data_access.DAO;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.eecs_3311_team_3.data_access.Repository.DBController;

public class ProjectDAOTest {

    @Test
    public void establishConnection(){
        try {
            new DBController("jdbc:mysql://0.0.0.0:3306/PMS", "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ProjectCreate(){
        new DBController("jdbc:mysql://0.0.0.0:3306/PMS", "root", "1234");

        // ProjectDAO dao = new ProjectDAO();
        // int id = dao.create();
        // dao.delete(new Project(id,"",""));

        // assertEquals(1, id);
    }

    @Test public void ProjectGet(){

    }

    @Test public void ProjectGetAll(){

    }

    @Test public void ProjectUpdate(){

    }

    @Test public void ProjectDelete(){

    }


}
