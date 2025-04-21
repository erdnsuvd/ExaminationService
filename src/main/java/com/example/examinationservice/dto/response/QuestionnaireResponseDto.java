package com.example.examinationservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionnaireResponseDto {
    private String id;  // Асуумжийн ID
    private String patientId;  // Өвчтөний ID
    private String examinationId;  // Шинжилгээний ID
    private String medicalStaffId;  // Эмнэлгийн ажилтны ID
    private String createdAt;  // Бүртгэгдсэн огноо
    private String updatedAt;  // Сүүлд өөрчлөгдсөн огноо
}
