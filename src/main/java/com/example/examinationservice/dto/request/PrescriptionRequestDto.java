package com.example.examinationservice.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionRequestDto {

    private LocalDateTime date;
    private String prescribedBy;  // Эмчилгээний ажилтны ID
    private String patientId;  // Өвчтөний ID
    private String examinationId;  // Шинжилгээний ID
    private String medicineName;  // Эмчилгээний нэр
    private String dose;  // Тун
    private String frequency;  // Давтамж
    private String duration;  // Хугацаа
}
