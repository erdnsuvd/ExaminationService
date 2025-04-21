package com.example.examinationservice.helper;

import com.example.examinationservice.dto.request.DiagnosisRequestDto;
import com.example.examinationservice.dto.request.PrescriptionRequestDto;
import com.example.examinationservice.dto.request.TreatmentRequestDto;
import com.example.examinationservice.entity.*;
import com.example.examinationservice.entity.enums.DiagnosisType;
import com.example.examinationservice.entity.enums.TreatmentType;

import java.time.LocalDateTime;

public class ExaminationHelper {
    public static Examination updateDiagnosis(
            Examination exam,
            DiagnosisCode diagnosisCode,
            Patient patient,
            MedicalStaff medicalStaff
    ) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDiagnosisCode(diagnosisCode);
        diagnosis.setPatient(patient);
        diagnosis.setMedicalStaff(medicalStaff);
        diagnosis.setExamination(exam);
        diagnosis.setCreatedAt(LocalDateTime.now());
        diagnosis.setUpdatedAt(LocalDateTime.now());

        exam.setDiagnosis(diagnosis);
        return exam;
    }

    public static Examination updateQuestionnaire(
            Examination exam,
            Patient patient,
            MedicalStaff medicalStaff
    ) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setPatient(patient);
        questionnaire.setMedicalStaff(medicalStaff);

        exam.setQuestionnaire(questionnaire);
        return exam;
    }

    public static Examination updateInstruction(
            Examination exam,
            TreatmentRequestDto dto,
            Patient patient,
            MedicalStaff staff
    ) {
        TreatmentInstruction instruction = new TreatmentInstruction();
        instruction.setDate(dto.getDate());
        instruction.setTotalQuantity(dto.getTotalQuantity());
        instruction.setSessionsCompleted(dto.getSessionsCompleted());

        instruction.setTreatmentType(TreatmentType.valueOf(dto.getTreatmentType()));
        instruction.setDiagnosisType(DiagnosisType.valueOf(dto.getDiagnosisType()));
        instruction.setInstruction(dto.getInstruction());
        instruction.setPatient(patient);
        instruction.setMedicalStaff(staff);
        instruction.setExamination(exam);
        instruction.setCreatedAt(LocalDateTime.now());
        instruction.setUpdatedAt(LocalDateTime.now());

        exam.setTreatmentInstruction(instruction);
        return exam;
    }

    public static Examination updatePrescription(
            Examination exam,
            Patient patient,
            MedicalStaff staff,
            PrescriptionRequestDto dto
    ) {
        Prescription prescription = new Prescription();
        prescription.setDate(dto.getDate());
        prescription.setPatient(patient);
        prescription.setPrescribedBy(staff);
        prescription.setExamination(exam);
        prescription.setDose(dto.getDose());
        prescription.setDuration(dto.getDuration());
        prescription.setFrequency(dto.getFrequency());
        prescription.setMedicineName(dto.getMedicineName());
        prescription.setCreatedAt(LocalDateTime.now());
        prescription.setUpdatedAt(LocalDateTime.now());

        exam.setPrescription(prescription);
        return exam;
    }

}
