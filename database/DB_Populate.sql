insert into USER(userName, fullName, email, password) values
("dev", "Dev/QA account", "example@gmail.com", "root"),
("client", "client/user", "example@gmail.com", "ClientPassword");

select * from USER;

-- insert into PROJECT (projectName, projectDescription) values
-- ("Some project", "Dedeciptription");

delete from PROJECT where ownerID = 1;
select * from PROJECT;

select * from USER;


delete from TASK where projectID = 65;
select * from TASK;

insert into TASK (taskName, taskDescription, taskStatus, projectID) values
("Hmmm", "how does this work", "not done", 65),
("Refactor", "refactor some code do this do that this discription is just a filler", "not done", 65),
("Develop app", "this app is going to be developed some day when i have time, not lazy, had enougth sleep, not hungry, dad came back with milk, have girfriend, wokred at Google, ha.....", "not done", 65),
("Become CEO of OpenAI", "hopefully chatGpt wont take over the planet by that time", "not done", 65),
("Write report for 3311", "Im gonna use ChatGPT", "not done", 65),
("Start my own nipple finder startup", "maybe its not a good idea", "not done", 65),
("Found pied piper startup", "only this left is to develop breakthorugh compression algorithm", "not done", 65),
("Call mom", "ok", "not done", 65),
("Cleanup room", "im lazy", "not done", 65),
("Task", "I wonder if chat gpt can develop app for 3311", "not done", 65),
("Pickup lines", "Are you recursive? Because I’ll do you over and over again. ssh me@yourDMs. Are you an iteration? Because I want to be in the next step of your life. Are you vim? Cuz I can't pull out of you.", "not done", 65);

-- insert into TASK (projectID) values
-- (1);


-- insert into TASK (taskID) values (null);
-- SELECT * FROM TASK ORDER BY taskID DESC LIMIT 1;


-- select * from PROJECT;

-- update PROJECT set projectName="project2" where projectID = 2;

-- insert into TASK (taskID, taskName, taskDescription, taskStatus, projectID, isPending) values
-- (4, "Dmth", "riion", "not done", 1, true)
-- on duplicate key update
-- taskName = values(taskName),
-- taskDescription = values(taskDescription),
-- taskStatus = values(taskStatus),
-- projectID = values(projectID),
-- isPending = values(isPending);

-- update TASK
-- set taskName = ASdda,
-- taskDescription = '',
-- taskStatus = '',
-- projectID = '',
-- isPending = '' where taskID = 4;