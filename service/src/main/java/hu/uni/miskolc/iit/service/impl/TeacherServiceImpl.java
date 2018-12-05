package hu.uni.miskolc.iit.service.impl;

import hu.uni.miskolc.iit.dao.TeacherServiceDao;
import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherServiceDao teacherServiceDao;

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

}
