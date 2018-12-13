package hu.uni.miskolc.iit.dao;

import hu.uni.miskolc.iit.exceptions.CourseDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.UserAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.UserDoesNotExistException;
import hu.uni.miskolc.iit.model.User;

import java.util.List;

public interface UserDao {

    void createUser(String lastName, String firstName, String password, String neptunCode, String email, long phoneNumber) throws UserAlreadyExistException, IllegalArgumentException;
    void deleteUser(String userID) throws UserDoesNotExistException;
    void modifyUser(User user) throws UserDoesNotExistException, IllegalArgumentException;
    List<User> getAllUsers();
    User findUserByID(String userID) throws UserDoesNotExistException;
}
