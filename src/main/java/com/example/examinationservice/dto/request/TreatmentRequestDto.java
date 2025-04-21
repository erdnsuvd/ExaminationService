package com.example.examinationservice.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentRequestDto {

    private LocalDateTime date;  // Эмчилгээний огноо
    private String treatmentType;  // Эмчилгээний төрөл
    private String instruction;  // Эмчилгээний заавар
    private String diagnosisType;  // Оношны төрөл
    private Integer totalQuantity;  // Нийт тоо хэмжээ
    private Integer sessionsCompleted;  // Дугаарласан эмчилгээний тоо
    private String examinationId;  // Шинжилгээний ID
    private String patientId;  // Өвчтөний ID
    private String medicalStaffId;  // Эмнэлгийн ажилтны ID
}


