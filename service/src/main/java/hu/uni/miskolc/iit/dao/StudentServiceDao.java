package hu.uni.miskolc.iit.dao;

import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Form;

import java.util.List;

public interface StudentServiceDao {

    public List<Course> findAllCourses();

    public List<Form> findAllForms();

    public String checkRequestStatus(int requestid) throws RequestDoesNotExistException;

    public void createComplain(int requestID, String complain)
            throws ComplainAlreadyExistsException, IllegalArgumentException, RequestDoesNotExistException;
}
