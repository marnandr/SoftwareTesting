package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.UserDao;
import hu.uni.miskolc.iit.exceptions.CourseDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.UserAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.UserDoesNotExistException;
import hu.uni.miskolc.iit.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void createUser(User user) throws UserAlreadyExistException, IllegalArgumentException {

    }

    @Override
    public void deleteUser(String userID) throws UserDoesNotExistException {

    }

    @Override
    public void modifyUser(String userID) throws UserAlreadyExistException, IllegalArgumentException {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> findUserByID(String userID) throws UserDoesNotExistException {
        return null;
    }

    @Override
    public List<User> searchUserByCourse(String courseID) throws CourseDoesNotExistException {
        return null;
    }
}
