package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.model.Course;

import java.util.List;

public interface StudentService{

    public List<Course> getAllCourses();

    public String checkRequestStatus(int requestid) throws RequestDoesNotExistException;

    public void createComplain(int requestID, String complain) throws ComplainAlreadyExistsException, RequestDoesNotExistException;
}
