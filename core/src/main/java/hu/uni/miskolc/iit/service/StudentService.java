package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;

import java.util.List;

public interface StudentService {

    List<Course> getAllCourses() throws CourseDoesNotExistException;
    void createForm(int formID, Student student, Teacher teacher, Course course, String text, FormTypes formType) throws FormAlreadyExistsExeption, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException;
    List<Form> findThatStudentsForms() throws FormDoesNotExistException;

}
