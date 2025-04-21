package com.example.examinationservice.repository;

import com.example.examinationservice.entity.DiagnosisCode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiagnosisCodeRepository extends MongoRepository<DiagnosisCode, String> {
}