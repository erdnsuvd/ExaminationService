package com.example.examinationservice.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisResponseDto {

    private String id;  // Оношлогооны ID
    private String diagnosisCode;  // Өвчний код
    private String patientId;  // Өвчтөний ID
    private String examinationId;  // Шинжилгээний ID
    private String medicalStaffId;  // Эмнэлгийн ажилтны ID
    private String createdAt;  // Бүртгэгдсэн огноо
    private String updatedAt;  // Сүүлд өөрчлөгдсөн огноо
}

