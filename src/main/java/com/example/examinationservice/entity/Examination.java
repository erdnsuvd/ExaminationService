package com.example.examinationservice.entity;

import com.example.examinationservice.entity.enums.DoctorsExamination;
import com.example.examinationservice.entity.enums.Status;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "examinations")
public class Examination {

    @Id
    private String id; //ID

    private LocalDateTime examDate; //огноо

    private DoctorsExamination doctorsExamination; //төрөл (анхны, хяналтын гэх мэт)

    private String examType; // Шинжилгээний төрөл (текст хэлбэрээр)

    private String illness; // Өвчний мэдээлэл

    private boolean surgery; // Мэс засал хийсэн эсэх

    private boolean callback; // Дахин үзүүлэх эсэх

    private String reason; // Шинжилгээ хийсэн шалтгаан

    private boolean sendToHigherLevel; // Дээд шатны эмнэлэг рүү илгээсэн эсэх

    private boolean violated; // Зөрчил гарсан эсэх

    private Integer sickDays; // Өвдсөн хоногийн тоо

    private Status status; // Шинжилгээний төлөв (үргэлжилж байгаа, хийгдсэн гэх мэт)

    private Diagnosis diagnosis;

    private TreatmentInstruction treatmentInstruction;

    private Prescription prescription;

    private Questionnaire questionnaire; // Хамт бөглөсөн асуумж

    private MedicalStaff medicalStaff; // Эмнэлгийн ажилтан

    private Patient patient; // Өвчтөн

    @CreatedDate
    private LocalDateTime createdAt; // Бүртгэгдсэн огноо

    @LastModifiedDate
    private LocalDateTime updatedAt; // Сүүлд өөрчлөгдсөн огноо
}
