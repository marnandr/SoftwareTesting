package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.Request;

import java.util.List;

public interface StudentService {

    public List<Course> getAllCourses();

    public List<Form> getAllForms();

    public Request createNewRequest(int Request_ID, int Student_ID, int Teacher_ID, String Request_Status, String Request_Description);

    public List<Request> checkRequestStatus(int requestid, boolean status);
}
