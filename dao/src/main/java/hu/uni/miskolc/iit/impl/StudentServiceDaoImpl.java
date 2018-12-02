package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.model.Request;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.persist.AbstractJdbc;
import hu.uni.miskolc.iit.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


import javax.sql.DataSource;


@Repository
public class StudentServiceDaoImpl extends AbstractJdbc implements StudentServiceDao {


    @Autowired
    @Qualifier(value = "studentServiceDao")
    private Properties sqlStatements;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    /**
     * getting all listed courses from the DB by executing the query in the
     *
     * @return
     */
    @Override
    public List<Course> findAllCourses() {
        String sql = sqlStatements.getProperty("select.all.courses");
        return this.getJdbc().query(sql, new StudentCoursesMapper());
    }

    /**
     * getting all listed forms from the DB
     *
     * @return
     */
    @Override
    public List<Form> findAllForms() {
        String sql = sqlStatements.getProperty("select.all.forms");
        return this.getJdbc().query(sql, new StudentFormsMapper());
    }

    /**
     * set the datasource for the insert statement
     *
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    /**
     * create the new request
     *
     * @param Request_ID
     * @param Student_ID
     * @param Teacher_ID
     * @param Request_Status
     * @param Request_Description
     */
    public Request createRequest(int Request_ID, int Student_ID, int Teacher_ID, String Request_Status, String Request_Description) {
        String INSERT_SQL = "INSERT INTO Student_Request(Request_ID, Student_ID, Teacher_ID, Request_Status, Request_Description) values(?,?,?,?,?)";
        jdbcTemplateObject.update(INSERT_SQL, Request_ID, Student_ID, Teacher_ID, Request_Status, Request_Description);
        Request request = new Request();
        return request;
    }

    @Override
    public List<Request> findAllRequests() {
        String sql = sqlStatements.getProperty("select.all.requests");
        return this.getJdbc().query(sql, new StudentRequestMapper());
    }

    @Override
    public List<Request> chechkRequestStatus(int requestid, boolean status) {
        String sql = sqlStatements.getProperty("select.requeststatus");
        return this.getJdbc().query(sql, new CheckRequestsStatusMapper());
    }


    class StudentCoursesMapper implements RowMapper<Course> {

        @Override
        public Course mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Course course = new Course();
            course.setCode(resultSet.getString("code"));
            course.setDescription(resultSet.getString("description"));
            course.setName(resultSet.getString("name"));
            course.setTeacher(resultSet.getInt("teacherId"));

            return course;
        }
    }

    class StudentFormsMapper implements RowMapper<Form> {

        @Override
        public Form mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Form form = new Form();
            form.setForm_id(resultSet.getInt("ID"));
            form.setCourseID(resultSet.getString("Course_ID"));
            form.setStudentID(resultSet.getString("Student_ID"));
            form.setTeacherID(resultSet.getString("Teacher_ID"));
            form.setText(resultSet.getString("text"));
            //form.setDate(resultSet.getDate("Form_date"));

            return form;
        }
    }

    public class StudentRequestMapper implements RowMapper<Request> {
        public Request mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Request request = new Request();
            request.setRequestID(resultSet.getInt("Request_ID"));
            request.setStudentID(resultSet.getInt("Student_ID"));
            request.setTeacherID(resultSet.getInt("Teacher_ID"));
            request.setRequestDate(resultSet.getDate("Request_Date"));
            request.setRequestStatus(resultSet.getString("Request_Status"));
            request.setDescription(resultSet.getString("Request_description"));

            return request;
        }
    }

    public class CheckRequestsStatusMapper implements RowMapper<Request> {

        @Override
        public Request mapRow(ResultSet resultSet, int i) throws SQLException {
            Request request = new Request();
            request.setRequestID(resultSet.getInt("Status"));
            return request;

        }
    }
}

