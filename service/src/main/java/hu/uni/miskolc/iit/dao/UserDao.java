package hu.uni.miskolc.iit.dao;

import hu.uni.miskolc.iit.exceptions.CourseDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.UserAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.UserDoesNotExistException;
import hu.uni.miskolc.iit.model.User;

import java.util.List;

public interface UserDao {

    void createUser(User user) throws UserAlreadyExistException, IllegalArgumentException;
    void deleteUser(String userID) throws UserDoesNotExistException;
    void modifyUser(String userID) throws UserAlreadyExistException, IllegalArgumentException;
    List<User> getAllUsers();
    List<User> findUserByID(String userID) throws UserDoesNotExistException;
    List<User> searchUserByCourse (String courseID) throws CourseDoesNotExistException;

}
