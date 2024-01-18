package com.barber.companyservice.repository;

import com.barber.companyservice.model.Haircut;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HaircutRepository extends MongoRepository<Haircut, String> {
}
