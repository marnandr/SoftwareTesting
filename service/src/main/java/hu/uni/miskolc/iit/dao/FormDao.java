package hu.uni.miskolc.iit.dao;

import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;

import java.util.Date;
import java.util.List;

public interface FormDao {

    void createForm(String formID, Student student, Teacher teacher, Course course, String text, Date date, FormTypes formType) throws FormAlreadyExistsExeption, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException;
    void forwardForm(String formID, String teacherID) throws FormNotFoundException, TeacherNotFoundException;
    void deleteForm(String formID) throws FormNotFoundException;
    void modifyForm(Form form) throws FormNotFoundException, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException;
    List<Form> findFormsByUser(String UserID) throws FormNotFoundException, UserDoesNotExistException;
    List<Form> findFormsByStudent(String studentID) throws FormNotFoundException, StudentNotFoundException;
    List<Form> findFormsByTeacher(String teacherID) throws FormNotFoundException, TeacherNotFoundException;
    List<Form> findFormsByCourse (String courseID) throws FormNotFoundException, CourseDoesNotExistException;
    List<Form> findFormsByStatus (Form.formState state) throws FormNotFoundException;

}
