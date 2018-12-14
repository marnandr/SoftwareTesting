package hu.uni.miskolc.iit.service.impl;

import hu.uni.miskolc.iit.dao.CourseDao;
import hu.uni.miskolc.iit.dao.FormDao;
import hu.uni.miskolc.iit.dao.UserDao;
import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;
import hu.uni.miskolc.iit.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    FormDao formDao;
    CourseDao courseDao;
    UserDao userDao;

    public TeacherServiceImpl(FormDao formDao, CourseDao courseDao, UserDao userDao){
        this.formDao = formDao;
        this.courseDao = courseDao;
        this.userDao = userDao;
    }


    @Override
    public void createForm(int formID, Student student, Teacher teacher, Course course, String text, FormTypes formType) throws FormAlreadyExistsExeption, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException {
        formDao.createForm(formID, student, teacher, course, text, formType);
    }

    @Override
    public List<Form> getForms() throws FormNotFoundException {
        List<Form> formsToReturn = formDao.getForms();
        if(formsToReturn.isEmpty()){
            throw new FormNotFoundException();
        }
        else{
            return formsToReturn;
        }
    }

    @Override
    public List<Course> getCourses() throws CourseDoesNotExistException {
        if(courseDao.getAllCourses().isEmpty()){
            throw new CourseDoesNotExistException();
        }
        else{
            return courseDao.getAllCourses();
        }
    }

    @Override
    public void forwardForm(Form form, String teacherID) throws FormNotFoundException, TeacherNotFoundException, CourseDoesNotExistException, StudentNotFoundException {
        formDao.forwardForm(userDao,form, teacherID);
    }

    @Override
    public List<Form> findThatTeachersForms(String teacherID) throws FormNotFoundException, TeacherNotFoundException, UserDoesNotExistException {
        List<Form> formsToReturn = formDao.findFormsByUser(userDao, teacherID);
        if(formsToReturn.isEmpty()){
            throw new FormNotFoundException();
        }
        else{
            return formsToReturn;
        }
    }

    @Override
    public List<Form> findFormsByCourse(String course_id) throws FormNotFoundException, CourseDoesNotExistException {
        List<Form> formsToReturn = formDao.findFormsByCourse(courseDao, course_id);
        if(formsToReturn.isEmpty()){
            throw new FormNotFoundException();
        }
        else{
            return formsToReturn;
        }
    }
}
