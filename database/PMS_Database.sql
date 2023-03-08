CREATE SCHEMA PMS;
USE PMS;

CREATE TABLE PROJECT
(projectID INT NOT NULL,
projectName VARCHAR(50),
projectDescription VARCHAR(500),
PRIMARY KEY (projectID)
);

# Tasks for a project (1-to-Many)
CREATE TABLE TASK
(taskID INT NOT NULL,
taskName VARCHAR(50),
taskDescription VARCHAR(250),
taskStatus VARCHAR(20),
projectID INT,
isPending BOOLEAN,
PRIMARY KEY (taskID),
FOREIGN KEY (projectID) REFERENCES PROJECT(projectID)
);

CREATE TABLE PERSON
(personID INT NOT NULL,
personName VARCHAR(50),
email VARCHAR(50),
phoneNum INT,
PRIMARY KEY (personID)
);

# Teams consisting of multiple members and one leader (Many-to-Many, 1-to-Many)
CREATE TABLE TEAM
(teamID INT NOT NULL,
leaderID INT,
PRIMARY KEY (teamID),
FOREIGN KEY (leaderID) REFERENCES PERSON(personID)
);

# A Person's comments on a task (1 Person, 1 Task, Many Comments)
CREATE TABLE TASKCOMMENT
(commentID INT NOT NULL,
commentDescription VARCHAR(250),
taskID INT,
personID INT,
PRIMARY KEY (commentID),
FOREIGN KEY (taskID) REFERENCES TASK(taskID),
FOREIGN KEY (personID) REFERENCES PERSON(personID)
);

# Relationship
# Persons members of Teams (Many-to-Many)
CREATE TABLE MemberOf
(teamID INT NOT NULL,
personID INT NOT NULL,
PRIMARY KEY (teamID, personID),
FOREIGN KEY (teamID) REFERENCES TEAM(teamID),
FOREIGN KEY (personID) REFERENCES PERSON(personID)
);

# Relationship
# Persons assigned to tasks (Many-to-Many)
CREATE TABLE AssignedTo
(taskID INT NOT NULL,
personID INT NOT NULL,
PRIMARY KEY (taskID, personID),
FOREIGN KEY (taskID) REFERENCES TASK(taskID),
FOREIGN KEY (personID) REFERENCES PERSON(personID)
);