package com.eecs_3311_team_3.data_model;
//todo; implement Team
public class Task{
    String taskID;
    String name;
    String status;
    String comments;
 

    //constructor
    public Task (){
        this.taskID = "Null";
        this.name = "Null";
        this.status = "Null";
        this.comments = "";
       
    }
    public Task (String taskID, String name, String status, String comments){
        this.taskID = taskID;
        this.name = name;
        this.status = status;
        this.comments = comments;
       
    }

    //getters
    public String getID(){
        return this.taskID;
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
    public void setID(String taskID){
        this.taskID = taskID;
    }
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