package hu.uni.miskolc.iit.dao;

import hu.uni.miskolc.iit.exceptions.CourseAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.CourseDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.TeacherNotFoundException;
import hu.uni.miskolc.iit.exceptions.UserDoesNotExistException;
import hu.uni.miskolc.iit.model.Course;

import java.util.List;

public interface CourseDao {

    void createCourse(UserDao userDao, String courseID, String name, String desciption, String teacherID) throws CourseAlreadyExistException, UserDoesNotExistException, IllegalArgumentException;
    void modifyCourse(UserDao userDao, Course course) throws CourseDoesNotExistException, UserDoesNotExistException, IllegalArgumentException;
    void deleteCourse(String courseID) throws CourseDoesNotExistException;
    Course findCourseByID(String courseID) throws CourseDoesNotExistException;
    List<Course> getAllCourses();
    List<Course> findCoursesByTeacher(UserDao userDao, String teacherID) throws CourseDoesNotExistException, UserDoesNotExistException, IllegalArgumentException;

}
