package hu.uni.miskolc.iit;

import hu.uni.miskolc.iit.dao.TeacherServiceDao;
import hu.uni.miskolc.iit.exceptions.FormAlreadyExistsExeption;
import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.FormTypes;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import hu.uni.miskolc.iit.impl.TeacherServiceDaoImpl;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TeacherServiceDaoTest {

    private TeacherServiceDao teacherServiceDao;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp(){
        teacherServiceDao = new TeacherServiceDaoImpl();
    }

    @Test
    public void getFormsTest(){
        List<Form> allForms = teacherServiceDao.getForms();
        assertTrue(allForms.size()>0);
    }

    @Test
    public void createFormTest() throws FormAlreadyExistsExeption {
        teacherServiceDao.createForm(3,"abc111","teacher1","matek101","please let me retake the exam", FormTypes.RETAKE_EXAM);

    }

    @Test (expected = FormAlreadyExistsExeption.class)
    public void createFormTestWithWrongValues() throws FormAlreadyExistsExeption {
        teacherServiceDao.createForm(1,"abc111","teacher1","matek101","please let me retake the exam", FormTypes.RETAKE_EXAM);
    }

    @Test
    public void fowardFormTest() throws FormDoesNotExistException {
        teacherServiceDao.forwardForm(2,"teacher3");
    }

    @Test (expected = FormDoesNotExistException.class)
    public void forwardFormTestWithWrongValues() throws FormDoesNotExistException {
        teacherServiceDao.forwardForm(132,"teacher3");
    }

    @Test
    public void findThatTeachersFormsTest() throws FormNotFoundException {
        teacherServiceDao.findThatTeachersForms("teacher1");
    }

    @Test (expected = FormNotFoundException.class)
    public void findThatTeachersFormsTestWithWrongValues() throws FormNotFoundException {
        teacherServiceDao.findThatTeachersForms("notATeacher");
    }

    @Test
    public void findFormsByCourseTest() throws FormNotFoundException {
        teacherServiceDao.findFormsByCourse("matek101");
    }

    @Test (expected = FormNotFoundException.class)
    public void findFormsByCourseTestWithWrongValue() throws FormNotFoundException {
        teacherServiceDao.findFormsByCourse("notACourse");
    }


}
