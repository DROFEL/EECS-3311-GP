insert into USER(userName, fullName, email, password) values
("dev", "Dev/QA account", "example@gmail.com", "root"),
("client", "client/user", "example@gmail.com", "ClientPassword");


insert into PROJECT (projectName, projectDescription) values
("Some project", "Dedeciptription");

select * from PROJECT;

insert into TASK (taskName, taskDescription, taskStatus, projectID, isPending) values
("Do smth5", "descriotion", "not done", 1, true);

insert into TASK (projectID) values
(1);


insert into TASK (taskID) values (null);
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