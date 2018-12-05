package hu.uni.miskolc.iit;


import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Request;
import hu.uni.miskolc.iit.service.AdministratorService;
import hu.uni.miskolc.iit.service.impl.AdministratorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorServiceImplTest {

    private AdministratorService adminService = new AdministratorServiceImpl();

    @Test
    public void findAllRequestTest() {
        //List<Request> allRequests = adminService.findAllRequest();
        //assertTrue(allRequests.size() > 0);
    }

    @Test
    public void manageFormTypesTest(){

    }

    @Test
    public void manageComplainsTest(){

    }
}
