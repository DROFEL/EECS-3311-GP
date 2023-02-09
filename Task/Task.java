import Team.java; //todo; implement Team
public class Task{
    Private String taskID;
    Private String name;
    Private String status;
    Private String comments;
    Private Team team; 

    //constructor
    public Task (){
        this.taskID = "Null";
        this.name = "Null";
        this.status = "Null";
        this.comments = '';
        this.team = null; 
    }
    public Task (String taskID, String name, String status, String comments, Team team){
        this.taskID = taskID;
        this.name = name;
        this.status = status;
        this.comments = comments;
        this.team = team;
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
    public Team getTeam(){
        return this.team;
    }


    //setters
    public void setID(String taskID){
        this.taskID = taskID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void assignTeam(Team team){
        this.team = team;
    }


    //additional
    public void editStatus(String status){
        this.status = status;
    }

    public void addComment(String newComment){
        if (comments != ''){
            comments += ", ";
        }
        comments += newComment;
    }

}