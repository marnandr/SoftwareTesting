package hu.uni.miskolc.iit.model;

import java.util.ArrayList;

/*
Contains the history of the Form. Who did what to it and when.
Right now the date is always today's date, when the constructor is called, so the users can't mess with it,
but if it's necessary, it can be changed with the setDate method of the Action class
 */
public class History {

    private ArrayList<Action> actions; //holds actor (user) and action pairs and the date


    public History(User user, FormAction formAction) {
        Action firstAction = new Action(user, formAction);
        actions = new ArrayList<Action>();
        actions.add(firstAction);
    }

    public void setAction(User user, FormAction formAction) {
        Action newAction = new Action(user, formAction);
        actions.add(newAction);
    }

    //returns the whole history of the calling form as an arraylist
    public ArrayList<Action> getHistory() {
        return actions;
    }

}
