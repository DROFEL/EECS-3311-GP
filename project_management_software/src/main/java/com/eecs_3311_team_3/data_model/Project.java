package com.eecs_3311_team_3.data_model;

import java.util.ArrayList;

public class Project{

    private int projectID;
    private String name;
    private String description;
    private ArrayList<Task> PendingTasks = null;
    
    
    
    //Default Constructor 
    public Project () {
    
    projectID=0;
    this.name="Untitled Project";
    this.description= "This is a new Project";
    this.PendingTasks= new ArrayList<Task>();
    
    }
    
    // Constructor 
    public Project(int projectID){
        this.projectID = projectID;
    }

    public Project (int projectID, String name, String description){
        this.projectID= projectID;
        this.name = name;
        this.description = description;
    
    }
    
    // Method to add a task to list of tasks for project 
    public boolean addTask(Task task){
        PendingTasks.add(task);
        return true; 
    }

    public void initTasks(ArrayList<Task> tasks){
        if(PendingTasks == null){
            PendingTasks = tasks;
        }
    }

    public ArrayList<Task> getTasks(){
        return PendingTasks;
    }
    
    //method to get the project id 
    public int getProjectId(){
    
    return this.projectID;
    }
    
    //method to get project name 
    
    public String getProjectname(){
    
    return this.name;
    
    
    }
    
    //method to get project description 
    
    public String getProjectDescription(){
    
    return this.description;
    }
    
    // method to set project name 
    public void setProjectName (String name){
        this.name = name;
    }
    
    
    
    
    }