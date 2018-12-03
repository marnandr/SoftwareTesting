package hu.uni.miskolc.iit.Controllers;

import hu.uni.miskolc.iit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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
     * <p>
     * the endpoint for this API =  localhost/services/students/listCourses
     *
     * @return List of courses
     */
    @PostMapping(path = "/listCourses", consumes = "application/json")
    public ResponseEntity<?> getAllListedCourses() {
        return ResponseEntity.ok(studentService.getAllCourses());
    }

    //method to get all listed forms
    @PostMapping(path = "/listForms", consumes = "application/json")
    public ResponseEntity<?> getAllListedForms() {
        return ResponseEntity.ok(studentService.getAllForms());
    }

    //method to create a new request
    @PostMapping(path = "/createRequest", consumes = "application/json")
    public ResponseEntity<?> createRequest(int Request_ID, int Student_ID, int Teacher_ID, String Request_Status, String Request_Description) {
        return ResponseEntity.ok(studentService.createNewRequest(Request_ID, Student_ID, Teacher_ID, Request_Status, Request_Description));
    }

    @PostMapping(path = "/CheckRequestStatus", consumes = "application/json")
    public ResponseEntity<?> checkRequestStatus(int requestid, boolean status, @PathVariable String complain) {
        return ResponseEntity.ok(studentService.checkRequestStatus(requestid, status, complain));
    }

}
