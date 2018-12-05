package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.exceptions.FormAlreadyExistsExeption;
import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.FormTypes;

import java.util.List;

public interface TeacherService {
    List<Form> getForms();
    void forwardForm(int form_id, String teacherID) throws FormDoesNotExistException;
    List<Form> findThatTeachersForms(String teacherID) throws FormNotFoundException;
    List<Form> findFormsByCourse(String course_id) throws FormNotFoundException;
    void createForm(int id, String st, String t, String c, String txt, FormTypes formType) throws FormAlreadyExistsExeption;
}
