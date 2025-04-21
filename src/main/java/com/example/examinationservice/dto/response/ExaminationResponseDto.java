package com.example.examinationservice.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExaminationResponseDto {
    private String id;
    private LocalDateTime examDate;  // Шинжилгээний огноо
    private String doctorsExamination;  // Эмчийн шинжилгээний төрөл
    private String examType;  // Шинжилгээний төрөл
    private String illness;  // Өвчний мэдээлэл
    private boolean surgery;  // Мэс засал хийсэн эсэх
    private boolean callback;  // Дахин үзүүлэх эсэх
    private String reason;  // Шинжилгээ хийсэн шалтгаан
    private boolean sendToHigherLevel;  // Дээд шатны эмнэлэг рүү илгээсэн эсэх
    private boolean violated;  // Зөрчил гарсан эсэх
    private Integer sickDays;  // Өвдсөн хоногийн тоо
    private String status;  // Шинжилгээний төлөв
    private String patientId;  // Өвчтөний ID
    private String medicalStaffId;  // Эмнэлгийн ажилтны ID
    private String createdAt;  // Бүртгэгдсэн огноо
    private String updatedAt;  // Сүүлд өөрчлөгдсөн огноо
}


