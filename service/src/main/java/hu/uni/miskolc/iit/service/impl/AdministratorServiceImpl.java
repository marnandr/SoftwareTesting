package hu.uni.miskolc.iit.service.impl;

import hu.uni.miskolc.iit.dao.AdministratorServiceDao;
import hu.uni.miskolc.iit.exceptions.UserAlreadyExist;
import hu.uni.miskolc.iit.exceptions.UserCanNotLogin;
import hu.uni.miskolc.iit.exceptions.UserDoesNotExist;
import hu.uni.miskolc.iit.model.Course;
import hu.uni.miskolc.iit.model.Request;
import hu.uni.miskolc.iit.service.AdministratorService;
import hu.uni.miskolc.iit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdministratorServiceImpl implements AdministratorService {


    @Autowired
    AdministratorServiceDao administratorServiceDao;

    @Override
    public List<Request> findAllRequest() {
        return administratorServiceDao.findAllRequest();
    }

    @Override
    public void manageFormTypes(String modified_type, int id) {

    }

    @Override
    public void manageComplains(String modified_complain, int id) {

    }


}
