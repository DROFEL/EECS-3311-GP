package com.eecs_3311_team_3.test.data_access;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.eecs_3311_team_3.data_access.DBController;
import com.eecs_3311_team_3.data_access.ProjectRepository;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.Task;

public class ProjectRepositoryIntegrationTest {
    // @Test
    // public void Test(){
    //     new DBController("jdbc:mysql://0.0.0.0:3306/PMS", "root", "1234");

    //     ProjectRepository dao = new ProjectRepository();
    //     Project project = dao.get(1);
    //     ArrayList<Task> tasks = project.getTasks();

    //     Task task = tasks.get(0);
    //     String name1 = task.getName();

    //     tasks.set(0, task);

    //     dao.add(project);
    //     project = dao.get(1);
    //     tasks = project.getTasks();
    //     task = tasks.get(0);
    //     String name2 = task.getName();

    //     assertEquals(name1, name2);
    // }
}
