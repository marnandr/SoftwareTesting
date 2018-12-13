package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;

import java.util.List;

public interface TeacherService {
    List<Form> getForms() throws FormDoesNotExistException;
    List<Course> getCourses() throws FormDoesNotExistException;
    void forwardForm(int form_id, String teacherID) throws FormDoesNotExistException, TeacherNotFoundException;
    List<Form> findThatTeachersForms(String teacherID) throws FormNotFoundException, TeacherNotFoundException;
    List<Form> findFormsByCourse(String course_id) throws FormNotFoundException, CourseDoesNotExistException;
}
