package com.example.examinationservice.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Эмчилгээний жор хадгалах Entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "prescriptions")
public class Prescription {

    @Id
    private String id;  // Жорын ID

    private LocalDateTime date;  // Жор бичсэн огноо

    private String medicineName;

    private String dose;

    private String frequency;

    private String duration;

    private MedicalStaff prescribedBy;  // Эмчилгээний ажилтан (жор бичсэн)

    private Patient patient;  // Өвчтөн

    private Examination examination;  // Шинжилгээ

    @CreatedDate
    private LocalDateTime createdAt;  // Бүртгэгдсэн огноо

    @LastModifiedDate
    private LocalDateTime updatedAt;  // Сүүлд өөрчлөгдсөн огноо
}

