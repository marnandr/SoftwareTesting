package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.persist.AbstractJdbc;
import hu.uni.miskolc.iit.StudentServiceDao;
import hu.uni.miskolc.iit.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
