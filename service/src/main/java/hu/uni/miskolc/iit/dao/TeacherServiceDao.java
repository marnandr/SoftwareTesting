package hu.uni.miskolc.iit.dao;

import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;

import java.util.List;

public interface TeacherServiceDao {

    List<Form> getForms();
    void forwardForm(int form_id, String teacherID) throws FormDoesNotExistException, TeacherNotFoundException;
    List<Form> findThatTeachersForms(String teacherID) throws FormNotFoundException, TeacherNotFoundException;
    List<Form> findFormsByCourse(String course_id) throws FormNotFoundException, CourseDoesntExist;
    void createForm(int form_id, String studentID, String teacherID, String courseID, String text, FormTypes formType) throws FormAlreadyExistsExeption, TeacherNotFoundException, CourseDoesntExist, StudentNotFoundException;
}
