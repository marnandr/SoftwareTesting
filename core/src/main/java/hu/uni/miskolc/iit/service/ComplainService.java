package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.exceptions.CourseAlreadyExistException;

// delete create enum
public interface ComplainService extends RequestService {

    public boolean createComplain(int ComplainID, int RequestID, String Complain) throws CourseAlreadyExistException;


}
