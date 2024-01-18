package com.barber.companyservice.repository;

import com.barber.companyservice.model.BusinessUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessUnitRepository extends JpaRepository<BusinessUnit, Integer> {
}
