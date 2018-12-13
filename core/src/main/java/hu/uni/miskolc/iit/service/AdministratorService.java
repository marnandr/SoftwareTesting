package hu.uni.miskolc.iit.service;


import hu.uni.miskolc.iit.exceptions.CourseAlreadyExistException;
import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.UserDoesNotExistException;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.FormTypes;

import java.util.List;

public interface AdministratorService {

    List<Form> getForms() throws FormDoesNotExistException;
    void manageFormTypes(FormTypes formType, int formID) throws FormDoesNotExistException;
    void createCourse(String courseID, String name, String desciption, String teacherID) throws CourseAlreadyExistException, UserDoesNotExistException, IllegalArgumentException;
}
