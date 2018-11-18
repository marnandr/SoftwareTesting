package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.exceptions.CourseAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.CourseDoesntExist;
import hu.uni.miskolc.iit.exceptions.ListNotFound;

import java.util.Collection;

public interface CourseService {
    /**
     *
     * @param courseName
     * @param description
     * @param teacherID
     * @return
     */

    public boolean courseCreation(String courseName, String description, int teacherID) throws CourseAlreadyExistException;

    /**
     *
     * @return
     */
    public Collection<Course> courseList() throws ListNotFound;

    /**
     *
     * @param courseName
     * @param description
     * @param teacherID
     * @return
     */
    public boolean courseModification(String courseName, String description, int teacherID) throws CourseDoesntExist;

    /**
     * @param courseName
     * @return
     */
    public boolean courseDelete(String courseName) throws CourseDoesntExist;

}
