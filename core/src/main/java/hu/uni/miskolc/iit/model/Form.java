package hu.uni.miskolc.iit.model;

import java.util.Date;

public class Form {
    private int form_id;
    private Student student;
    private Teacher teacher;
    private Course course;
    private String text;
    private Date date;
    public enum formState{ OPEN, CLOSED, REOPENED } //possibly more to add
    private formState currentState;
    private FormTypes formType;
    private History formHistory;

    private String teacherID;
    private String studentID;
    private String CourseID;

    public Form(){}

    public Form(Student st, Teacher t, Course c, String txt, Date dt, FormTypes formType){
        student = st;
        teacher = t;
        course = c;
        text = txt;
        date = dt;
        this.formType = formType;
        currentState = formState.OPEN;
        //first element in the form history, always "REQUESTED" and the student is the actor
        formHistory = new History(st, FormAction.REQUESTED);
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
    public FormTypes getFormType() {
        return formType;
    }
    public void setFormType(FormTypes formType) {
        this.formType = formType;
    }
    public History getHistory() {
        return formHistory;
    }
    public void setHistory(History formHistory) {
        this.formHistory = formHistory;
    }
    public String getTeacherID() {
        return teacherID;
    }
    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getCourseID() {
        return CourseID;
    }
    public void setCourseID(String courseID) {
        CourseID = courseID;
    }
    public int getForm_id() {
        return form_id;
    }
    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }





//endregion

}
