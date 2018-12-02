package hu.uni.miskolc.iit.service;

import hu.uni.miskolc.iit.model.Form;
import hu.uni.miskolc.iit.exceptions.*;

import java.util.Collection;
import java.util.Date;

public interface FormService {
    /**
     * Method which list the all existing forms.
     *
     * @return
     * @throws ListNotFoundException
     */
    public Collection<Form> listAll() throws ListNotFoundException;

    /**
     * Method which list all exisiting forms with date filtering.
     *
     * @param date
     * @return
     * @throws ListNotFoundException
     * @throws NotExistingFieldException
     */
    public Collection<Form> listByDate(Date date) throws ListNotFoundException, NotExistingFieldException;

    /**
     * Method which list all exisiting forms with state filtering.
     *
     * @param state
     * @return
     * @throws ListNotFoundException
     * @throws NotExistingFieldException
     */
    public Collection<Form> listByState(String state) throws ListNotFoundException, NotExistingFieldException;

    /**
     * Method which list all exisiting forms with course filtering.
     *
     * @param course
     * @return
     * @throws ListNotFoundException
     * @throws NotExistingFieldException
     */
    public Collection<Form> listByCourse(String course) throws ListNotFoundException, NotExistingFieldException;

    /**
     * Method which list all exisiting forms with student filtering.
     *
     * @param student
     * @return
     * @throws ListNotFoundException
     * @throws NotExistingFieldException
     */
    public Collection<Form> listByStudent(String student) throws ListNotFoundException, NotExistingFieldException;

    /**
     * Method which list all exisiting forms with teacher filtering.
     *
     * @param teacher
     * @return
     * @throws ListNotFoundException
     * @throws NotExistingFieldException
     */
    public Collection<Form> listByTeacher(String teacher) throws ListNotFoundException, NotExistingFieldException;

    /**
     * Method which can make decision by a teacher.
     *
     * @param decision
     * @throws NotExistingFieldException
     */
    public void makeDecision(boolean decision) throws NotExistingFieldException;

    /**
     * Method which can make complain by a student.
     */
    public void makeComplain();

}
