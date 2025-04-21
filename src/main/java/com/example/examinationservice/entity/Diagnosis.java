package com.example.examinationservice.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Оношлогооны мэдээлэл хадгалах Entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Diagnosis {

    @Id
    private String id;  // Оношлогооны ID

    private DiagnosisCode diagnosisCode;  // Өвчний код

    private Patient patient;  // Өвчтөн

    private Examination examination;  // Шинжилгээ

    private MedicalStaff medicalStaff;  // Эмнэлгийн ажилтан

    @CreatedDate
    private LocalDateTime createdAt;  // Бүртгэгдсэн огноо

    @LastModifiedDate
    private LocalDateTime updatedAt;
}