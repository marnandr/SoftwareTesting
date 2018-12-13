package hu.uni.miskolc.iit;

import hu.uni.miskolc.iit.dao.CourseDao;
import hu.uni.miskolc.iit.dao.UserDao;
import hu.uni.miskolc.iit.exceptions.CourseAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.CourseDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.UserDoesNotExistException;
import hu.uni.miskolc.iit.impl.CourseDaoImpl;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Teacher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doReturn;

public class CourseDaoTest {

    @Mock
    private UserDao userDaoMock;

    @InjectMocks
    private CourseDao courseDao;

    private Teacher teacher1;
    private Teacher teacher2;

    @Before
    public void setUp() throws UserDoesNotExistException, CourseAlreadyExistException {
        courseDao = new CourseDaoImpl();
        MockitoAnnotations.initMocks(this);

        this.teacher1 = new Teacher("Teacher","One","abc","TTT111","j.smith@email.com",111111);
        this.teacher2 = new Teacher("Teacher","Two","abc","TTT222","j.smith@email.com",111111);

        String teacherID = "TTT111";
        doReturn(teacher1).when(userDaoMock).findUserByID(teacherID);
        courseDao.createCourse(userDaoMock,"Matek1", "Matematika 1.", "Introduction to Mathematics", "TTT111");

    }

    @Test
    public void createCourseTest() throws UserDoesNotExistException, CourseAlreadyExistException {
        String teacherID = "TTT222";
        this.teacher2 = new Teacher("Teacher","Two","abc","TTT222","j.smith@email.com",111111);
        doReturn(teacher2).when(userDaoMock).findUserByID(teacherID);
        courseDao.createCourse(userDaoMock,"Matek2", "Matematika 2.", "Intermediate  Mathematics", teacherID);

    }

    @Test (expected = CourseAlreadyExistException.class)
    public void createCourseTestWithWrongValue() throws UserDoesNotExistException, CourseAlreadyExistException {
        String teacherID = "TTT111";
        doReturn(teacher1).when(userDaoMock).findUserByID(teacherID);
        courseDao.createCourse(userDaoMock,"Matek1", "Matematika 1.", "Introduction to Mathematics", teacherID);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createCourseTestWithNull() throws UserDoesNotExistException, CourseAlreadyExistException, IllegalArgumentException {
        String teacherID = "TTT222";
        doReturn(teacher2).when(userDaoMock).findUserByID(teacherID);
        courseDao.createCourse(userDaoMock,"Matek3", "Matematika 2.", "Intermediate  Mathematics", null);
    }

    @Test
    public void modifyCourseTest() throws UserDoesNotExistException, CourseDoesNotExistException {
        String teacherID = "TTT222";
        this.teacher2 = new Teacher("Teacher","Two","abc","TTT222","j.smith@email.com",111111);
        doReturn(teacher2).when(userDaoMock).findUserByID(teacherID);
        courseDao.modifyCourse(userDaoMock, new Course("Matek1", "Matematika 1.", "Introduction to Mathematics", teacherID));
    }

    @Test (expected = CourseDoesNotExistException.class)
    public void modifyCourseTestWithWrongValue() throws UserDoesNotExistException, CourseDoesNotExistException {
        String teacherID = "TTT222";
        this.teacher2 = new Teacher("Teacher","Two","abc","TTT222","j.smith@email.com",111111);
        doReturn(teacher2).when(userDaoMock).findUserByID(teacherID);
        courseDao.modifyCourse(userDaoMock, new Course("Matek3", "Matematika 3.", "Introduction to Mathematics again", teacherID));
    }

    @Test (expected = IllegalArgumentException.class)
    public void modifyCourseTestWithNull() throws UserDoesNotExistException, CourseDoesNotExistException, IllegalArgumentException {
        String teacherID = "TTT222";
        this.teacher2 = new Teacher("Teacher","Two","abc","TTT222","j.smith@email.com",111111);
        doReturn(teacher2).when(userDaoMock).findUserByID(teacherID);
        courseDao.modifyCourse(userDaoMock, null);
    }

    @Test
    public void deleteCourseTest() throws CourseDoesNotExistException {
        courseDao.deleteCourse("Matek1");

    }

    @Test (expected = CourseDoesNotExistException.class)
    public void deleteCourseTestWithWrongValue() throws CourseDoesNotExistException {
        courseDao.deleteCourse("Matek500");

    }

    @Test (expected = CourseDoesNotExistException.class)
    public void deleteCourseTestWithNull() throws CourseDoesNotExistException {
        courseDao.deleteCourse(null);
    }

    @Test
    public void findCourseByIDTest() throws CourseDoesNotExistException {
        courseDao.findCourseByID("Matek1");
    }

    @Test (expected = CourseDoesNotExistException.class)
    public void findCourseByIDTestWithWrongValue() throws CourseDoesNotExistException {
        courseDao.findCourseByID("Matek500");
    }

    @Test (expected = CourseDoesNotExistException.class)
    public void findCourseByIDTestWithNull() throws CourseDoesNotExistException {
        courseDao.findCourseByID(null);
    }

    @Test
    public void findCoursesByTeacherTest() throws UserDoesNotExistException, CourseDoesNotExistException {
        String teacherID = "TTT111";
        doReturn(teacher1).when(userDaoMock).findUserByID(teacherID);
        courseDao.findCoursesByTeacher(userDaoMock,teacherID);
    }

    @Test (expected = CourseDoesNotExistException.class)
    public void findCoursesByTeacherTestWithWrongValue() throws UserDoesNotExistException, CourseDoesNotExistException {
        String teacherID = "TTT222";
        this.teacher2 = new Teacher("Teacher","Two","abc","TTT222","j.smith@email.com",111111);
        doReturn(teacher2).when(userDaoMock).findUserByID(teacherID);
        courseDao.findCoursesByTeacher(userDaoMock,teacherID);
    }

    @Test (expected = IllegalArgumentException.class)
    public void findCoursesByTeacherTestWithNull() throws CourseDoesNotExistException, UserDoesNotExistException, IllegalArgumentException {
        String teacherID = "TTT222";
        this.teacher2 = new Teacher("Teacher","Two","abc","TTT222","j.smith@email.com",111111);
        doReturn(teacher2).when(userDaoMock).findUserByID(teacherID);
        courseDao.findCoursesByTeacher(userDaoMock,null);
    }
}
