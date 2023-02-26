package com.makitigroup.training.controller;

import com.makitigroup.training.Service.CourseService;
import com.makitigroup.training.Service.HealthService;
import com.makitigroup.training.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {


    protected CourseService courseService;

    protected CourseRepository courseRepository;

    @Autowired
    protected HealthService healthService;



    public BaseController(@Autowired CourseService courseService, @Autowired CourseRepository courseRepository, HealthService healthService){
        this.courseService = courseService;
        this.courseRepository = courseRepository;
    }
}
