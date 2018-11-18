package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.Form;
import hu.uni.miskolc.iit.exceptions.*;
import java.util.Collection;
import java.util.Date;

public interface FormService {
    /**
     * Method which list the all existing forms.
     * @return
     * @throws listNotFoundException
     */
    public Collection<Form> listAll() throws listNotFoundException;

    /**
     * Method which list all exisiting forms with date filtering.
     * @param date
     * @return
     * @throws listNotFoundException
     * @throws notExistingFieldException
     */
    public Collection<Form> listByDate(Date date) throws listNotFoundException, notExistingFieldException;

    /**
     *  Method which list all exisiting forms with state filtering.
     * @param state
     * @return
     * @throws listNotFoundException
     * @throws notExistingFieldException
     */
    public Collection<Form> listByState(String state) throws listNotFoundException, notExistingFieldException;

    /**
     *  Method which list all exisiting forms with course filtering.
     * @param course
     * @return
     * @throws listNotFoundException
     * @throws notExistingFieldException
     */
    public Collection<Form> listByCourse(String course) throws listNotFoundException, notExistingFieldException;

    /**
     *  Method which list all exisiting forms with student filtering.
     * @param student
     * @return
     * @throws listNotFoundException
     * @throws notExistingFieldException
     */
    public Collection<Form> listByStudent(String student) throws listNotFoundException, notExistingFieldException;

    /**
     *  Method which list all exisiting forms with teacher filtering.
     * @param teacher
     * @return
     * @throws listNotFoundException
     * @throws notExistingFieldException
     */
    public Collection<Form> listByTeacher(String teacher) throws listNotFoundException, notExistingFieldException;

    /**
     *  Method which can make decision by a teacher.
     * @param decision
     * @throws notExistingFieldException
     */
    public void makeDecision(boolean decision) throws notExistingFieldException;

    /**
     *  Method which can make complain by a student.
     */
    public void makeComplain();

}