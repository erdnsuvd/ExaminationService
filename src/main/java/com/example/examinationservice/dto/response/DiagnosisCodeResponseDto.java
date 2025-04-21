package com.example.examinationservice.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisCodeResponseDto {

    private String id;  // Өвчний кодын ID
    private String name;  // Өвчний нэр
    private String description;  // Өвчний тодорхойлолт
    private String value;  // Өвчний код
    private String createdAt;  // Бүртгэгдсэн огноо
    private String updatedAt;  // Сүүлд өөрчлөгдсөн огноо
}


