package hu.uni.miskolc.iit;

import hu.uni.miskolc.iit.dao.UserDao;
import hu.uni.miskolc.iit.exceptions.UserAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.UserDoesNotExistException;
import hu.uni.miskolc.iit.impl.UserDaoImpl;
import hu.uni.miskolc.iit.model.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserDaoTest {

    private UserDao userDao;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() throws UserAlreadyExistException {
        userDao = new UserDaoImpl();
        userDao.createUser("Doe","John","abc","111111","j.smith@email.com",111111);
        userDao.createUser("Doe","Jane","abc","ABC123","j.smith@email.com",222222);
    }

    @Test
    public void createUserTest() throws UserAlreadyExistException {
        userDao.createUser("Smith","John","abc","AAA111","j.smith@email.com",333333);

    }

    @Test (expected = UserAlreadyExistException.class)
    public void createUserTestWithWrongAlreadyExistingUser() throws UserAlreadyExistException {
        userDao.createUser("Smith","John","abc","111111","j.smith@email.com",111111);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createUserTestWithWrongValues() throws IllegalArgumentException, UserAlreadyExistException {
        userDao.createUser("Smith","John","abc","thisIsAWrongCode","j.smith@email.com",111111);
    }

    @Test
    public void deleteUserTest() throws UserDoesNotExistException {
        userDao.deleteUser("ABC123");
    }

    @Test (expected = UserDoesNotExistException.class)
    public void deleteUserTestWithWrongValues() throws UserDoesNotExistException {
        userDao.deleteUser("ZZZZZZ");
    }

    @Test (expected = UserDoesNotExistException.class)
    public void deleteUserTestWithNull() throws UserDoesNotExistException {
        userDao.deleteUser(null);
    }

    @Test
    public void modifyUserTest() throws UserDoesNotExistException {
        User modifiedUser = new User("HusbandsName","Jane","abc","ABC123","j.smith@email.com",222222);
        userDao.modifyUser(modifiedUser);

    }

    @Test (expected = UserDoesNotExistException.class)
    public void modifyUserTestWithWrongValues() throws UserDoesNotExistException {
        User modifiedUser = new User("HusbandsName","Jane","abc","wrngID","j.smith@email.com",222222);
        userDao.modifyUser(modifiedUser);

    }

    @Test (expected = UserDoesNotExistException.class)
    public void modifyUserTestWithNull() throws UserDoesNotExistException {
        userDao.modifyUser(null);
    }

    @Test
    public void findUserByIDTest() throws UserDoesNotExistException {
        userDao.findUserByID("ABC123");

    }

    @Test (expected = UserDoesNotExistException.class)
    public void findUserByIDTestWithWrongValue() throws UserDoesNotExistException {
        userDao.findUserByID("ZZZZZZ");
    }

    @Test (expected = UserDoesNotExistException.class)
    public void findUserByIDTestWithNull() throws UserDoesNotExistException {
        userDao.findUserByID(null);
    }

}
