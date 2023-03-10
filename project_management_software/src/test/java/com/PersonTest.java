package com;

import org.junit.Test;

import com.eecs_3311_team_3.data_model.Person;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class PersonTest {

	private Person person;
    private List<String> personTeams;



    @Test
    public void testGetUserID() {
    	personTeams = new ArrayList<>();
        person = new Person(1, "John", "john@example.com", personTeams);
        assertEquals(1, person.getUserID());
    }

    @Test
    public void testGetName() {
    	personTeams = new ArrayList<>();
        person = new Person(1, "John", "john@example.com", personTeams);
        assertEquals("John", person.getName());
    }

    @Test
    public void testGetContactInfo() {
    	personTeams = new ArrayList<>();
        person = new Person(1, "John", "john@example.com", personTeams);
        assertEquals("john@example.com", person.getContactInfo());
    }

    @Test
    public void testSetContactInfo() {
    	personTeams = new ArrayList<>();
        person = new Person(1, "John", "john@example.com", personTeams);
        person.setContactInfo("new_contact@example.com");
        assertEquals("new_contact@example.com", person.getContactInfo());
    }

    @Test
    public void testAssignToTeam() {
    	personTeams = new ArrayList<>();
        person = new Person(1, "John", "john@example.com", personTeams);
        person.assignToTeam("team1");
        assertEquals(1, person.personTeams.size());
        assertEquals("team1", person.personTeams.get(0));
    }

    @Test
    public void testAssignToTeamWithPerson() {
    	personTeams = new ArrayList<>();
        person = new Person(1, "John", "john@example.com", personTeams);
        Person person2 = new Person(2, "Jane", "jane@example.com", new ArrayList<>());
        person.assignToTeam(person2, "team1");
        assertEquals(1, person2.personTeams.size());
        assertEquals("team1", person2.personTeams.get(0));
    }

    @Test
    public void testNewTeam() {
    	personTeams = new ArrayList<>();
        person = new Person(1, "John", "john@example.com", personTeams);
        person.newTeam();
        // This test only checks that the newTeam() method does not throw an exception
        assertTrue(true);
    }

    @Test
    public void testDefaultConstructor() {
    	personTeams = new ArrayList<>();
        person = new Person(1, "John", "john@example.com", personTeams);
        Person person2 = new Person();
        assertNull(person2.personTeams);
    }

    @Test
    public void testConstructor() {
    	personTeams = new ArrayList<>();
        person = new Person(1, "John", "john@example.com", personTeams);
        assertEquals(1, person.getUserID());
        assertEquals("John", person.getName());
        assertEquals("john@example.com", person.getContactInfo());
        assertEquals(personTeams, person.personTeams);
    }
	

}
