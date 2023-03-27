package com.eecs_3311_team_3.data_model;

import org.hibernate.annotations.*;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TASK")
public class Project{
    @Id
    @Column(name="projectID")
    public int projectID;
    @Id
    @Column(name="ownerID")
    public int ownerID;
    @Column(name="projectName")
    public String projectName;
    @Column(name="projectDescription")
    public String projectDescription;
    
}