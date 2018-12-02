package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.AdministratorServiceDao;
import hu.uni.miskolc.iit.model.Form;
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
    public List<Form> findAllRequest() {
        String sql = sqlStatements.getProperty("select.all.request");
        return this.getJdbc().query(sql, new AdministratorServiceDaoImpl.AdministratorRequestMapper());
    }

    class AdministratorRequestMapper implements RowMapper<Form> {
//
        @Override
        public Form mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Form form = new Form();
            form.setStudentID(resultSet.getString("StudentID"));
            form.setTeacherID(resultSet.getString("TeacherID"));
            form.setCourseID(resultSet.getString("CoureseID"));
            form.setText(resultSet.getString("Text"));
            form.setDate(resultSet.getDate("Date"));
            return form;
        }
    }
    public void managaFormTypes(String modified_type, int id){
        String sql = sqlStatements.getProperty("modify.FormType");

    }
    public void manageComplains(String modified_complain, int id){
        String sql = sqlStatements.getProperty("modify.Complains");
    }

}
