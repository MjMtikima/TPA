package com.makitigroup.training.controller;

import com.makitigroup.training.Service.CourseService;
import com.makitigroup.training.Service.HealthService;
import com.makitigroup.training.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/tpa/v1/health")
public class HealthController extends BaseController {


    public HealthController(CourseService courseService, CourseRepository courseRepository, HealthService healthService) {
        super(courseService, courseRepository, healthService);
    }


    @GetMapping(value ="/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHealthyness(){

        if (this.healthService.getDatabaseConnexionHealthy().size() > 0){
            return new ResponseEntity<>("UP", HttpStatus.OK);
        }
        return new ResponseEntity<>("DOWN",HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
