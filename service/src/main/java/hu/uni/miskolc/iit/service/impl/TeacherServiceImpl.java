package hu.uni.miskolc.iit.service.impl;

import hu.uni.miskolc.iit.dao.TeacherServiceDao;
import hu.uni.miskolc.iit.exceptions.FormAlreadyExistsExeption;
import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.FormTypes;
import hu.uni.miskolc.iit.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    TeacherServiceDao teacherServiceDao;

    public TeacherServiceImpl(TeacherServiceDao teacherServiceDao){
        this.teacherServiceDao = teacherServiceDao;
    }

    @Override
    public List<Form> getForms() {
        return teacherServiceDao.getForms();
    }

    @Override
    public void forwardForm(int form_id, String teacherID) throws FormDoesNotExistException {
        teacherServiceDao.forwardForm(form_id, teacherID);
    }

    @Override
    public List<Form> findThatTeachersForms(String teacherID) throws FormNotFoundException {
        return teacherServiceDao.findThatTeachersForms(teacherID);
    }

    @Override
    public List<Form> findFormsByCourse(String course_id) throws FormNotFoundException {
        return teacherServiceDao.findFormsByCourse(course_id);
    }

    @Override
    public void createForm(int id, String st, String t, String c, String txt, FormTypes formType) throws FormAlreadyExistsExeption {
        teacherServiceDao.createForm(id,st,t,c,txt,formType);
    }


}
