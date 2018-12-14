package hu.uni.miskolc.iit.controller;


import hu.uni.miskolc.iit.exceptions.*;
import hu.uni.miskolc.iit.model.*;
import hu.uni.miskolc.iit.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/services/teachers")
@Validated
public class TeacherServiceController {

    @Autowired
    TeacherService teacherService;

    @PostMapping(path = "/listForms", consumes = "application/json")
    public ResponseEntity<?> getAllListedForms() throws FormNotFoundException {
        return ResponseEntity.ok(teacherService.getForms());
    }

    @PostMapping(path = "/forwardForm", consumes = "application/json")
    public void forwardForm(Form form, String teacherID) throws FormDoesNotExistException, CourseDoesNotExistException, FormNotFoundException, StudentNotFoundException, TeacherNotFoundException {
        teacherService.forwardForm(form, teacherID);
    }

    @PostMapping(path = "/findThatTeachersForm", consumes = "application/json")
    public void findThatTeachersForms(String teacherID) throws FormNotFoundException, TeacherNotFoundException, UserDoesNotExistException {
        teacherService.findThatTeachersForms(teacherID);
    }

    @PostMapping(path = "/findFormsByCourse", consumes = "application/json")
    public void findFormsByCourse(String course_id) throws FormNotFoundException, CourseDoesNotExistException {
        teacherService.findFormsByCourse(course_id);
    }

    @PostMapping(path = "/createForm", consumes = "application/json")
    public void createForm(int formID, Student student, Teacher teacher, Course course, String text, FormTypes formType) throws FormAlreadyExistsExeption, TeacherNotFoundException, CourseDoesNotExistException, StudentNotFoundException {
        teacherService.createForm(formID,student,teacher,course,text,formType);
    }

}
