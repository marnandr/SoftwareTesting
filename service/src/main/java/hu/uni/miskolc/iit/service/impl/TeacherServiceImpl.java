package hu.uni.miskolc.iit.service.impl;

import hu.uni.miskolc.iit.dao.TeacherServiceDao;
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
}
