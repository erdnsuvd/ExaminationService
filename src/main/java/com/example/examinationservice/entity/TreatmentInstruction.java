package com.example.examinationservice.entity;

import com.example.examinationservice.entity.enums.DiagnosisType;
import com.example.examinationservice.entity.enums.TreatmentType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Эмчилгээний мэдээлэл хадгалах Entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "treatments")
public class TreatmentInstruction {

    @Id
    private String id;  // Эмчилгээний ID

    private LocalDateTime date;  // Эмчилгээний огноо

    private TreatmentType treatmentType;  // Эмчилгээний төрөл

    private DiagnosisType diagnosisType;  // Оношны төрөл (in, out)

    private Integer totalQuantity;  // Нийт тоо хэмжээ

    private Integer sessionsCompleted;  // Дугаарласан эмчилгээний тоо

    private String instruction;

    private Examination examination;  // Шинжилгээ

    private Patient patient;  // Өвчтөн

    private MedicalStaff medicalStaff;  // Эмнэлгийн ажилтан

    @CreatedDate
    private LocalDateTime createdAt;  // Бүртгэгдсэн огноо

    @LastModifiedDate
    private LocalDateTime updatedAt;  // Сүүлд өөрчлөгдсөн огноо
}

