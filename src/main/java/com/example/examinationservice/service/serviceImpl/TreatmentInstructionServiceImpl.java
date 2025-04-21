package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.request.TreatmentRequestDto;
import com.example.examinationservice.dto.response.TreatmentResponseDto;
import com.example.examinationservice.entity.*;
import com.example.examinationservice.helper.ExaminationHelper;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.repository.MedicalStaffRepository;
import com.example.examinationservice.repository.PatientRepository;
import com.example.examinationservice.service.TreatmentInstructionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TreatmentInstructionServiceImpl implements TreatmentInstructionService {
    private final ExaminationRepository examinationRepository;
    private final PatientRepository patientRepository;
    private final MedicalStaffRepository medicalStaffRepository;

    @Override
    public TreatmentResponseDto addInstruction(TreatmentRequestDto dto) {
        try {
            Examination exam = examinationRepository.findById(dto.getExaminationId())
                    .orElseThrow(() -> new RuntimeException("Шинжилгээ олдсонгүй"));

            Patient patient = patientRepository.findById(dto.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Өвчтөн олдсонгүй"));

            MedicalStaff staff = medicalStaffRepository.findById(dto.getMedicalStaffId())
                    .orElseThrow(() -> new RuntimeException("Ажилтан олдсонгүй"));

            ExaminationHelper.updateInstruction(exam, dto, patient, staff);

            Examination savedExam = examinationRepository.save(exam);
            TreatmentInstruction instruction = savedExam.getTreatmentInstruction();

            return new TreatmentResponseDto(
                    instruction.getId(),
                    instruction.getDate().toString(),
                    instruction.getTreatmentType().toString(),
                    instruction.getInstruction(),
                    instruction.getDiagnosisType().toString(),
                    instruction.getTotalQuantity(),
                    instruction.getSessionsCompleted(),
                    savedExam.getId(),
                    patient.getId(),
                    staff.getId(),
                    instruction.getCreatedAt().toString(),
                    instruction.getUpdatedAt().toString()
            );
        } catch (RuntimeException e) {
            throw new RuntimeException("Эмчилгээний заавар нэмэхэд алдаа гарлаа: " + e.getMessage(), e);
        }
    }

}
