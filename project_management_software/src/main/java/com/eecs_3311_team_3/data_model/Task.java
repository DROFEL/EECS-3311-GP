package com.eecs_3311_team_3.data_model;
//todo; implement Team
public class Task{
    int taskID;
    int projectID;
    String name;
    String status;
    String comments;
 

    //constructor
    public Task(int taskID, int projectID){
        this.taskID = taskID;
        this.projectID = projectID;
    }

    public Task (){
        this.taskID = 0;
        this.name = "Null";
        this.status = "Null";
        this.comments = "";
       
    }
    public Task (int taskID, String name, String status, String comments, int projectID){
        this.taskID = taskID;
        this.name = name;
        this.status = status;
        this.comments = comments;
        this.projectID = projectID;
       
    }

    //getters
    public int getID(){
        return this.taskID;
    }
    public int getProjectID(){
        return this.projectID;
    }
    public String getName(){
        return this.name;
    }
    public String getStatus(){
        return this.status;
    }
    public String getComments(){
        return this.comments;
    }
   


    //setters
    public void setName(String name){
        this.name = name;
    }


    //additional
    public void editStatus(String status){
        this.status = status;
    }

    public void addComment(String newComment){
        if (comments != ""){
            comments += ", ";
        }
        comments += newComment;
    }

}