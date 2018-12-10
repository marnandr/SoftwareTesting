package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.model.Request;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.Course;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


import javax.sql.DataSource;

public class StudentServiceDaoImpl implements StudentServiceDao {


    /**
     * getting all listed courses from the DB by executing the query in the
     *
     * @return
     */
    @Override
    public List<Course> findAllCourses() {
        return null;
    }

    /**
     * getting all listed forms from the DB
     *
     * @return
     */
    @Override
    public List<Form> findAllForms() {
        return null;
    }

    /**
     * set the datasource for the insert statement
     *
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {

    }

    /**
     * create the new request
     *
     * //@param Request_ID
     * //@param Student_ID
     * //@param Teacher_ID
     * //@param Request_Status
     * //@param Request_Description
     */

    public Form createRequest(int Request_ID, int Student_ID, int Teacher_ID, String Request_Status, String Request_Description) {
        /*String INSERT_SQL = "INSERT INTO Student_Request(Request_ID, Student_ID, Teacher_ID, Request_Status, Request_Description) values(?,?,?,?,?)";
        jdbcTemplateObject.update(INSERT_SQL, Request_ID, Student_ID, Teacher_ID, Request_Status, Request_Description);
        Request request = new Request();
        */
        return null;

    }

    @Override
    public List<Request> findRequestById(int requestId) {
        return null;
    }

    @Override
    public List<Request> findAllRequests() {
        return null;
    }

    @Override
    public List<Form> chechkRequestStatus(int requestid, boolean status) {
        return null;
    }

}

