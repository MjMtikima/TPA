package com.makitigroup.training.repository;

import com.makitigroup.training.model.BookingItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingItemRepository extends MongoRepository<BookingItem, String> {
}

