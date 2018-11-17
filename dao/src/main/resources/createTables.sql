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
