package hu.uni.miskolc.iit.Controllers;


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
    public ResponseEntity<?> forwardForm(int form_id, String teacherID){
        return ResponseEntity.ok(teacherService.forwardForm(form_id, teacherID));
    }

    @PostMapping(path = "/findThatTeachersForm", consumes = "application/json")
    public ResponseEntity<?> findThatTeachersForms(String teacherID){
        return ResponseEntity.ok(teacherService.findThatTeachersForms(teacherID));
    }

    @PostMapping(path = "/findFormsByCourse", consumes = "application/json")
    public ResponseEntity<?> findFormsByCourse(String course_id){
        return ResponseEntity.ok(teacherService.findFormsByCourse(course_id));
    }

    @PostMapping(path = "/createForm", consumes = "application/json")
    public ResponseEntity<?> createForm(int id, String st, String t, String c, String txt, FormTypes formType){
        return ResponseEntity.ok(teacherService.createForm(id,st,t,c,txt,formType));
    }










}
