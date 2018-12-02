package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.Request;
import hu.uni.miskolc.iit.persist.AbstractJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

@Repository
public class StudentServiceDaoImpl extends AbstractJdbc implements StudentServiceDao {


    @Autowired
    @Qualifier(value = "studentServiceDao")
    private Properties sqlStatements;

    /**
     * getting all listed courses from the DB by executing the query in the
     *
     * @return
     */
    @Override
    public List<Course> findAllCourses() {
        String sql = sqlStatements.getProperty("select.all.courses");
        return this.getJdbc().query(sql, new StudentCourcesMapper());
    }

    @Override
    public List<Form> findAllForms() {
        return null;
    }

    @Override
    public boolean checkRequestStatus(int requestid, boolean status) throws RequestDoesNotExistException {
        String sql = sqlStatements.getProperty("select.requeststatus");
        List<Request> requests =this.getJdbc().query(sql, new CheckRequestsStatusMapper());
        String tmp;

        if(!requests.isEmpty())
        {
            tmp = requests.get(0).getRequestStatus();
            return Boolean.valueOf(tmp);
        }
        else
        {
            throw new RequestDoesNotExistException();
        }
    }
    class CheckRequestsStatusMapper implements  RowMapper<Request>{

      @Override
      public Request mapRow(ResultSet resultSet, int i) throws SQLException {
            Request request = new Request();
            request.setRequestID(resultSet.getInt("Status"));
            return request;

          }

      }


    class StudentCourcesMapper implements RowMapper<Course> {

        @Override
        public Course mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Course course = new Course();
            course.setCode(resultSet.getString("code"));
            course.setDescription(resultSet.getString("description"));
            course.setName(resultSet.getString("name"));
            course.setTeacher(resultSet.getInt("teacberId"));

            return course;
        }

    }

        @Override
        public boolean createComplain(int complainID, int requestID, String complain) throws DataAccessException {
            String sql = sqlStatements.getProperty("insert.complaint");

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ID", complainID);
            map.put("Request_ID_FK", requestID);
            map.put("Complain", complain);

            this.getJdbc().update(sql, map);
            return true;
        }
}
