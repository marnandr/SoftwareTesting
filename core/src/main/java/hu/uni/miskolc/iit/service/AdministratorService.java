package hu.uni.miskolc.iit.service;


import hu.uni.miskolc.iit.model.Request;

import java.util.List;

public interface AdministratorService {

    public List<Request> findAllRequest();

    public void manageFormTypes(String modified_type, int id);

    public void manageComplains(String modified_complain, int id);
}
