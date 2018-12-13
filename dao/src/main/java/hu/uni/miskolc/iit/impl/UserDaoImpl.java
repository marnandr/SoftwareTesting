package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.UserDao;
import hu.uni.miskolc.iit.exceptions.CourseDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.UserAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.UserDoesNotExistException;
import hu.uni.miskolc.iit.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private List<User> users;

    public UserDaoImpl(){
        users = new ArrayList<>();
    }

    @Override
    public void createUser(String lastName, String firstName, String password, String neptunCode, String email, long phoneNumber) throws UserAlreadyExistException, IllegalArgumentException{
        boolean alreadyExists = false;
        for (User user:users){
            if(user.getNeptunCode()==neptunCode){
                alreadyExists = true;
            }
        }
        if(!alreadyExists){
            users.add(new User(lastName, firstName, password, neptunCode, email, phoneNumber));
        }
        else{
            throw new UserAlreadyExistException();
        }
    }

    @Override
    public void deleteUser(String userID) throws UserDoesNotExistException {
        boolean found = false;
        int userToDeleteIndex = -1;
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getNeptunCode()==userID){
                found = true;
                userToDeleteIndex = i;
                break;
            }
        }
        if(found){
            users.remove(userToDeleteIndex);
        }
        else{
            throw new UserDoesNotExistException();
        }
    }

    @Override
    public void modifyUser(User user) throws UserDoesNotExistException, IllegalArgumentException {
        if(user == null){
            throw new UserDoesNotExistException();
        }
        boolean found = false;
        int userToModifyIndex = -1;
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getNeptunCode()==user.getNeptunCode()){
                found = true;
                userToModifyIndex = i;
                break;
            }
        }
        if(found){
            users.set(userToModifyIndex,user);
        }
        else{
            throw new UserDoesNotExistException();
        }

    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User findUserByID(String userID) throws UserDoesNotExistException {
        User userToReturn;
        for (User user:users){
            if(user.getNeptunCode()==userID){
                userToReturn = user;
                return userToReturn;
            }
        }
        throw new UserDoesNotExistException();
    }
}
