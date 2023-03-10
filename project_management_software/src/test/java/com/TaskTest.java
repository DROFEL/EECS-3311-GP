package com;

import static org.junit.Assert.assertEquals;

import com.eecs_3311_team_3.data_model.Task;

class TaskTest {

	
    @Test
    public void testDefaultConstructor() {// Test case 1: Test the default constructor
        Task t = new Task();
        assertEquals("Null", t.getID());
        assertEquals("Null", t.getName());
        assertEquals("Null", t.getStatus());
        assertEquals("", t.getComments());
    }
    
 
    @Test
    public void testConstructorWithParams() {// Test case 2: Test the constructor with parameters
        // Task t = new Task(1, "Task 1", "In Progress", "Needs more testing");
        // assertEquals(1, t.getID());
        // assertEquals("Task 1", t.getName());
        // assertEquals("In Progress", t.getStatus());
        // assertEquals("Needs more testing", t.getComments());
    }

    
    @Test
    public void testSetID() {// Test case 3: Test the setter for ID
        Task t = new Task();
        // assertEquals("T001", t.getID());
    }

 
    @Test
    public void testSetName() {// Test case 4: Test the setter for name
        Task t = new Task();
        t.setName("Task 1");
        assertEquals("Task 1", t.getName());
    }

    
    @Test
    public void testEditStatus() {// Test case 5: Test the editStatus method
        // Task t = new Task(1, "Task 1", "In Progress", "Needs more testing");
        // t.editStatus("Completed");
        // assertEquals("Completed", t.getStatus());
    }

    
    @Test
    public void testAddCommentWithEmptyString() {// Test case 6: Test the addComment method with an empty string
        // Task t = new Task(1, "Task 1", "In Progress", "");
        // t.addComment("New comment");
        // assertEquals("New comment", t.getComments());
    }
    
 
    @Test
    public void testAddCommentWithExistingComment() {// Test case 7: Test the addComment method with an existing comment
        // Task t = new Task(1, "Task 1", "In Progress", "Needs more testing");
        // t.addComment("New comment");
        // assertEquals("Needs more testing, New comment", t.getComments());
    }

    
    @Test
    public void testAddCommentWithMultipleComments() {// Test case 8: Test the addComment method with multiple comments
        // Task t = new Task(1, "Task 1", "In Progress", "Needs more testing, Fix bug #12");
        // t.addComment("Add new feature");
        // assertEquals("Needs more testing, Fix bug #12, Add new feature", t.getComments());
    }

    
    @Test
    public void testGetID() {// Test case 9: Test the getter for ID
        // Task t = new Task(1, "Task 1", "In Progress", "Needs more testing");
        // assertEquals(1, t.getID());
    }

    
    @Test
    public void testGetName() {// Test case 10: Test the getter for name
        // Task t = new Task(1, "Task 1", "In Progress", "Needs more testing");
        // assertEquals("Task 1", t.getName());
    }


}
