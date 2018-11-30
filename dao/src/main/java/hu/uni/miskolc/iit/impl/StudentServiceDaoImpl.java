package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.StudentServiceDao;
import hu.uni.miskolc.iit.model.Request;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.persist.AbstractJdbc;
import hu.uni.miskolc.iit.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    public boolean chechkRequestStatus(int requestid, boolean status) {
        String sql = sqlStatements.getProperty("select.requeststatus");
        String tmp =this.getJdbc().query(sql, new CheckRequestsStatusMapper);
        status=Boolean.valueOf(tmp);

        return status;
    }
    class CheckRequestsStatusMapper implements  RowMapper<Request>{

      @Override
      public Request mapRow(ResultSet resultSet, int i) throws SQLException {
            Request request = new Request();
            request.setRequestID(resultSet.getInt("Status"));
            return request;

          }
      
      public List<Form> findAllForms() {
          return null;
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

}
