package com.example.examinationservice.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Өвчний код хадгалах Entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "disease_codes")
public class DiagnosisCode {

    @Id
    private String id;  // Өвчний кодын ID

    private String name;  // Өвчний нэр

    private String description;  // Өвчний тодорхойлолт

    private String value;  // Өвчний код (уникаль)

    @CreatedDate
    private LocalDateTime createdAt;  // Бүртгэгдсэн огноо

    @LastModifiedDate
    private LocalDateTime updatedAt;  // Сүүлд өөрчлөгдсөн огноо
}

