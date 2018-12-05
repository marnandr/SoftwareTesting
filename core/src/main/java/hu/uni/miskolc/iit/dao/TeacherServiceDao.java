package hu.uni.miskolc.iit.dao;

import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.model.Form;

import java.util.List;

public interface TeacherServiceDao {

    List<Form> getForms();
    void forwardForm(int form_id, String teacherID) throws FormDoesNotExistException;
    List<Form> findThatTeachersForms(String teacherID) throws FormDoesNotExistException;
}
