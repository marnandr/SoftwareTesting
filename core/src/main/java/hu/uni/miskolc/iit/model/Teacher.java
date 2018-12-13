package hu.uni.miskolc.iit.model;

public class Teacher extends User {
    private Faculty faculty;

    public Teacher(String lastName, String firstName, String password, String neptunCode, String email, long phoneNumber){
        super(lastName, firstName, password, neptunCode, email, phoneNumber);
    }
    public Teacher(String lastName, String firstName, String password, String neptunCode, String email, long phoneNumber, Faculty faculty) {
        super(lastName, firstName, password, neptunCode, email, phoneNumber);
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
