package hu.uni.miskolc.iit;


import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.impl.StudentServiceDaoImpl;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
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
    public void findAllFormsTest() {
        List<Form> allForms  = studentServiceDao.findAllForms();
        assertTrue(allForms.size() > 0);
    }

    /*@Test
    public void setDataSourceTest() {

    }*/

    /*
    @Test
    public void createRequestTest() {
        Form savedRequest = studentServiceDao.createRequest(1,2,3, "REQUESTED", "RETAKE_EXAM");
        Form requestFromDb = studentServiceDao.findRequestById(savedRequest.getRequestID());
        assertEquals(savedRequest.getRequestID(), requestFromDb.getRequestID());
        assertEquals(savedRequest.getStudentID(), requestFromDb.getStudentID());
    }
*/
    @Test
    public void findAllRequestsTest() {
        List<Form> allRequests = studentServiceDao.findAllForms();
        assertTrue(allRequests.size() > 0);
    }

    @Test
    public void chechkRequestStatus() {
    }

}
