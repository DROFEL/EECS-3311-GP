INSERT INTO UserAccounts(firstname, lastname, username, _password) VALUES ('dev/QA', 'team', 'DevQAlogin', 'SQLigma');
INSERT INTO UserAccounts(firstname, lastname, username, _password) VALUES ('client/user', 'team', 'ClientUserlogin', 'SQLigma');

insert into PROJECT (projectID, projectName, projectDescription) values
(1, "Some project", "Dedeciptription");

select * from PROJECT;

insert into TASK (taskName, taskDescription, taskStatus, projectID, isPending) values
("Do smth5", "descriotion", "not done", 1, true);

SELECT * FROM TASK ORDER BY taskID DESC LIMIT 1;


select * from PROJECT;

update PROJECT set projectName="project2" where projectID = 2;

insert into TASK (taskID, taskName, taskDescription, taskStatus, projectID, isPending) values
(4, "Dmth", "riion", "not done", 1, true)
on duplicate key update
taskName = values(taskName),
taskDescription = values(taskDescription),
taskStatus = values(taskStatus),
projectID = values(projectID),
isPending = values(isPending);

update TASK
set taskName = ASdda,
taskDescription = '',
taskStatus = '',
projectID = '',
isPending = '' where taskID = 4;