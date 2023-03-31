package com.eecs_3311_team_3.test;

import com.eecs_3311_team_3.data_model.Team;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


class TeamTest {

	@Test
	public void testNewTeamDefaultConstructor(){//Test creating a new team with the default constructor
	    Team team = new Team();
	    assertEquals(1, Team.counter);
	    assertEquals(0, team.getLeader());
	    assertNull(team.getMembers());
	    assertEquals(0, team.getProjectNumber());
	    assertEquals(0, team.getTaskNumber());
	    Team.counter = 0;
	}
	
	@Test
	public void testNewTeamParameterizedConstructor(){//Test creating a new team with the parameterized constructor.
	    List<Integer> members = new ArrayList<Integer>();
	    members.add(1);
	    members.add(2);
	    members.add(3);
	    Team team = new Team(1, members, 1, 1);
	    assertEquals(1, Team.counter);
	    assertEquals(1, team.getLeader());
	    assertEquals(members, team.getMembers());
	    assertEquals(1, team.getProjectNumber());
	    assertEquals(1, team.getTaskNumber());
	    Team.counter = 0;
	}
	
	@Test
	public void testSetLeader(){//Test setting the leader of a team.
	    List<Integer> members = new ArrayList<Integer>();
	    members.add(1);
	    members.add(2);
	    members.add(3);
	    Team team = new Team(1, members, 1, 1);
	    team.setLeader(4);
	    assertEquals(4, team.getLeader());
	    Team.counter = 0;
	}
	
	@Test
	public void testAssignToProject(){
	    List<Integer> members = new ArrayList<Integer>();
	    members.add(1);
	    members.add(2);
	    members.add(3);
	    Team team = new Team(1, members, 1, 1);
	    team.assignToProject(2);
	    assertEquals(2, team.getProjectNumber());
	    Team.counter = 0;
	}
	
	@Test
	public void testAssignToTask(){//Test assigning a team to a task
	    List<Integer> members = new ArrayList<Integer>();
	    members.add(1);
	    members.add(2);
	    members.add(3);
	    Team team = new Team(1, members, 1, 1);
	    team.assignToTask(2);
	    assertEquals(2, team.getTaskNumber());
	    Team.counter = 0;
	}
	
	@Test
	public void testGetLeader(){//Test getting the leader of a team
	    List<Integer> members = new ArrayList<Integer>();
	    members.add(1);
	    members.add(2);
	    members.add(3);
	    Team team = new Team(1, members, 1, 1);
	    assertEquals(1, team.getLeader());
	    Team.counter = 0;
	}
	
	@Test
	public void testGetMembers(){//Test getting the members of a team.
	    List<Integer> members = new ArrayList<Integer>();
	    members.add(1);
	    members.add(2);
	    members.add(3);
	    Team team = new Team(1, members, 1, 1);
	    assertEquals(members, team.getMembers());
	    Team.counter = 0;
	}
	
	@Test
	public void testGetProjectNumber(){//Test getting the project number of a team.
	    List<Integer> members = new ArrayList<Integer>();
	    members.add(1);
	    members.add(2);
	    members.add(3);
	    Team team = new Team(1, members, 1, 1);
	    assertEquals(1, team.getProjectNumber());
	    Team.counter = 0;
	}
	
	@Test
	public void testGetTaskNumber(){//Test getting the task number of a team.
	    List<Integer> members = new ArrayList<Integer>();
	    members.add(1);
	    members.add(2);
	    members.add(3);
	    Team team = new Team(1, members, 1,1);
	    assertEquals(1, team.getTaskNumber());
	    Team.counter = 0;
	}


}
