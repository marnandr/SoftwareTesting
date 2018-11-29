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
}
