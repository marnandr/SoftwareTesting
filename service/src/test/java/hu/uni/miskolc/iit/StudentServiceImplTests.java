package hu.uni.miskolc.iit;

import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.service.StudentService;
import hu.uni.miskolc.iit.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTests {

    private StudentService studentService = new StudentServiceImpl();

    @Test
    public void getAllCoursesTest() {
        List<Course> allCourses = studentService.getAllCourses();
        assertTrue(allCourses.size() > 0);
    }


    @Test
    public void getAllForms() {
    }

    @Test
    public void createNewRequest() {
    }

    @Test
    public void checkRequestStatus() {
    }

}
