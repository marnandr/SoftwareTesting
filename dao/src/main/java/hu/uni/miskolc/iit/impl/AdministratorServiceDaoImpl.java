package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.AdministratorServiceDao;
import hu.uni.miskolc.iit.model.Form;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class AdministratorServiceDaoImpl implements AdministratorServiceDao {

    private Properties sqlStatements;

    @Override
    public List<Form> findAllRequest() {
        return null;
    }


    public void managaFormTypes(String modified_type, int id) {



    }

    public void manageComplains(String modified_complain, int id) {

    }

}
