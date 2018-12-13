package hu.uni.miskolc.iit.model;

/*
This class contains the actor (User) and their action on the Form
 */

import java.util.Calendar;
import java.util.Date;

public class Action {
    private String userID;
    private Date date;
    public enum FormAction {
        REQUESTED,
        VIEWED,
        DENIED,
        ACCEPTED;
    }

    private FormAction formAction;

    public Action(String userID, FormAction formAction) {
        this.userID = userID;
        this.formAction = formAction;
        date = new Date();
        date = Calendar.getInstance().getTime();
    }

    public String getUserID() {
        return userID;
    }

    public void setUser(String userID) {
        this.userID = userID;
    }

    public FormAction getFormAction() {
        return formAction;
    }

    public void setFormAction(FormAction formAction) {
        this.formAction = formAction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return userID + "\n" + formAction.toString() + " the request on " + date;
    }
}
