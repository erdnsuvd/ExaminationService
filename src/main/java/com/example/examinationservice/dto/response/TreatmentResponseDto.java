package com.example.examinationservice.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentResponseDto {

    private String id;  // Эмчилгээний ID
    private String date;  // Эмчилгээний огноо
    private String treatmentType;  // Эмчилгээний төрөл
    private String instruction;  // Эмчилгээний заавар
    private String diagnosisType;  // Оношны төрөл
    private Integer totalQuantity;  // Нийт тоо хэмжээ
    private Integer sessionsCompleted;  // Дугаарласан эмчилгээний тоо
    private String examinationId;  // Шинжилгээний ID
    private String patientId;  // Өвчтөний ID
    private String medicalStaffId;  // Эмнэлгийн ажилтны ID
    private String createdAt;  // Бүртгэгдсэн огноо
    private String updatedAt;  // Сүүлд өөрчлөгдсөн огноо
}


