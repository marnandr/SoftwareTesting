package hu.uni.miskolc.iit.controller;

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

        /**
         * this method is to get all listed courses
         *
         * the endpoint for this API =  localhost/services/students/listCourses
         *
         * @return List of courses
         */
        @PostMapping(path = "/listCourses", consumes = "application/json")
        public ResponseEntity<?> findallRequest(){
            return ResponseEntity.ok(administratorService.findAllRequest());
        }
        @PostMapping(path = "/manageFormType", consumes = "application/json")
        public ResponseEntity<?> manageFormTypes(String modified_type, int id){
            administratorService.manageFormTypes(modified_type, id);
            return null;
        }
        @PostMapping(path = "/manageComplains", consumes = "application/json")
        public ResponseEntity<?> manageComplain(String modified_complain, int id){
            administratorService.manageFormTypes(modified_complain, id);
            return null;
        }


    }

}
