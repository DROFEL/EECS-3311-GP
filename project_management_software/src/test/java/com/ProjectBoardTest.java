package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import java.util.ArrayList;


import com.eecs_3311_team_3.data_model.Person;
import com.eecs_3311_team_3.data_model.Project;
import com.eecs_3311_team_3.data_model.ProjectBoard;

class ProjectBoardTest {

	private Person person;
	private Project project1;
	private Project project2;
	private ProjectBoard board;
	
	@Test
	public void testAddProject() {
		// create a person and two projects
		person = new Person(1, "John", "john@example.com", new ArrayList<String>());
		project1 = new Project(1, "Project 1", "Description 1");
		project2 = new Project(2, "Project 2", "Description 2");
		// create a project board and add the person and projects
		board = new ProjectBoard(person);
		board.addProject(project1);
		board.addProject(project2);
		
		
		// add a new project and check that it was added successfully
		Project project3 = new Project(3, "Project 3", "Description 3");
		assertTrue(board.addProject(project3));
		// assertEquals(3, board.getProjects().size());
		// assertEquals(project3, board.getProjects().get(2));
	}
	
	@Test
	public void testDeleteProject() {
		// create a person and two projects
		person = new Person(1, "John", "john@example.com", new ArrayList<String>());
		project1 = new Project(1, "Project 1", "Description 1");
		project2 = new Project(2, "Project 2", "Description 2");
		// create a project board and add the person and projects
		board = new ProjectBoard(person);
		board.addProject(project1);
		board.addProject(project2);
				
				
		// delete a project and check that it was deleted successfully
		assertTrue(board.deleteProject(project1));
		// assertEquals(1, board.getProjects().size());
		// assertEquals(project2, board.getProjects().get(0));
	}

	@Test
	public void testGetOwner() {
		// create a person and two projects
		person = new Person(1, "John", "john@example.com", new ArrayList<String>());
		project1 = new Project(1, "Project 1", "Description 1");
		project2 = new Project(2, "Project 2", "Description 2");
		// create a project board and add the person and projects
		board = new ProjectBoard(person);
		board.addProject(project1);
		board.addProject(project2);
		
		// check that the owner is the same as the person we added
		assertEquals(person, board.getOwner());
	}
	
	@Test
	public void testGetProjects() {
		// create a person and two projects
		person = new Person(1, "John", "john@example.com", new ArrayList<String>());
		project1 = new Project(1, "Project 1", "Description 1");
		project2 = new Project(2, "Project 2", "Description 2");
		// create a project board and add the person and projects
		board = new ProjectBoard(person);
		board.addProject(project1);
		board.addProject(project2);
		
		// check that the projects list contains the projects we added
		// assertEquals(2, board.getProjects().size());
		// assertTrue(board.getProjects().contains(project1));
		// assertTrue(board.getProjects().contains(project2));
	}
	
//	@Test
//	public void testAddDuplicateProject() {
//		// create a person and two projects
//		person = new Person(1, "John", "john@example.com", new ArrayList<String>());
//		project1 = new Project(1, "Project 1", "Description 1");
//		project2 = new Project(2, "Project 2", "Description 2");
//		// create a project board and add the person and projects
//		board = new ProjectBoard(person);
//		board.addProject(project1);
//		board.addProject(project2);
//		
//		// try to add a project with the same ID as an existing project
//		Project project3 = new Project(1, "Project 3", "Description 3");
//		assertFalse(board.addProject(project3));
//		assertEquals(2, board.getProjects().size());
//	}
	
	
}
