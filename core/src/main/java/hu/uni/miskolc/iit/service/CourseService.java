package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.Course;

import java.util.Collection;

public interface CourseService {

    public boolean courseCreation(String courseName, String description, int teacherID);
    public Collection<Course> courseList();
    public boolean courseModification(String courseName, String description, int teacherID);
    public boolean courseDelete(String courseName);
daw
}
