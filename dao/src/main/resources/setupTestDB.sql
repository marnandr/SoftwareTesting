
INSERT INTO Courses VALUES("001","Matek I","Alapaozo matek","002");
INSERT INTO Courses VALUES("002","Programozas alapja","Alapozo programozasi targy","001");

INSERT INTO Student VALUES("001","Mike","Dickson","mikeyy89@gmail.com","225560");
INSERT INTO Student VALUES("002","Alex","Smith","smithalex@gmail.com","asdasd456");
INSERT INTO Student VALUES("003","Rose","Ducktail","rosyy1996@gmail.com","iwillpass");

INSERT INTO Teacher VALUES("001","Jane","White","Janetheteacher@gmail.com","ushallnotpass");
INSERT INTO Teacher VALUES("002","Victoria","Black","vicyblack@gmail.com","7788543");
INSERT INTO Teacher VALUES("003","Prince","Brown","princethereal@gmail.com","getthepie");

INSERT INTO Administrator VALUES("001","Bill","White","imtheadmin@gmail.com","admin001");
INSERT INTO Administrator VALUES("002","John","Gates","gatesbutpoor@gmail.com","admin002");

INSERT INTO Formtype VALUES("001","Complaining in vain");
INSERT INTO Formtype VALUES("002","Rector request");

INSERT INTO Form VALUES("001","001","002","001","2018-09-11","001");
INSERT INTO Form VALUES("002","001","001","002","2018-09-11","002");

INSERT INTO Student_Request VALUES("001","001","2018-09-11","002","Denied","001","001");
INSERT INTO Student_Request VALUES("002","003","2018-09-11","002","Denied","002","002");
INSERT INTO Student_Request VALUES("003","002","2018-09-11","001","Denied","002","003");

INSERT INTO Student_Request_Complain VALUES("001","001","Why did i fail the exam");
INSERT INTO Student_Request_Complain VALUES("002","002","Why did not i fail the exam");