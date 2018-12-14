package hu.uni.miskolc.iit.controller;

import hu.uni.miskolc.iit.exceptions.CourseDoesNotExistException;
import hu.uni.miskolc.iit.exceptions.FormNotFoundException;
import hu.uni.miskolc.iit.service.AdministratorService;
import hu.uni.miskolc.iit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class AdministratorServiceController {

    @RestController
    @RequestMapping(value = "/services/administrators")
    @Validated
    public class AdminServiceController {

        @Autowired
        AdministratorService administratorService;

        @PostMapping(path = "/listForms", consumes = "application/json")
        public ResponseEntity<?> getAllListedForms() throws FormNotFoundException {
            return ResponseEntity.ok(administratorService.getForms());
        }
    }

}
