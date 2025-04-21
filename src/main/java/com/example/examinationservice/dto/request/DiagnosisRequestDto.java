package com.example.examinationservice.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisRequestDto {

    private String diagnosisCode;  // Өвчний код
    private String patientId;  // Өвчтөний ID
    private String examinationId;  // Шинжилгээний ID
    private String medicalStaffId;  // Эмнэлгийн ажилтны ID
}

