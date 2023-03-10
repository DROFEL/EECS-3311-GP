package Lab1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ProjectTest {

	@Test
	public void testDefaultConstructor() {//Test the default constructor
		Project project = new Project();
		assertEquals(0, project.getProjectId());
		assertEquals("Untitled Project", project.getProjectname());
		assertEquals("This is a new Project", project.getProjectDescription());
		assertTrue(project.getPendingTasks().isEmpty());
	}
	
	@Test
	public void testConstructorWithParams() {//Test the constructor with parameters
	    Project project = new Project(1, "Project 1", "This is a test project");
	    assertEquals(1, project.getProjectId());
	    assertEquals("Project 1", project.getProjectname());
	    assertEquals("This is a test project", project.getProjectDescription());
	    assertTrue(project.getPendingTasks().isEmpty());
	}

	@Test
	public void testAddTask() {//Test adding a task to the project
	    Project project = new Project();
	    Task task = new Task("1", "Task 1", "In Progress", "");
	    assertTrue(project.addTask(task));
	    assertEquals(1, project.getPendingTasks().size());
	    assertEquals(task, project.getPendingTasks().get(0));
	}
	
	@Test
	public void testGetProjectId() {//Test getting the project ID
	    Project project = new Project(1, "Project 1", "This is a test project");
	    assertEquals(1, project.getProjectId());
	}
	
	@Test
	public void testGetProjectName() {//Test getting the project name
	    Project project = new Project(1, "Project 1", "This is a test project");
	    assertEquals("Project 1", project.getProjectname());
	}
	
	@Test
	public void testGetProjectDescription() {//Test getting the project description
	    Project project = new Project(1, "Project 1", "This is a test project");
	    assertEquals("This is a test project", project.getProjectDescription());
	}
	
	@Test
	public void testSetProjectName() {//Test setting the project name
	    Project project = new Project(1, "Project 1", "This is a test project");
	    project.setProjectName("New Project Name");
	    assertEquals("New Project Name", project.getProjectname());
	}

	@Test
	public void testAddMultipleTasks() {//Test adding multiple tasks to the project
	    Project project = new Project();
	    Task task1 = new Task("1", "Task 1", "In Progress", "");
	    Task task2 = new Task("2", "Task 2", "Not Started", "");
	    assertTrue(project.addTask(task1));
	    assertTrue(project.addTask(task2));
	    assertEquals(2, project.getPendingTasks().size());
	    assertEquals(task1, project.getPendingTasks().get(0));
	    assertEquals(task2, project.getPendingTasks().get(1));
	}
	

	
    public void testAddNullTask() {
        Project project = new Project(1, "Project 1", "This is a test project");
        assertThrows(NullPointerException.class, () -> project.addTask(null));
    }


}
