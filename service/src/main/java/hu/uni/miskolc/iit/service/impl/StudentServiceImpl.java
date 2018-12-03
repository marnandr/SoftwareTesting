package hu.uni.miskolc.iit.service.impl;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.Request;
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
    public List<Form> getAllForms() {
        return studentServiceDao.findAllForms();
    }

    @Override
    public Request createNewRequest(int Request_ID, int Student_ID, int Teacher_ID, String Request_Status, String Request_Description) {
        return studentServiceDao.createRequest(Request_ID, Student_ID, Teacher_ID, Request_Status, Request_Description);
    }

    @Override
    public List<Request> getAllRequests() {
        return studentServiceDao.findAllRequests();
    }

    @Override
    public List<Request> getRequestById(int requestId) {
        return studentServiceDao.findRequestById(requestId);
    }

    @Override
    public String checkRequestStatus(int requestid, boolean status, String complain) {
        List<Form> formList = studentServiceDao.chechkRequestStatus(requestid, status);
        Boolean isRequestAvailable = Boolean.valueOf(formList.get(0).getCurrentState().toString().equals("CLOSED") == true ? false : true);
        String message;
        if (isRequestAvailable) {
            message = "Request is still open, you can't add any complaints";
        } else {
            //TODO: create dao method for adding complain for closed request
            message = "your complain have been submitted to the request";
        }
        return message;
    }
}
