package hu.uni.miskolc.iit.dao;

import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;

import java.util.Date;
import java.util.List;

public interface FormDao {

    void createForm(int formID, Student student, Teacher teacher, Course course, String text, FormTypes formType) throws FormAlreadyExistsExeption, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException;
    void forwardForm(UserDao userDao, Form form, String teacherID) throws FormNotFoundException, TeacherNotFoundException, CourseDoesNotExistException, StudentNotFoundException;
    void deleteForm(int formID) throws FormNotFoundException;
    void modifyForm(Form form) throws FormNotFoundException, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException, UserDoesNotExistException;
    List<Form> findFormsByUser(UserDao userDao, String userID) throws FormNotFoundException, UserDoesNotExistException;
    List<Form> findFormsByCourse (CourseDao courseDao, String courseID) throws FormNotFoundException, CourseDoesNotExistException;
    List<Form> findFormsByStatus (Form.formState state) throws FormNotFoundException;

}
