package com.makitigroup.training.repository;

import com.makitigroup.training.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {

}
