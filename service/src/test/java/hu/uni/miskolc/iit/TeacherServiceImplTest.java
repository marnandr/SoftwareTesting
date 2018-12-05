package hu.uni.miskolc.iit;


import hu.uni.miskolc.iit.dao.TeacherServiceDao;
import hu.uni.miskolc.iit.exceptions.FormAlreadyExistsExeption;
import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.FormTypes;
import hu.uni.miskolc.iit.service.TeacherService;
import hu.uni.miskolc.iit.service.impl.TeacherServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TeacherServiceImplTest {

    @Mock
    private TeacherServiceDao teacherServiceDaoMock;

    @InjectMocks
    private TeacherServiceImpl teacherService;

    public TeacherServiceImplTest(){
        super();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createFormTest() throws FormAlreadyExistsExeption {
        teacherService.createForm(4,"abc111","teacher1","matek101","please let me retake the exam", FormTypes.RETAKE_EXAM);
    }

    @Test
    public void forwardFormTest() throws FormDoesNotExistException {
        teacherService.forwardForm(1,"teacher1");
    }

    @Test
    public void getFormsTest(){
        List<Form> forms = new ArrayList<>();
        forms.add(new Form(5,"abc112","teacher3","matek102","please let me retake the exam", FormTypes.RETAKE_EXAM));

        doReturn(forms).when(teacherServiceDaoMock).getForms();
        assertEquals(forms, teacherService.getForms());
    }

    @Test
    public void findThatTeachersFormsTest() throws FormNotFoundException {
        List<Form> forms = new ArrayList<>();
        forms.add(new Form(7,"abc112","teacher1","matek101","please let me retake the exam", FormTypes.RETAKE_EXAM));

        doReturn(forms).when(teacherServiceDaoMock).findThatTeachersForms("teacher1");
        assertEquals(forms, teacherService.findThatTeachersForms("teacher1"));
    }

    @Test
    public void findFormsByCourseTest() throws FormNotFoundException {
        List<Form> forms = new ArrayList<>();
        forms.add(new Form(7,"abc112","teacher1","matek101","please let me retake the exam", FormTypes.RETAKE_EXAM));

        doReturn(forms).when(teacherServiceDaoMock).findFormsByCourse("matek101");
        assertEquals(forms, teacherService.findFormsByCourse("matek101"));
    }


}
