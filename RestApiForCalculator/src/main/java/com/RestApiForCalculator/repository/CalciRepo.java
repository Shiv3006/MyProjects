package com.RestApiForCalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestApiForCalculator.model.RequestResponseTimestampEntity;

@Repository
public interface CalciRepo extends JpaRepository<RequestResponseTimestampEntity, Long>{

}
