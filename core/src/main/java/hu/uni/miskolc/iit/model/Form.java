package hu.uni.miskolc.iit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Form {
    private int formID;
    private Student student;
    private Teacher teacher;
    private Course course;
    private String text;
    private Date date;

    public enum formState {OPEN, CLOSED, REOPENED} //possibly more to add

    private formState currentState;
    private FormTypes formType;
    private List<Action> formHistory;


    public Form() {
    }

    public Form(int formID, Student student, Teacher teacher, Course course, String text, Date date, FormTypes formType) {
        this.formID = formID;
        this.teacher = teacher;
        this.course = course;
        this.text = text;
        this.date = date;
        this.formType = formType;
        currentState = formState.OPEN;
        //first element in the form history, always "REQUESTED" and the student is the actor
        formHistory = new ArrayList<>();
        formHistory.add(new Action(student.getNeptunCode(),Action.FormAction.REQUESTED));
    }

    @Override
    public String toString() {
        return "Student: " + student + " Course: " + course + " Text: " + text;
    }

    //Getter and Setter methods
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

    public FormTypes getFormType() {
        return formType;
    }

    public void setFormType(FormTypes formType) {
        this.formType = formType;
    }

    public List<Action> getHistory() {
        return formHistory;
    }

    public void setHistory(List<Action> formHistory) {
        this.formHistory = formHistory;
    }

    public String getTeacherID() {
        return teacher.getNeptunCode();
    }

    public void setTeacherID(String teacherID) {
        this.teacher.setNeptunCode(teacherID);
    }

    public String getStudentID() {
        return student.getNeptunCode();
    }

    public void setStudentID(String studentID) {
        this.student.setNeptunCode(studentID);
    }

    public String getCourseID() {
        return course.getCourseID();
    }

    public void setCourseID(String courseID) {
        this.course.setCode(courseID);
    }

    public int getFormID() {
        return formID;
    }

    public void setFormID(int formID) {
        this.formID = formID;
    }


}
