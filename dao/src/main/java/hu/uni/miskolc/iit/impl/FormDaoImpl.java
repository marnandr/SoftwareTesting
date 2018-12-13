package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.CourseDao;
import hu.uni.miskolc.iit.dao.FormDao;
import hu.uni.miskolc.iit.dao.UserDao;
import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormDaoImpl implements FormDao {

    List<Form> forms;

    public FormDaoImpl(){
        forms = new ArrayList<>();
    }

    @Override
    public void createForm(int formID, Student student, Teacher teacher, Course course, String text, Date date, FormTypes formType) throws FormAlreadyExistsExeption, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException {
        if(doesItExist(formID)){
            throw new FormAlreadyExistsExeption();
        }
        else{
            forms.add(new Form(formID,student,teacher,course,text,date,formType));
        }
    }

    @Override
    public void forwardForm(UserDao userDao, Form form, String teacherID) throws FormNotFoundException, TeacherNotFoundException, CourseDoesNotExistException, StudentNotFoundException {
        Form formToForward;
        try {
            formToForward = new Form(form.getFormID(),form.getStudent(),(Teacher)userDao.findUserByID(teacherID),form.getCourse(),form.getText(),form.getDate(),form.getFormType());
        } catch (UserDoesNotExistException e) {
            throw new TeacherNotFoundException();
        }
        modifyForm(formToForward);
    }

    @Override
    public void deleteForm(int formID) throws FormNotFoundException {
        boolean exists = false;
        int formToDeleteIndex = -1;
        for(int i = 0; i < forms.size(); i++){
            if(forms.get(i).getFormID()==formID){
                exists = true;
                formToDeleteIndex = i;
                break;
            }
        }
        if(!exists){
            throw new FormNotFoundException();
        }
        else{
            forms.remove(formToDeleteIndex);
        }

    }

    @Override
    public void modifyForm(Form form) throws FormNotFoundException, StudentNotFoundException, TeacherNotFoundException, CourseDoesNotExistException {
        boolean exists = false;
        int formToModifyIndex = -1;
        for(int i = 0; i < forms.size(); i++){
            if(forms.get(i).getFormID()==form.getFormID()){
                exists = true;
                formToModifyIndex = i;
                break;
            }
        }
        if(!exists){
            throw new FormNotFoundException();
        }
        else{
            forms.set(formToModifyIndex,form);
        }
    }

    @Override
    public List<Form> findFormsByUser(UserDao userDao, String userID) throws FormNotFoundException, UserDoesNotExistException {
        userDao.findUserByID(userID);

        boolean exists = false;
        List<Form> formsToReturn = new ArrayList<>();
        for(Form form : forms){
            if(form.getStudentID()==userID || form.getTeacherID()==userID){
                exists = true;
                formsToReturn.add(form);
            }
        }
        if(!exists){
            throw new FormNotFoundException();
        }
        else{
            return formsToReturn;
        }

    }

    @Override
    public List<Form> findFormsByCourse(CourseDao courseDao, String courseID) throws FormNotFoundException, CourseDoesNotExistException {
        courseDao.findCourseByID(courseID);

        boolean exists = false;
        List<Form> formsToReturn = new ArrayList<>();
        for(Form form : forms){
            if(form.getCourseID()==courseID){
                exists = true;
                formsToReturn.add(form);
            }
        }
        if(!exists){
            throw new FormNotFoundException();
        }
        else{
            return formsToReturn;
        }
    }


    @Override
    public List<Form> findFormsByStatus(Form.formState state) throws FormNotFoundException {
        List<Form> formsToReturn = new ArrayList<>();
        for(Form form : forms){
            if(form.getCurrentState()==state){
                formsToReturn.add(form);
            }
        }
        return formsToReturn;
    }


    public boolean doesItExist(int formID){
        boolean alreadyExists = false;
        for(Form form : forms){
            if(form.getFormID()==formID){
                alreadyExists = true;
            }
        }
        return alreadyExists;
    }

}
