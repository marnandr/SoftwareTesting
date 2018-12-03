package hu.uni.miskolc.iit.dao;

import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.Request;

import java.util.List;
import javax.sql.DataSource;

public interface StudentServiceDao {

    public List<Course> findAllCourses();

    public List<Form> findAllForms();

    public void setDataSource(DataSource ds);

    public Form createRequest(int Request_ID, int Student_ID, int Teacher_ID, String Request_Status, String Request_Description);

    public List<Request> findRequestById(int requestId);

    public List<Request> findAllRequests();

    public List<Form> chechkRequestStatus(int requestid, boolean status);

}
