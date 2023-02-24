package com.makitigroup.training.interfaces;

import com.makitigroup.training.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepositoryInterface{

    List<Course> findAll();

    Optional<Course> findOneById(String id);
    List<Course> findBySpecificPeriod(String startDate, String endDate);
    List<Course> findByCourseId(String id);
    Optional<Course> findOneByCourseAndCustomer(String courseId, String customerId);

}
