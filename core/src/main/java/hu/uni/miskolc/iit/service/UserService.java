package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.exceptions.*;

public interface UserService {
    /**
     * @param lastName
     * @param firstName
     * @param email
     * @param password
     */
    public void userRegistration(String lastName, String firstName, String email, String password) throws UserAlreadyExistException;

    /**
     * @param user
     * @param password
     * @return
     */
    public boolean logger(String user, String password) throws UserCanNotLogin;

    /**
     * @param lastName
     * @param firstName
     * @param email
     * @param password
     */
    public void userModification(String lastName, String firstName, String email, String password) throws UserDoesNotExistException;

    /**
     * @param user
     */
    public void userDelete(String user) throws UserDoesNotExistException;

}