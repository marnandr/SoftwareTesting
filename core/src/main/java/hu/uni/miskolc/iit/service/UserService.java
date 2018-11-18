package hu.uni.miskolc.iit.service;
import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.*;

public interface UserService {

    public void userRegistration(String lastName, String firstName,  String email, String password);
    public boolean logger(String user, String password);
    public void userModification(String lastName, String firstName,  String email, String password));
    public void userDelete(String user);

}