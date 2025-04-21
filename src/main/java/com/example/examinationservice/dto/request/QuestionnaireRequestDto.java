package com.example.examinationservice.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionnaireRequestDto {
    private String patientId;  // Өвчтөний ID
    private String examinationId;  // Шинжилгээний ID
    private String medicalStaffId;  // Эмнэлгийн ажилтны ID
}
