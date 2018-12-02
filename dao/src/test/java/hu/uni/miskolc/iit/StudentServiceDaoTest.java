package hu.uni.miskolc.iit;


import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.impl.StudentServiceDaoImpl;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
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
       boolean requests = studentServiceDao.checkRequestStatus(2, true);
       assertTrue(requests);
    }

    @Test
    public void createComplain() {
        studentServiceDao.createComplain(3,3, "Long complaint text");
        assertTrue(true);
    }

}
