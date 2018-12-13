package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.CourseDao;
import hu.uni.miskolc.iit.dao.UserDao;
import hu.uni.miskolc.iit.exceptions.CourseAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.CourseDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.TeacherNotFoundException;
import hu.uni.miskolc.iit.exceptions.UserDoesNotExistException;
import hu.uni.miskolc.iit.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    List<Course> courses;

    public CourseDaoImpl(){
        courses = new ArrayList<>();
    }

    @Override
    public void createCourse(UserDao userDao, String courseID, String name, String desciption, String teacherID) throws CourseAlreadyExistException, UserDoesNotExistException, IllegalArgumentException {
        if(userDao==null || teacherID == null){
            throw new IllegalArgumentException();
        }
        userDao.findUserByID(teacherID);
        boolean alreadyExists = false;
        for(Course course : courses){
            if(course.getCourseID()==courseID){
                alreadyExists=true;
            }
        }
        if(alreadyExists){
            throw new CourseAlreadyExistException();
        }
        else{
            courses.add(new Course(courseID, name, desciption, teacherID));
        }
    }

    @Override
    public void modifyCourse(UserDao userDao, Course course) throws CourseDoesNotExistException, UserDoesNotExistException, IllegalArgumentException {
        if(course==null || userDao == null){
            throw new IllegalArgumentException();
        }
        userDao.findUserByID(course.getTeacherID());
        courses.set(getIndex(course.getCourseID()),course);
    }

    @Override
    public void deleteCourse(String courseID) throws CourseDoesNotExistException {
        courses.remove(getIndex(courseID));

    }

    @Override
    public Course findCourseByID(String courseID) throws CourseDoesNotExistException {
        boolean exists = false;
        Course courseToReturn = null;
        for(Course course : courses){
            if(course.getCourseID()==courseID){
                exists = true;
                courseToReturn = course;
            }
        }
        if(!exists){
            throw new CourseDoesNotExistException();
        }
        else{
            return courseToReturn;
        }
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public List<Course> findCoursesByTeacher(UserDao userDao, String teacherID) throws CourseDoesNotExistException, UserDoesNotExistException {
        if(userDao==null || teacherID == null){
            throw new IllegalArgumentException();
        }
        userDao.findUserByID(teacherID);
        boolean exists = false;
        List<Course> coursesToReturn = new ArrayList<>();
        for(Course course : courses){
            if(course.getTeacherID()==teacherID){
                exists = true;
                coursesToReturn.add(course);
            }
        }
        if(!exists){
            throw new CourseDoesNotExistException();
        }
        else{
            return coursesToReturn;
        }
    }

    public int getIndex(String courseID) throws CourseDoesNotExistException {
        boolean exists = false;
        int courseToModifyIndex = -1;
        for(int i =0; i < courses.size(); i++){
            if(courses.get(i).getCourseID()==courseID){
                exists = true;
                courseToModifyIndex = i;
            }
        }
        if(!exists){
            throw new CourseDoesNotExistException();
        }
        else{
            return courseToModifyIndex;
        }
    }
}
