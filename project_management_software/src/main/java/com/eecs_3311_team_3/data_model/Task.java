package com.eecs_3311_team_3.data_model;
//todo; implement Team

import javax.persistence.*;

@Entity
@Table(name="TASK")
public class Task implements ParentDependant<Integer, Integer>{
    @Id
    @Column(name="taskID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int taskID;
//    @ManyToOne
//    @JoinColumn(name="projectID")
    @Column(name="projectID")
    public int projectID;
    @Column(name="taskName")
    public String name;
    @Column(name="taskDescription")
    public String description;
//    @Column(name="taskStatus")
//    public String status;
//    @Column(name="isPending")
//    public Boolean bPending;


    public Task(){

    }
    public Task(int projectID){
        this.projectID = projectID;
    }

    public int getTaskID() {
        return taskID;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

//    public String getStatus() {
//        return status;
//    }
//
//    public boolean isbPending() {
//        return bPending;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public void setbPending(boolean bPending) {
//        this.bPending = bPending;
//    }


    @Override
    public void setParentID(Integer projectID) {
        this.projectID = projectID;
    }

    @Override
    public void setID(Integer id) {
        this.taskID = id;
    }
}