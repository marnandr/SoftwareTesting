package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.TeacherServiceDao;
import hu.uni.miskolc.iit.exceptions.FormAlreadyExistsExeption;
import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.FormTypes;

import java.util.*;

public class TeacherServiceDaoImpl implements TeacherServiceDao {

    private List<Form> myForms;


    public TeacherServiceDaoImpl(){
        myForms = new ArrayList<>();
    }

    @Override
    public List<Form> getForms() {
        return myForms;
    }

    @Override
    public void forwardForm(int form_id, String teacherID) throws FormDoesNotExistException {
        boolean exists = false;
        for (Form form : myForms){
            if(form.getFormID()==form_id){
                exists=true;
                form.setTeacherID(teacherID);
            }
        }
        if(!exists){
            throw new FormDoesNotExistException();
        }
    }

    @Override
    public List<Form> findThatTeachersForms(String teacherID) throws FormNotFoundException {
        List<Form> theirForms = new ArrayList<>();
        boolean exists = false;
        for (Form form : myForms){
            if(form.getTeacherID()==teacherID){
                exists=true;
                theirForms.add(form);
            }
        }

        if(!exists){
            throw new FormNotFoundException();
        }
        return theirForms;

    }

    @Override
    public List<Form> findFormsByCourse(String course_id) throws FormNotFoundException {
        List<Form> formsToReturn = new ArrayList<>();
        boolean exists = false;
        for (Form form : myForms){
            if(form.getCourseID()==course_id){
                exists=true;
                formsToReturn.add(form);
            }
        }

        if(!exists){
            throw new FormNotFoundException();
        }
        return formsToReturn;
    }

    @Override
    public void createForm(int id, String st, String t, String c, String txt, FormTypes formType) throws FormAlreadyExistsExeption {
        /*
        if(myForms.size()>0){
            for(Form form:myForms ){
                if(form.getFormID()==id){
                    throw new FormAlreadyExistsExeption();
                }
            }
            myForms.add(new Form(id,st,t,c,txt,formType));
        }
        else{
            myForms.add(new Form(id,st,t,c,txt,formType));
        }
*/
    }

}
