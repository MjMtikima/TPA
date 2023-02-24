package com.makitigroup.training.Service;

import com.makitigroup.training.interfaces.CourseRepositoryInterface;
import com.makitigroup.training.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseService implements CourseRepositoryInterface {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<Course> findAll() {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").exists(true));
        return mongoTemplate.find(query, Course.class);
    }

    @Override
    public Optional<Course> findOneById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        return Optional.ofNullable(mongoTemplate.findOne(query, Course.class));
    }

    @Override
    public List<Course> findBySpecificPeriod(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);
        Query query = new Query(Criteria.where("b").elemMatch(
                Criteria.where("startDate").gte(start)
                        .and("endDate").lte(end)
        ));
        return mongoTemplate.find(query, Course.class);
    }

    @Override
    public List<Course> findByCourseId(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("courseId").is(id));
        return mongoTemplate.find(query, Course.class);
    }


    @Override
    public Optional<Course> findOneByCourseAndCustomer(String courseId, String customerId) {
        Query query = new Query();

        query.addCriteria(Criteria.where("courseId").is(courseId));
        query.addCriteria(Criteria.where("customerId").is(customerId));
        return Optional.ofNullable(mongoTemplate.findOne(query, Course.class));
    }
}
