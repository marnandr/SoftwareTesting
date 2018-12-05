package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
import hu.uni.miskolc.iit.model.Form;

import java.util.List;

public interface TeacherService {
    List<Form> getForms();
    void forwardForm(int form_id, String teacherID) throws FormDoesNotExistException;
    List<Form> findThatTeachersForms(String teacherID) throws FormNotFoundException;
    List<Form> findFormsByCourse(String course_id) throws FormNotFoundException;
}
