package com.example.examinationservice.entity;

import com.example.examinationservice.entity.enums.Gender;
import com.example.examinationservice.entity.enums.PatientType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class Patient extends User {

    private PatientType type;
    private String register;
    private String address;
    private String school;
    private String sisiID;
    private String occupation;
    private String education;
    private LocalDate birthOfDate;
    private Gender gender;
}
