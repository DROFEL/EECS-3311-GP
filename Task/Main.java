import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create new Team object
        Team team = new Team(person.getUserID(), Arrays.asList(person.getUserID()), 1, 1);

        //Create new Task object
        Task task = new Task("ID123", "Task Name", "Unfinished", " ", Team team);

        //Checking
        System.out.println("Task ID: " + task.getID());
        System.out.println("Task name: " + task.getName());
        System.out.println("Task status: " + task.getStatus());
        System.out.println("Task Comments: " + task.getComments());
        System.out.println("Task team: " + task.getTeam().getProjectNumber());

        //Changing status and adding comment
        task.editStatus("In progress");
        task.addComment("Hello World");

        //Checking
        System.out.println("Task status: " + task.getStatus());
        System.out.println("Task Comments: " + task.getComments());


    }
}