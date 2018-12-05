package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.TeacherServiceDao;
import hu.uni.miskolc.iit.exceptions.FormAlreadyExistsExeption;
import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.model.FormTypes;
import hu.uni.miskolc.iit.persist.AbstractJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TeacherServiceDaoImpl extends AbstractJdbc implements TeacherServiceDao {

    @Autowired
    @Qualifier(value = "teacherServiceDao")
    private Properties sqlStatements;
    private List<Form> myForms;


    public TeacherServiceDaoImpl(){
        myForms = new ArrayList<>();
        myForms.add(new Form(1,"abc111","teacher1","matek101","please let me retake the exam", FormTypes.RETAKE_EXAM));
        myForms.add(new Form(2,"abc112","teacher1","matek102","please let me retake the class", FormTypes.RETAKE_LECTURE));
    }

    @Override
    public List<Form> getForms() {
        //String sql = sqlStatements.getProperty("select.all.forms");
        //return this.getJdbc().query(sql, new TeacherServiceDaoImpl.TeacherFormsMapper());

        return myForms;
    }

    @Override
    public void forwardForm(int form_id, String teacherID) throws FormDoesNotExistException {
        boolean exists = false;
        for (Form form : myForms){
            if(form.getForm_id()==form_id){
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
        if(myForms.size()>0){
            for(Form form:myForms ){
                if(form.getForm_id()==id){
                    throw new FormAlreadyExistsExeption();
                }
            }
            myForms.add(new Form(id,st,t,c,txt,formType));
        }
        else{
            myForms.add(new Form(id,st,t,c,txt,formType));
        }

    }


    class TeacherFormsMapper implements RowMapper<Form> {


        @Override
        public Form mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Form form = new Form();
            form.setForm_id(resultSet.getInt("ID"));
            form.setCourseID(resultSet.getString("Course_ID"));
            form.setStudentID(resultSet.getString("Student_ID"));
            form.setTeacherID(resultSet.getString("Teacher_ID"));
            form.setText(resultSet.getString("text"));
            form.setDate(resultSet.getDate("Form_date"));
            //form.setCurrentState(resultSet.getString("state"));

            return form;
        }
    }
}
