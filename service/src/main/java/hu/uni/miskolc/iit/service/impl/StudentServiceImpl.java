package hu.uni.miskolc.iit.service.impl;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentServiceDao studentServiceDao;

    /**
     * Service layer method to get all listed courses by sending the request to the DAO layer
     *
     * @return
     */
    @Override
    public List<Course> getAllCourses() {
        return studentServiceDao.findAllCourses();
    }

    @Override
    public boolean checkRequestStatus(int requestid,boolean status) throws RequestDoesNotExistException {
        return studentServiceDao.checkRequestStatus( requestid, status);
    }

    @Override
    public boolean createComplain(int complainID, int requestID, String complain) {
        return studentServiceDao.createComplain(complainID, requestID, complain);
    }
}
