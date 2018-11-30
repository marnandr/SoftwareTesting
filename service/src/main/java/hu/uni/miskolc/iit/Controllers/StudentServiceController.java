package hu.uni.miskolc.iit.Controllers;

import hu.uni.miskolc.iit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/services/students")
@Validated
public class StudentServiceController {

    @Autowired
    StudentService studentService;

    /**
     * this method is to get all listed courses
     *
     * the endpoint for this API =  localhost/services/students/listCourses
     *
     * @return List of courses
     */
    @PostMapping(path = "/listCourses", consumes = "application/json")
    public ResponseEntity<?> getAllListedCourses(){
        return ResponseEntity.ok(studentService.getAllCourses());
    }
    @PostMapping(path = "/CheckRequestStatus", consumes = "application/json")
    public ResponseEntity<?> checkRequestStatus(){
        return ResponseEntity.ok(studentService.checkRequestStatus());
    }

}
