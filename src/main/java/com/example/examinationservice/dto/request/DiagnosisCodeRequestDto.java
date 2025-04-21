package com.example.examinationservice.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisCodeRequestDto {

    private String name;  // Өвчний нэр
    private String description;  // Өвчний тодорхойлолт
    private String value;  // Өвчний код
}


