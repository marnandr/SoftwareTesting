package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.model.Course;

import java.util.List;

public interface StudentService {

    public List<Course> getAllCourses();

    public boolean checkRequestStatus();
}
