package com.example.examinationservice.repository;


import com.example.examinationservice.entity.MedicalStaff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalStaffRepository extends MongoRepository<MedicalStaff, String> {
}

