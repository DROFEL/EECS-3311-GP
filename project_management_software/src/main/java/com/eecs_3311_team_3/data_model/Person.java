package com.eecs_3311_team_3.data_model;

import java.util.ArrayList;
import java.util.List;


public class Person{

    private int userID;
    private String name; 
    private String contactInfo;
    // a list for what team a person is on 
    public List <String> personTeams = new ArrayList<>();
    // list of tasks


    // defult constuctor 
    /**
     * 
     */
    public Person(){// test
        this.userID = 0;
        this.name = "";
        this.contactInfo = "";
        this.personTeams = null;
    }

    // Constuctor
    public Person(int userID, String name, String contactInfo, List<String> personteams){
        this.userID = userID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.personTeams = personteams;
    }

    public void newTeam(){
        Team newTeam = new Team();
    }

    public void assignToTeam( String team){
        // need a helper function that will take a person oject then addeds it to the team object.
        this.personTeams.add(0, team);
    }


    // given a person object add a team to there team list
    public void assignToTeam( Person person, String team){
        List <String> newTeams = person.personTeams;
        newTeams.add(0, team);
        person.personTeams = newTeams;
    }



    // getters to get info about the person 
    public int getUserID(){// get the userID
        return this.userID;
    }

    public String getName(){// get the name of person
        return this.name;
    }

    public String getContactInfo(){// get  the contact info of the person
        return this.contactInfo;
    }

    // Only setter just in case a person changes there contact info
    public void setContactInfo(String newInfo){// to change the contact info to the new contact info 
        this.contactInfo = newInfo;  
    }

}