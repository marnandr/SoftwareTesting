package hu.uni.miskolc.iit;


import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.impl.StudentServiceDaoImpl;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

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
    public void findAllFormsTest() {
        List<Form> allForms  = studentServiceDao.findAllForms();
        assertTrue(allForms.size() > 0);
    }

    /*@Test
    public void setDataSourceTest() {

    }*/

    @Test
    public void createRequestTest() {
        Request savedRequest = studentServiceDao.createRequest(1,2,3, "REQUESTED", "RETAKE_EXAM");
        Request requestFromDb = studentServiceDao.findRequestById(savedRequest.getRequestID());
        assertEquals(savedRequest.getRequestID(), requestFromDb.getRequestID());
        assertEquals(savedRequest.getStudentID(), requestFromDb.getStudentID());
    }

    @Test
    public void findAllRequestsTest() {
        List<Request> allRequests = studentServiceDao.findAllRequest();
        assertTrue(allRequests.size() > 0);
    }

    @Test
    public void chechkRequestStatus() {
    }

}
