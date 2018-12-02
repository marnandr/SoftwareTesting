package hu.uni.miskolc.iit;


import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.service.TeacherService;
import hu.uni.miskolc.iit.service.impl.TeacherServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceImplTest {


    private TeacherService teacherService = new TeacherServiceImpl();

    @Test
    public void getAllCoursesTest() {
        List<Form> allForms = teacherService.getForms();
        assertTrue(allForms.size() > 0);
    }


}
