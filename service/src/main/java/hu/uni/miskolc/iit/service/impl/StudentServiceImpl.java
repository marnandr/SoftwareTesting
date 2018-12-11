package hu.uni.miskolc.iit.service.impl;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentServiceDao studentServiceDao;

    /**
     * Service layer method to get all listed courses by sending the request to the DAO layer
     *
     * @return
     */
    //@Override
    //public List<Course> getAllCourses() {return studentServiceDao.findAllCourses();


    @Override
    public String checkRequestStatus(int requestid) throws RequestDoesNotExistException {
        return studentServiceDao.checkRequestStatus(requestid);
    }

    @Override
    public void createComplain(int requestID, String complain) throws ComplainAlreadyExistsException, RequestDoesNotExistException {
        studentServiceDao.createComplain(requestID, complain);
    }
}
