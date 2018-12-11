package hu.uni.miskolc.iit;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.impl.StudentServiceDaoFileImpl;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class StudentServiceDaoFileTest {

    private StudentServiceDao studentServiceDao = new StudentServiceDaoFileImpl();

    @Before
    public void initDB() throws IOException {
        FileUtils.copyFile(new File("src/main/resources/testDB.xml"), new File("testDB.xml"));
    }


    @Test
    public void checkRequestStatusValidData() throws RequestDoesNotExistException {
        String status = studentServiceDao.checkRequestStatus(0);
        assertTrue(status.equals("Accepted"));
    }


    @Test(expected = RequestDoesNotExistException.class)
    public void checkRequestStatusRequestDoesNotExist() throws RequestDoesNotExistException {
        String status = studentServiceDao.checkRequestStatus(4);
    }


    @Test
    public void createComplainValidData() throws RequestDoesNotExistException, ComplainAlreadyExistsException {
        studentServiceDao.createComplain(0, "Long complaint text");
        assertTrue(true);
    }


    @Test(expected = IllegalArgumentException.class)
    public void createComplainEmptyComplaint() throws RequestDoesNotExistException, ComplainAlreadyExistsException {
        studentServiceDao.createComplain(2, "");
    }


    @Test(expected = RequestDoesNotExistException.class)
    public void RequestComplainAlreadyExists() throws RequestDoesNotExistException, ComplainAlreadyExistsException {
        studentServiceDao.createComplain(4, "Long complaint text");
    }
}
