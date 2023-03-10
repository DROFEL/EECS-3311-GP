CREATE SCHEMA PMS;
USE PMS;

CREATE TABLE USERACCOUNTS
(idUserAccounts INT UNSIGNED NOT NULL AUTO_INCREMENT,
firstname VARCHAR(45) NOT NULL,
lastname VARCHAR(45) NOT NULL,
username VARCHAR(45) NOT NULL,
_password VARCHAR(45) NOT NULL,
PRIMARY KEY (idUserAccounts)
);

INSERT INTO UserAccounts(firstname, lastname, username, _password) VALUES ('dev/QA', 'team', 'DevQAlogin', 'SQLigma');
INSERT INTO UserAccounts(firstname, lastname, username, _password) VALUES ('client/user', 'team', 'ClientUserlogin', 'SQLigma');

CREATE TABLE PERSON
(personID INT UNSIGNED NOT NULL AUTO_INCREMENT,
personName VARCHAR(50),
email VARCHAR(50),
phoneNum INT,
PRIMARY KEY (personID)
);

# Teams consisting of multiple members and one leader (Many-to-Many, 1-to-Many)
CREATE TABLE TEAM
(teamID INT UNSIGNED NOT NULL AUTO_INCREMENT,
leaderID INT UNSIGNED,
PRIMARY KEY (teamID),
FOREIGN KEY (leaderID) REFERENCES PERSON(personID)
);

CREATE TABLE PROJECT
(projectID INT UNSIGNED NOT NULL AUTO_INCREMENT,
projectName VARCHAR(50),
projectDescription VARCHAR(500),
teamID INT UNSIGNED,
PRIMARY KEY (projectID),
FOREIGN KEY (teamID) REFERENCES TEAM(teamID)
);

# Tasks for a project (1-to-Many)
CREATE TABLE TASK
(taskID INT UNSIGNED NOT NULL AUTO_INCREMENT,
taskName VARCHAR(50),
taskDescription VARCHAR(250),
taskStatus VARCHAR(20),
projectID INT UNSIGNED,
isPending BOOLEAN,
PRIMARY KEY (taskID),
FOREIGN KEY (projectID) REFERENCES PROJECT(projectID)
);

# A Person's comments on a task (1 Person, 1 Task, Many Comments)
CREATE TABLE TASKCOMMENT
(commentID INT UNSIGNED NOT NULL AUTO_INCREMENT,
commentDescription VARCHAR(250),
taskID INT UNSIGNED,
personID INT UNSIGNED,
PRIMARY KEY (commentID),
FOREIGN KEY (taskID) REFERENCES TASK(taskID),
FOREIGN KEY (personID) REFERENCES PERSON(personID)
);

# Relationship
# Persons members of Teams (Many-to-Many)
CREATE TABLE MemberOf
(teamID INT UNSIGNED NOT NULL,
personID INT UNSIGNED NOT NULL,
PRIMARY KEY (teamID, personID),
FOREIGN KEY (teamID) REFERENCES TEAM(teamID),
FOREIGN KEY (personID) REFERENCES PERSON(personID)
);

# Relationship
# Persons assigned to tasks (Many-to-Many)
CREATE TABLE AssignedTo
(taskID INT UNSIGNED NOT NULL,
personID INT UNSIGNED NOT NULL,
PRIMARY KEY (taskID, personID),
FOREIGN KEY (taskID) REFERENCES TASK(taskID),
FOREIGN KEY (personID) REFERENCES PERSON(personID)
);