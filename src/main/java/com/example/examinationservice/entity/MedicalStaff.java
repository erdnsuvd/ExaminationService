package com.example.examinationservice.entity;

import com.example.examinationservice.entity.enums.Position;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class MedicalStaff extends User {

    private Position position;
    private String specialization;
}


