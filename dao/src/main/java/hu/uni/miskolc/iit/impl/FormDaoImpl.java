package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.FormDao;
import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;

import java.util.Date;
import java.util.List;

public class FormDaoImpl implements FormDao {

    @Override
    public void createForm(String formID, Student student, Teacher teacher, Course course, String text, Date date, FormTypes formType) throws FormAlreadyExistsExeption, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException {

    }

    @Override
    public void forwardForm(String formID, String teacherID) throws FormNotFoundException, TeacherNotFoundException {

    }

    @Override
    public void deleteForm(String formID) throws FormNotFoundException {

    }

    @Override
    public void modifyForm(Form form) throws FormNotFoundException, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException {

    }

    @Override
    public List<Form> findFormsByUser(String UserID) throws FormNotFoundException, UserDoesNotExistException {
        return null;
    }

    @Override
    public List<Form> findFormsByStudent(String studentID) throws FormNotFoundException, StudentNotFoundException {
        return null;
    }

    @Override
    public List<Form> findFormsByTeacher(String teacherID) throws FormNotFoundException, TeacherNotFoundException {
        return null;
    }

    @Override
    public List<Form> findFormsByCourse(String courseID) throws FormNotFoundException, CourseDoesNotExistException {
        return null;
    }

    @Override
    public List<Form> findFormsByStatus(Form.formState state) throws FormNotFoundException {
        return null;
    }
}
