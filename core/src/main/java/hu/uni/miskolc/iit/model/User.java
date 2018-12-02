package hu.uni.miskolc.iit.model;

import javax.validation.constraints.NotNull;

public class User {

    @NotNull
    private String lastName;

    @NotNull
    private String firstName;

    @NotNull
    private String password;

    @NotNull
    private String neptunCode;

    @NotNull
    private String email;

    @NotNull
    private long phoneNumber;


    public User(String lastName, String firstName, String password, String neptunCode, String email, long phoneNumber) {
        checkName(lastName);
        this.lastName = lastName;
        checkName(firstName);
        this.firstName = firstName;
        checkPassword(password);
        this.password = password;
        checkNeptunCode(neptunCode);
        this.neptunCode = neptunCode;
        checkEmail(email);
        this.email = email;
        checkPhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        checkName(lastName);
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        checkName(firstName);
        this.firstName = firstName;
    }

    public String getNeptunCode() {
        return neptunCode;
    }

    public void setNeptunCode(String neptunCode) {
        checkNeptunCode(neptunCode);
        this.neptunCode = neptunCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        checkEmail(email);
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        checkPhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        checkPassword(password);
        this.password = password;
    }

    public void checkNeptunCode(String neptunCode) {
        if (neptunCode.length() != 6) {
            throw new IllegalArgumentException("Invalid neptun code");
        }
    }

    public void checkName(String name) {
        if (name == null || name == "") {
            throw new IllegalArgumentException("The name can't be null");
        }
    }

    public void checkEmail(String email) {
        if (email == null || email == "") {
            throw new IllegalArgumentException("The email can't be null");
        }
    }

    public void checkPassword(String psw) {
        if (psw == null || psw == "") {
            throw new IllegalArgumentException("The password can't be null");
        }
    }

    public void checkPhoneNumber(long num) {
        long length = 1 + (long) Math.floor(Math.log10(num));
        if (length != 6) {
            throw new IllegalArgumentException("The phone number must be 6 characters long, now it is: " + length);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", neptunCode='" + neptunCode + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

