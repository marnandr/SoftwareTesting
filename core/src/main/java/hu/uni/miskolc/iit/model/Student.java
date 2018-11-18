package hu.uni.miskolc.iit.model;

import java.util.Date;

public class Student extends User {

    private Date startOfStudies;
    private Faculty faculty;

    public Student(String lastName, String firstName, String password, String neptunCode, String email, long phoneNumber, Date startOfStudies, Faculty factulty) {
        super(lastName, firstName, password, neptunCode, email, phoneNumber);
        this.faculty = factulty;
        this.startOfStudies = startOfStudies;
    }

    public Date getStartOfStudies() {
        return startOfStudies;
    }

    public void setStartOfStudies(Date startOfStudies) {
        this.startOfStudies = startOfStudies;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
