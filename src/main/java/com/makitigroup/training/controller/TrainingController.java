package com.makitigroup.training.controller;

import com.makitigroup.training.Service.CourseService;
import com.makitigroup.training.Service.HealthService;
import com.makitigroup.training.model.Course;
import com.makitigroup.training.repository.CourseRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/tpa/v1/course")
public class TrainingController extends BaseController {


    public TrainingController(CourseService courseService, CourseRepository courseRepository, HealthService healthService) {
        super(courseService, courseRepository, healthService);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        try {
            List<Course> courses = courseService.findAll();
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byperiod")
    public ResponseEntity<List<Course>> getCoursesByPeriod(@Param("startDate") String startDate, @Param("endDate") String endDate) {
        try {
            List<Course> items = courseService.findBySpecificPeriod(startDate,endDate);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byavailabledate/{id}")
    public ResponseEntity<List<Course>> getDatesOfSpecificCourse(@PathVariable("id") String id) {
        try {
            List<Course> items = courseService.findByCourseId(id);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/newcourse")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        try {
            Course _course = courseRepository.save(new Course(course.getName(), course.getDescription(), course.getLecturers()));
            return new ResponseEntity<>(_course, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") String id,@RequestBody Course course) {
        Optional<Course> courseData = courseService.findOneById(id);

        if (courseData.isPresent()) {
            Course _course = courseData.get();
                _course.setName(course.getName());
                _course.setDescription(course.getDescription());
                _course.setLecturers(course.getLecturers());
                _course.setPrice(course.getPrice());
                _course.setCurrency(course.getCurrency());
                _course.setStartDateTime(course.getStartDateTime());
                _course.setEndDateTime(course.getEndDateTime());

            return new ResponseEntity<>(courseRepository.save(_course), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
