package hu.uni.miskolc.iit.controller;


import hu.uni.miskolc.iit.exceptions.FormAlreadyExistsExeption;
import hu.uni.miskolc.iit.exceptions.FormDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
import hu.uni.miskolc.iit.model.FormTypes;
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
    public ResponseEntity<?> getAllListedForms(){
        return ResponseEntity.ok(teacherService.getForms());
    }

    @PostMapping(path = "/forwardForm", consumes = "application/json")
    public void forwardForm(int form_id, String teacherID) throws FormDoesNotExistException {
        teacherService.forwardForm(form_id, teacherID);
    }

    @PostMapping(path = "/findThatTeachersForm", consumes = "application/json")
    public void findThatTeachersForms(String teacherID) throws FormNotFoundException {
        teacherService.findThatTeachersForms(teacherID);
    }

    @PostMapping(path = "/findFormsByCourse", consumes = "application/json")
    public void findFormsByCourse(String course_id) throws FormNotFoundException {
        teacherService.findFormsByCourse(course_id);
    }

    @PostMapping(path = "/createForm", consumes = "application/json")
    public void createForm(int id, String student, String teacher, String course, String text, FormTypes formType) throws FormAlreadyExistsExeption {
        teacherService.createForm(id,student,teacher,course,text,formType);
    }

}
