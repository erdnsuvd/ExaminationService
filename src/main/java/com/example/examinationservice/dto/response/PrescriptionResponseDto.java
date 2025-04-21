package com.example.examinationservice.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionResponseDto {

    private String id;  // Жорын ID
    private String date;  // Жор бичсэн огноо
    private String prescribedById;  // Эмчилгээний ажилтны ID
    private String patientId;  // Өвчтөний ID
    private String examinationId;  // Шинжилгээний ID
    private String medicineName;  // Эмчилгээний нэр
    private String dose;  // Тун
    private String frequency;  // Давтамж
    private String duration;  // Хугацаа
    private String createdAt;  // Бүртгэгдсэн огноо
    private String updatedAt;  // Сүүлд өөрчлөгдсөн огноо
}


