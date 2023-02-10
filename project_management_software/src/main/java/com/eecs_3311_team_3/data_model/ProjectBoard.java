package com.eecs_3311_team_3.data_model;

import java.util.ArrayList;

public class ProjectBoard {
    private Person owner ;
    private ArrayList<Project> projects;

// Default constructor 
    public ProjectBoard(){
        this.owner = null;
        this.projects = new ArrayList<Project>();
    
    }

//Constructor 
public ProjectBoard(Person owner){
    this.owner= owner;
    this.projects = new ArrayList<Project>();
}

public boolean addProject (Project project){
   
    projects.add(project);
    return true;

}

public boolean deleteProject(Project project){
    projects.remove(project);
    return true;
}

public void printProjects(){
    for ( int i =0; i < projects.size();i++){
        System.out.println(projects.get(i).getProjectname());
    }
}

public Person getOwner() {
	return this.owner;
	// TODO Auto-generated method stub
	
}


}