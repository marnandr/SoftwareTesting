CREATE IF NOT EXISTS database Softest;
CREATE USER IF NOT EXISTS Client identified by 'Client';
GRANT ALL IF EXISTS ON Softest.* to 'Client';
grant all on Softest.* to 'Client'@'localhost' identified by 'Client' with grant option;

CREATE TABLE Student_Request(
    Request_ID int NOT NULL,
    Student_ID int NOT NULL,
    Request_Date date,
    Teacher_ID int NOT NULL,
    Request_Status Varchar(20),
    Course_ID int NOT NULL,
    FORM_ID int NOT NULL,
    PRIMARY KEY(Request_ID),
    FOREIGN KEY(Student_ID) REFERENCES Student (ID),
    FOREIGN KEY(Teachert_ID) REFERENCES Teacher (ID),
    FOREIGN KEY(Course_ID) REFERENCES Course (ID),
    FOREIGN KEY(FORM_ID) REFERENCES Form (ID)
    );

CREATE TABLE Form(

    ID int NOT NULL,
    Form_type_ID int NOT NULL,
    Teacher_ID int NOT NULL,
    Student_ID int NOT NULL,
    Form_date date NOT NULL,
    Course_ID int NOT NULL,
    PRIMARY KEY(FORM_ID),
    FOREIGN KEY(Form_type_ID) REFERENCES Formtype (ID),
    FOREIGN KEY(Student_ID) REFERENCES Student (ID),
    FOREIGN KEY(Teachert_ID) REFERENCES Teacher (ID),
    FOREIGN KEY(Course_ID) REFERENCES Course (ID),
    );

CREATE TABLE Formtype(
    ID int NOT NULL,
    Form_type Varchar(20),
    PRIMARY KEY(ID)
    );

CREATE TABLE Courses (
    ID INT NOT NULL,
    Course_Name VARCHAR(20),
    Description VARCHAR(50),
    Teacher_ID_FK INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (Teacher_ID_FK) REFERENCES Teacher(ID)
  );

CREATE TABLE Student_Request_Complain (
    ID INT NOT NULL,
    Request_ID_FK INT NOT NULL,
    Complain VARCHAR(20),
    PRIMARY KEY (ID),
    FOREIGN KEY (Request_ID_FK) REFERENCES Student_Request(Request_ID)
  );

CREATE TABLE Student(
    ID NOT NULL,
    First_Name VARCHAR(25),
    Last_Name VARCHAR(20),
    Email VARCHAR(30),
    Password VARCHAR(20),
    PRIMARY KEY(ID)
  );

CREATE TABLE Teacher(
    ID NOT NULL,
    First_Name VARCHAR(25),
    Last_Name VARCHAR(20),
    Email VARCHAR(30),
    Password VARCHAR(20),
    PRIMARY KEY(ID)
  );

CREATE TABLE Administrator(
    ID NOT NULL,
    First_Name VARCHAR(25),
    Last_Name VARCHAR(20),
    Email VARCHAR(30),
    Password VARCHAR(20),
    PRIMARY KEY(ID)
  );

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