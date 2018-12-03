package hu.uni.miskolc.iit;


import hu.uni.miskolc.iit.dao.AdministratorServiceDao;
import hu.uni.miskolc.iit.impl.AdministratorServiceDaoImpl;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.Request;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorServiceDaoTest {

    private AdministratorServiceDao adminServiceDao = new AdministratorServiceDaoImpl();

    @Test
    public void findAllRequestTest() {
        List<Form> allRequests = adminServiceDao.findAllRequest();
        assertTrue(allRequests.size() > 0);
    }

    @Test
    public void managaFormTypesTest() {
        List<Form> allRequests = adminServiceDao.findAllRequest();
        adminServiceDao.managaFormTypes("Retake exam", 002);
        List<Form> allRequestsModif = adminServiceDao.findAllRequest();
        Assert.assertNotEquals(allRequests, allRequestsModif);
    }
    @Test
    public void manageComplainsTest(){
        List<Form> allRequests = adminServiceDao.findAllRequest();
        adminServiceDao.manageComplains("I have done the exam", 001);
        List<Form> allRequestsModif = adminServiceDao.findAllRequest();
        Assert.assertNotEquals(allRequests, allRequestsModif);
    }
}
