package hu.uni.miskolc.iit.service.impl;

import hu.uni.miskolc.iit.dao.AdministratorServiceDao;
import hu.uni.miskolc.iit.dao.CourseDao;
import hu.uni.miskolc.iit.dao.FormDao;
import hu.uni.miskolc.iit.dao.UserDao;
import hu.uni.miskolc.iit.exceptions.CourseAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
import hu.uni.miskolc.iit.exceptions.UserDoesNotExistException;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.FormTypes;
import hu.uni.miskolc.iit.service.AdministratorService;

import java.util.List;


public class AdministratorServiceImpl implements AdministratorService {

    FormDao formDao;
    CourseDao courseDao;
    UserDao userDao;

    public AdministratorServiceImpl(FormDao formDao, CourseDao courseDao, UserDao userDao){
        this.formDao = formDao;
        this.courseDao = courseDao;
        this.userDao = userDao;
    }

    @Override
    public List<Form> getForms() throws FormNotFoundException {
        List<Form> formsToReturn = formDao.getForms();
        if(formsToReturn.isEmpty()){
            throw new FormNotFoundException();
        }
        else{
            return formsToReturn;
        }
    }

    @Override
    public void manageFormTypes(FormTypes formType, int formID) throws FormNotFoundException {

    }

    @Override
    public void createCourse(String courseID, String name, String desciption, String teacherID) throws CourseAlreadyExistException, UserDoesNotExistException, IllegalArgumentException {

    }
}
