
-- H2 db creates the columns in alphabatical order:
-- email - firstname - lastname - role - ssn - username

insert into user values (101, 'one@gmail.com', 'name01a', 'name01b', 'admin', 'ssn101', 'username01');
insert into user values (102, 'two@gmail.com', 'name02a', 'name02b', 'admin', 'ssn102', 'username02');
insert into user values (103, 'three@gmail.com', 'name03a', 'name03b', 'admin', 'ssn103', 'username03');

insert into orders values(2001, 'order11', 101);
insert into orders values(2002, 'order12', 101);
insert into orders values(2003, 'order13', 101);
insert into orders values(2004, 'order21', 102);
insert into orders values(2005, 'order22', 102);
insert into orders values(2006, 'order31', 103);