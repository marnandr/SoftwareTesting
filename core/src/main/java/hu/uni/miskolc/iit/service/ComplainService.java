package hu.uni.miskolc.iit.service;


import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;

// delete create enum
public interface ComplainService extends RequestService {

public void createComplain(int RequestID, String Complain) throws ComplainAlreadyExistsException, RequestDoesNotExistException;



}
