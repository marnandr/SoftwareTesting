package hu.uni.miskolc.iit.service.impl;

import hu.uni.miskolc.iit.dao.CourseDao;
import hu.uni.miskolc.iit.dao.FormDao;
import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.dao.UserDao;
import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;
import hu.uni.miskolc.iit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class StudentServiceImpl implements StudentService {

    FormDao formDao;
    CourseDao courseDao;
    UserDao userDao;

    public StudentServiceImpl(FormDao formDao, CourseDao courseDao, UserDao userDao){
        this.formDao = formDao;
        this.courseDao = courseDao;
        this.userDao = userDao;
    }

    @Override
    public List<Course> getAllCourses() throws CourseDoesNotExistException {
        if(courseDao.getAllCourses().isEmpty()){
            throw new CourseDoesNotExistException();
        }
        else{
            return courseDao.getAllCourses();
        }
    }

    @Override
    public void createForm(int formID, Student student, Teacher teacher, Course course, String text, FormTypes formType) throws FormAlreadyExistsExeption, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException {

    }

    @Override
    public List<Form> findThatStudentsForms() throws FormDoesNotExistException {
        return null;
    }
}
