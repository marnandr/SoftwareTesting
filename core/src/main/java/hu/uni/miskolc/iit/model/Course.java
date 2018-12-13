package hu.uni.miskolc.iit.model;

public class Course {


    private String courseID;
    private String name;
    private String description;
    private String teacherID;

    public Course() {
    }

    public Course(String courseID, String name, String desciption, String teacherID) {
        this.courseID = courseID;
        this.name = name;
        this.description = desciption;
        this.teacherID = teacherID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCode(String courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String courseName) {
        this.name = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }


    public void checkCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("The course code can't be null");
        } else if (code.length() != 6) {
            throw new IllegalArgumentException("The course code must be 6 characters long");
        }
    }

    public void checkName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("The name can't be null");
        }
    }

    public void checkDescription(String desc) {
        if (desc == null) {
            throw new IllegalArgumentException("The course description can't be null");
        }
    }

}
