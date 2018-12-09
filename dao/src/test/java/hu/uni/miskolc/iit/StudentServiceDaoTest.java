package hu.uni.miskolc.iit;


import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.impl.StudentServiceDaoImpl;
import hu.uni.miskolc.iit.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={Config.class})
public class StudentServiceDaoTest {

    private StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();

    @Test
    public void studentServiceDaoTest() {
        List<Course> allCourses = studentServiceDao.findAllCourses();
        assertTrue(allCourses.size() > 0);
    }

    @Test
    public void findAllForms() {
    }

    @Test
    public void setDataSource() {
    }

    @Test
    public void createRequest() {
    }

    @Test
    public void findAllRequests() {
    }

    @Test
    public void checkRequestStatus() throws RequestDoesNotExistException {
       String str = studentServiceDao.checkRequestStatus(2);
       assertTrue(str == "status");
    }

    @Test
    public void createComplain() throws RequestDoesNotExistException, ComplainAlreadyExistsException {
        studentServiceDao.createComplain(3, "Long complaint text");
        assertTrue(true);
    }

}
