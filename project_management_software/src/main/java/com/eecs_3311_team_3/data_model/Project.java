package com.eecs_3311_team_3.data_model;

import org.hibernate.annotations.*;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name="PROJECT")
public class Project implements ParentDependant<Integer, Integer> {
    @Id
    @Column(name="projectID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int projectID;
    @Column(name="ownerID")
    public int ownerID;
    @Column(name="projectName")
    public String projectName;
    @Column(name="projectDescription")
    public String projectDescription;

    @Override
    public void setParentID(Integer parentID) {
        ownerID = parentID;
    }

    @Override
    public void setID(Integer id) {
        projectID = id;
        System.out.println("set id" + id);
    }
}