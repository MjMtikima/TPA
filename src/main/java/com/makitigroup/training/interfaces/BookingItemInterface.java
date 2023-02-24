package com.makitigroup.training.interfaces;

import com.makitigroup.training.model.BookingItem;
import com.makitigroup.training.model.Course;

import java.util.List;
import java.util.Optional;

public interface BookingItemInterface {
    List<Course> findBySpecificPeriod(String starDate, String endDate);

    List<BookingItem> findByCourseId(String id);

    Optional<BookingItem> findOneById(String id);

    Optional<BookingItem> findOneByCourseAndCustumer(String courseId, String customerId);
}
