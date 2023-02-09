import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create new array of team names
        ArrayList<String> teamNames = new ArrayList<>();

         teamNames.add("Team 1");
         teamNames.add("Team 2");
        // Create a new Person object
        Person person = new Person(1520, "John Doe", "john.doe@email.com", teamNames);

        // Assign the person to a team
        person.assignToTeam("Team 1");

        // Create a new Team object
        Team team = new Team(person.getUserID(), Arrays.asList(person.getUserID()), 1, 1);

        System.out.println("Team Leader: " + team.getLeader());
        System.out.println("Team Members: " + team.getMembers());
        System.out.println("Project Number: " + team.getProjectNumber());
        System.out.println("Task Number: " + team.getTaskNumber());

        // Assign the team to a new project
        team.assignToProject(2);

        System.out.println("Project Number: " + team.getProjectNumber());
    }
}
