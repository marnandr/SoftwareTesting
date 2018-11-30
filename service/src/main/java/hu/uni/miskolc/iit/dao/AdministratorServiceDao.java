package hu.uni.miskolc.iit.dao;


import hu.uni.miskolc.iit.model.Request;

import java.util.List;

public interface AdministratorServiceDao {

    public List<Request> findAllRequest();

    public void managaFormTypes(String form_type, int id);

    public void manageComplains(String modified_complain, int id);



}
