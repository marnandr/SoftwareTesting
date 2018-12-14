package hu.uni.miskolc.iit.controller;

import hu.uni.miskolc.iit.exceptions.ComplainAlreadyExistsException;
import hu.uni.miskolc.iit.exceptions.CourseDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
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

    @PostMapping(path = "/listCourses", consumes = "application/json")
    public ResponseEntity<?> getAllCourses() throws CourseDoesNotExistException {
        return ResponseEntity.ok(studentService.getAllCourses());
    }
}
