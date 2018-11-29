package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.AdministratorServiceDao;
import hu.uni.miskolc.iit.model.Request;
import hu.uni.miskolc.iit.persist.AbstractJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

@Repository
public class AdministratorServiceDaoImpl extends AbstractJdbc implements AdministratorServiceDao {

    @Autowired
    @Qualifier(value = "requestServiceDao")
    private Properties sqlStatements;

    @Override
    public List<Request> findAllRequest() {
        String sql = sqlStatements.getProperty("select.all.request");
        return this.getJdbc().query(sql, new AdministratorServiceDaoImpl.AdministratorRequestMapper());
    }

    class AdministratorRequestMapper implements RowMapper<Request> {

        @Override
        public Request mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Request request = new Request();
            request.setRequestID(resultSet.getInt("requestid"));
            request.setStudentID(resultSet.getInt("studentid"));
            request.setRequestDate(resultSet.getDate("requestdate"));
            request.setTeacherID(resultSet.getInt("teacberid"));
            request.setRequestStatus(resultSet.getString("Requeststatus"));
            request.setDescription(resultSet.getString("Description"));

            return request;
        }
    }

}
