package hu.uni.miskolc.iit.Controllers;

import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.exceptions.RequestDoesNotExistException;
import hu.uni.miskolc.iit.service.ComplainService;
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
    public ResponseEntity<?> checkRequestStatus(int requestid, boolean status){
        try {
            return ResponseEntity.ok(studentService.checkRequestStatus(requestid,status));
        } catch (RequestDoesNotExistException e) {
            return (ResponseEntity<?>) ResponseEntity.noContent();
        }
    }

    @PostMapping(path = "/makeComplaint", consumes = "application/json")
    public ResponseEntity<?> makeComplain(int ComplainID, int RequestID, String Complain){
        try {
            return ResponseEntity.ok(studentService.createComplain(ComplainID, RequestID, Complain));
        } catch (ComplainAlreadyExistsException e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}
