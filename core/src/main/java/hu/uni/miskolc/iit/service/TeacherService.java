package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;

import java.util.List;

public interface TeacherService {
    void createForm(int formID, Student student, Teacher teacher, Course course, String text, FormTypes formType) throws FormAlreadyExistsExeption, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException;
    List<Form> getForms() throws FormNotFoundException;
    List<Course> getCourses() throws CourseDoesNotExistException;
    void forwardForm(Form form, String teacherID) throws FormNotFoundException, TeacherNotFoundException, CourseDoesNotExistException, StudentNotFoundException;
    List<Form> findThatTeachersForms(String teacherID) throws FormNotFoundException, TeacherNotFoundException, UserDoesNotExistException;
    List<Form> findFormsByCourse(String course_id) throws FormNotFoundException, CourseDoesNotExistException;
}
