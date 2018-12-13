package hu.uni.miskolc.iit.dao;

import hu.uni.miskolc.iit.exceptions.CourseAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.CourseDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.TeacherNotFoundException;
import hu.uni.miskolc.iit.model.Course;

import java.util.List;

public interface CourseDao {

    void createCourse(String code, String name, String desciption, String teacherID) throws CourseAlreadyExistException, TeacherNotFoundException;
    void modifyCourse(Course course) throws CourseDoesNotExistException, TeacherNotFoundException;
    void deleteCourse(String courseID) throws CourseDoesNotExistException;
    Course findCourseByID(String courseID) throws CourseDoesNotExistException;
    List<Course> getAllCourses();
    List<Course> findCoursesByTeacher(String teacherID) throws TeacherNotFoundException, CourseDoesNotExistException;

}
