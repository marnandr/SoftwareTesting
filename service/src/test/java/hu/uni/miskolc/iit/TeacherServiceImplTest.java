package hu.uni.miskolc.iit;


import hu.uni.miskolc.iit.dao.CourseDao;
import hu.uni.miskolc.iit.dao.FormDao;
import hu.uni.miskolc.iit.dao.TeacherServiceDao;
import hu.uni.miskolc.iit.dao.UserDao;
import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;
import hu.uni.miskolc.iit.service.TeacherService;
import hu.uni.miskolc.iit.service.impl.TeacherServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

public class TeacherServiceImplTest {

    @Mock
    private CourseDao courseDaoMock;

    @Mock
    private FormDao formDaoMock;

    @Mock
    private UserDao userDaoMock;

    @InjectMocks
    private TeacherService teacherService;

    private Student student1;
    private Teacher teacher1;
    private Course course1;
    private Student student2;
    private Teacher teacher2;
    private Course course2;
    private Form form1;

    @Before
    public void setUp() throws Exception {
        teacherService = new TeacherServiceImpl(formDaoMock,courseDaoMock,userDaoMock);

        MockitoAnnotations.initMocks(this);

        this.student1 = new Student("Student","One","abc","SSS111","j.smith@email.com",111111);
        this.teacher1 = new Teacher("Teacher","One","abc","TTT111","j.smith@email.com",111111);
        this.course1 = new Course("Matek1", "Matematika 1.", "Introduction to Mathematics", "TTT111");

        this.student2 = new Student("Student","Two","abc","SSS222","j.smith@email.com",111111);
        this.teacher2 = new Teacher("Teacher","Two","abc","TTT222","j.smith@email.com",111111);
        this.course2 = new Course("Matek2", "Matematika 2.", "Intermediate  Mathematics", "TTT222");

        form1 = new Form(1,student1,teacher1,course1,"Please let me retake the course", FormTypes.RETAKE_EXAM);
        teacherService.createForm(1,student1,teacher1,course1,"Please let me retake the course", FormTypes.RETAKE_EXAM);
    }

    @Test
    public void createFormTest() throws CourseDoesNotExistException, FormAlreadyExistsExeption, TeacherNotFoundException, StudentNotFoundException {
        teacherService.createForm(2,student2,teacher2,course2,"Please let me retake the class", FormTypes.RETAKE_LECTURE);
    }

    @Test
    public void forwardFormTest() throws CourseDoesNotExistException, FormNotFoundException, StudentNotFoundException, TeacherNotFoundException, UserDoesNotExistException {
        String teacherID = "TTT111";
        teacherService.forwardForm(form1, teacherID);
    }

    @Test
    public void getFormsTest() throws FormNotFoundException {
        List<Form> forms = new ArrayList<>();
        forms.add(new Form(2,student2,teacher2,course2,"Please let me retake the class", FormTypes.RETAKE_LECTURE));

        doReturn(forms).when(formDaoMock).getForms();
        assertEquals(forms, teacherService.getForms());
    }

    @Test
    public void getFormsTestWithWrongValue() throws FormNotFoundException {
        List<Form> forms = new ArrayList<>();
        forms.add(new Form(2,student2,teacher2,course2,"Please let me retake the class", FormTypes.RETAKE_LECTURE));
        List<Form> forms2 = new ArrayList<>();
        forms2.add(new Form(3,student2,teacher2,course2,"Please let me retake the class", FormTypes.RETAKE_LECTURE));

        doReturn(forms2).when(formDaoMock).getForms();
        assertFalse(forms.equals(teacherService.getForms()));
    }

    @Test
    public void getCoursesTest() throws CourseDoesNotExistException {
        List<Course> courses = new ArrayList<>();
        courses.add(course1);

        doReturn(courses).when(courseDaoMock).getAllCourses();
        assertEquals(courses,teacherService.getCourses());
    }

    @Test
    public void getCoursesTestWithWrongValues() throws CourseDoesNotExistException {
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        List<Course> courses2 = new ArrayList<>();
        courses2.add(course2);

        doReturn(courses2).when(courseDaoMock).getAllCourses();
        assertFalse(teacherService.getCourses().equals(courses));
    }

    @Test
    public void findThatTeachersFormsTest() throws FormNotFoundException, UserDoesNotExistException, TeacherNotFoundException {
        List<Form> forms = new ArrayList<>();
        forms.add(new Form(2,student2,teacher2,course2,"Please let me retake the class", FormTypes.RETAKE_LECTURE));

        doReturn(forms).when(formDaoMock).findFormsByUser(userDaoMock,"TTT222");
        assertEquals(forms, teacherService.findThatTeachersForms("TTT222"));
    }

    @Test
    public void findThatTeachersFormsTestWithWrongValues() throws FormNotFoundException, UserDoesNotExistException, TeacherNotFoundException {
        List<Form> forms = new ArrayList<>();
        forms.add(new Form(2,student2,teacher2,course2,"Please let me retake the class", FormTypes.RETAKE_LECTURE));
        List<Form> forms2 = new ArrayList<>();
        forms2.add(new Form(3,student2,teacher2,course2,"Please let me retake the class", FormTypes.RETAKE_LECTURE));

        doReturn(forms2).when(formDaoMock).findFormsByUser(userDaoMock,"TTT222");
        assertFalse(teacherService.findThatTeachersForms("TTT222").equals(forms));
    }

    @Test
    public void findFormsByCourseTest() throws FormNotFoundException, CourseDoesNotExistException {
        List<Form> forms = new ArrayList<>();
        forms.add(new Form(2,student2,teacher2,course2,"Please let me retake the class", FormTypes.RETAKE_LECTURE));

        doReturn(forms).when(formDaoMock).findFormsByCourse(courseDaoMock,"Matek2");
        assertEquals(forms, teacherService.findFormsByCourse("Matek2"));
    }

    @Test
    public void findFormsByCourseTestWithWrongValues() throws FormNotFoundException, CourseDoesNotExistException {
        List<Form> forms = new ArrayList<>();
        forms.add(new Form(2,student2,teacher2,course2,"Please let me retake the class", FormTypes.RETAKE_LECTURE));
        List<Form> forms2 = new ArrayList<>();
        forms2.add(new Form(3,student2,teacher2,course2,"Please let me retake the class", FormTypes.RETAKE_LECTURE));

        doReturn(forms2).when(formDaoMock).findFormsByCourse(courseDaoMock,"Matek2");
        assertFalse(teacherService.findFormsByCourse("Matek2").equals(forms));
    }


}
