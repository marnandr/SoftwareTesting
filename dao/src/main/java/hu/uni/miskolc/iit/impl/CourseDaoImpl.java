package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.CourseDao;
import hu.uni.miskolc.iit.exceptions.CourseAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.CourseDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.TeacherNotFoundException;
import hu.uni.miskolc.iit.model.Course;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public void createCourse(String code, String name, String desciption, String teacherID) throws CourseAlreadyExistException, TeacherNotFoundException {

    }

    @Override
    public void modifyCourse(Course course) throws CourseDoesNotExistException, TeacherNotFoundException {

    }

    @Override
    public void deleteCourse(String courseID) throws CourseDoesNotExistException {

    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    @Override
    public List<Course> findCoursesByTeacher(String teacherID) throws TeacherNotFoundException, CourseDoesNotExistException {
        return null;
    }
}
