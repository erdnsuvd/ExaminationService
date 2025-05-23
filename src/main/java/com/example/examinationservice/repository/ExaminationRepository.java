package com.example.examinationservice.repository;

import com.example.examinationservice.entity.Examination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends MongoRepository<Examination, String> {
}
