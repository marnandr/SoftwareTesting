package hu.uni.miskolc.iit.model;

public class Administrator extends User {

    public Administrator(String lastName, String firstName, String password, String neptunCode, String email, long phoneNumber) {
        super(lastName, firstName, password, neptunCode, email, phoneNumber);
    }
}
