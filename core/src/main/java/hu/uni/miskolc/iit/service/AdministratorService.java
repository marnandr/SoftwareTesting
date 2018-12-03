package hu.uni.miskolc.iit.service;


import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.Request;

import java.util.List;

public interface AdministratorService {

    public List<Form> findAllRequest();

    public void manageFormTypes(String modified_type, int id);

    public void manageComplains(String modified_complain, int id);
}
