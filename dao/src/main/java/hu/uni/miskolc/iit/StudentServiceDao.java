package hu.uni.miskolc.iit;

import hu.uni.miskolc.iit.model.Course;

import java.util.List;

public interface StudentServiceDao {

    public List<Course> findAllCourses();
}
