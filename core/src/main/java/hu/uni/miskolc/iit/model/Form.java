package hu.uni.miskolc.iit.model;

import java.util.Date;

public class Form {
    private Student student;
    private Teacher teacher;
    private Course course;
    private String text;
    private Date date;
    private enum formState{ OPEN, CLOSED, REOPENED } //possibly more to add
    private formState currentState;

    public Form(){}

    public Form(Student st, Teacher t, Course c, String txt, Date dt){
        student = st;
        teacher = t;
        course = c;
        text = txt;
        date = dt;
        currentState = formState.OPEN;
    }
    @Override
    public String toString(){
        return "Student: "+student+" Course: "+course+" Text: "+text;
    }
    //region Getters and Setters
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Student getStudent() {
        return student;
    }
    public formState getCurrentState() {
        return currentState;
    }
    public void setCurrentState(formState currentState) {
        this.currentState = currentState;
    }
//endregion

}
