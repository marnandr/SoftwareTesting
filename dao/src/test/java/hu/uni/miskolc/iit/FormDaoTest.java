package hu.uni.miskolc.iit;

import hu.uni.miskolc.iit.dao.CourseDao;
import hu.uni.miskolc.iit.dao.FormDao;
import hu.uni.miskolc.iit.dao.UserDao;
import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.impl.FormDaoImpl;
import hu.uni.miskolc.iit.model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doReturn;

public class FormDaoTest {

    @Mock
    private UserDao userDaoMock;

    @Mock
    private CourseDao courseDaoMock;

    @InjectMocks
    private FormDao formDao;

    private User testUser;
    private Student student1;
    private Teacher teacher1;
    private Course course1;
    private Student student2;
    private Teacher teacher2;
    private Course course2;
    private Form form1;


    @Before
    public void setUp() throws CourseDoesNotExistException, FormAlreadyExistsExeption, TeacherNotFoundException, StudentNotFoundException {
        formDao = new FormDaoImpl();

        this.student1 = new Student("Student","One","abc","SSS111","j.smith@email.com",111111);
        this.teacher1 = new Teacher("Teacher","One","abc","TTT111","j.smith@email.com",111111);
        this.course1 = new Course("Matek1", "Matematika 1.", "Introduction to Mathematics", "TTT111");

        form1 = new Form(1,student1,teacher1,course1,"Please let me retake the course", FormTypes.RETAKE_EXAM);
        formDao.createForm(1,student1,teacher1,course1,"Please let me retake the course", FormTypes.RETAKE_EXAM);


        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createFormTest() throws CourseDoesNotExistException, FormAlreadyExistsExeption, TeacherNotFoundException, StudentNotFoundException {
        this.student2 = new Student("Student","Two","abc","SSS222","j.smith@email.com",111111);
        this.teacher2 = new Teacher("Teacher","Two","abc","TTT222","j.smith@email.com",111111);
        this.course2 = new Course("Matek2", "Matematika 2.", "Intermediate  Mathematics", "TTT222");
        formDao.createForm(2,student2,teacher2,course2,"Please let me retake the class", FormTypes.RETAKE_LECTURE);
    }

    @Test (expected = FormAlreadyExistsExeption.class)
    public void createFormTestWithWrongValues() throws CourseDoesNotExistException, FormAlreadyExistsExeption, TeacherNotFoundException, StudentNotFoundException {
        formDao.createForm(1,student1,teacher1,course1,"Please let me retake the course", FormTypes.RETAKE_EXAM);

    }


    @Test
    public void modifyFormTest() throws UserDoesNotExistException, CourseDoesNotExistException, FormNotFoundException, StudentNotFoundException, TeacherNotFoundException {
        Form formToModify = new Form(1,student1,teacher1,course1,"Pretty please let me retake the course", FormTypes.RETAKE_EXAM);
        formDao.modifyForm(formToModify);
    }

    @Test (expected = FormNotFoundException.class)
    public void modifyFormWithWrongValues() throws UserDoesNotExistException, CourseDoesNotExistException, FormNotFoundException, StudentNotFoundException, TeacherNotFoundException {
        Form formToModify = new Form(-1,student1,teacher1,course1,"Pretty please let me retake the course", FormTypes.RETAKE_EXAM);
        formDao.modifyForm(formToModify);

    }

    @Test (expected = FormNotFoundException.class)
    public void modifyFormWithNull() throws UserDoesNotExistException, CourseDoesNotExistException, FormNotFoundException, StudentNotFoundException, TeacherNotFoundException {
        formDao.modifyForm(null);

    }

    @Test
    public void forwardFormTest() throws UserDoesNotExistException, CourseDoesNotExistException, FormNotFoundException, StudentNotFoundException, TeacherNotFoundException {
        String teacherID = "TTT111";
        doReturn(teacher1).when(userDaoMock).findUserByID(teacherID);

        formDao.forwardForm( userDaoMock,form1,"TTT222");
    }

    @Test (expected = FormNotFoundException.class)
    public void forwardFormWithWrongValues() throws UserDoesNotExistException, CourseDoesNotExistException, FormNotFoundException, StudentNotFoundException, TeacherNotFoundException {
        String teacherID = "TTT111";
        doReturn(teacher1).when(userDaoMock).findUserByID(teacherID);
        Form formToForward = new Form(100,student1,teacher1,course1,"Please let me retake the course", FormTypes.RETAKE_EXAM); //we didn't save this form to the db

        formDao.forwardForm( userDaoMock,formToForward,"TTT222");

    }

    @Test (expected = FormNotFoundException.class)
    public void forwardFormWithNull() throws UserDoesNotExistException, CourseDoesNotExistException, FormNotFoundException, StudentNotFoundException, TeacherNotFoundException {
        String teacherID = "TTT111";
        doReturn(teacher1).when(userDaoMock).findUserByID(teacherID);

        formDao.forwardForm( userDaoMock,null,"TTT222");

    }

    @Test
    public void findFormsByUserTest() throws UserDoesNotExistException, FormNotFoundException {
        String userID = "SSS111";
        doReturn(student1).when(userDaoMock).findUserByID(userID);

        formDao.findFormsByUser(userDaoMock, userID);
    }

    @Test (expected = FormNotFoundException.class)
    public void findFormsByUserWithWrongValues() throws UserDoesNotExistException, FormNotFoundException {
        String teacherID = "NOCODE";
        doReturn(teacher1).when(userDaoMock).findUserByID(teacherID);

        formDao.findFormsByUser(userDaoMock, teacherID);
    }

    @Test (expected = FormNotFoundException.class)
    public void findFormsByUserWithNull() throws UserDoesNotExistException, FormNotFoundException {
        String teacherID = "TTT222";
        doReturn(teacher2).when(userDaoMock).findUserByID(teacherID);

        formDao.findFormsByUser(userDaoMock, null);
    }

    @Test
    public void findFormsByCourseFormTest() throws CourseDoesNotExistException, FormNotFoundException {
        String courseID = "Matek1";
        doReturn(course1).when(courseDaoMock).findCourseByID(courseID);
        formDao.findFormsByCourse(courseDaoMock, courseID);

    }

    @Test (expected = FormNotFoundException.class)
    public void findFormsByCourseWithWrongValues() throws CourseDoesNotExistException, FormNotFoundException {
        String courseID = "NOCODE";
        doReturn(course1).when(courseDaoMock).findCourseByID(courseID);
        formDao.findFormsByCourse(courseDaoMock, courseID);

    }

    @Test (expected = FormNotFoundException.class)
    public void findFormsByCourseWithNull() throws CourseDoesNotExistException, FormNotFoundException {
        String courseID = "Matek1";
        doReturn(course1).when(courseDaoMock).findCourseByID(courseID);
        formDao.findFormsByCourse(courseDaoMock, null);

    }

    @Test
    public void findFormsByStatusFormTest() throws FormNotFoundException {
        formDao.findFormsByStatus(Form.formState.OPEN);
    }

    @Test (expected = FormNotFoundException.class)
    public void findFormsByStatusWithWrongValues() throws FormNotFoundException {
        formDao.findFormsByStatus(Form.formState.REOPENED);

    }

    @Test (expected = FormNotFoundException.class)
    public void findFormsByStatusWithNull() throws FormNotFoundException {
        formDao.findFormsByStatus(null);
    }

    @Test
    public void deleteFormTest() throws FormNotFoundException {
        formDao.deleteForm(1);

    }

    @Test (expected = FormNotFoundException.class)
    public void deleteFormWithWrongValues() throws FormNotFoundException {
        formDao.deleteForm(-1);

    }

}
