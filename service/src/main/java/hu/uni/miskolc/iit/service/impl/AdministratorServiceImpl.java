package hu.uni.miskolc.iit.service.impl;

import hu.uni.miskolc.iit.dao.AdministratorServiceDao;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.service.AdministratorService;

import java.util.List;


public class AdministratorServiceImpl implements AdministratorService {


    AdministratorServiceDao administratorServiceDao;

    @Override
    public List<Form> findAllRequest() {
        return administratorServiceDao.findAllRequest();
    }

    @Override
    public void manageFormTypes(String modified_type, int id) {
        administratorServiceDao.managaFormTypes(modified_type, id);
    }
    @Override
    public void manageComplains(String modified_complain, int id) {
        administratorServiceDao.manageComplains(modified_complain, id);
    }


}
