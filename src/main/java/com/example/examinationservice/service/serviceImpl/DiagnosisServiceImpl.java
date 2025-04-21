package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.request.DiagnosisCodeRequestDto;
import com.example.examinationservice.dto.request.DiagnosisRequestDto;
import com.example.examinationservice.dto.response.DiagnosisCodeResponseDto;
import com.example.examinationservice.dto.response.DiagnosisResponseDto;
import com.example.examinationservice.entity.*;
import com.example.examinationservice.helper.ExaminationHelper;
import com.example.examinationservice.repository.DiagnosisCodeRepository;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.repository.MedicalStaffRepository;
import com.example.examinationservice.repository.PatientRepository;
import com.example.examinationservice.service.DiagnosisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class DiagnosisServiceImpl implements DiagnosisService {
    private final ExaminationRepository examinationRepository;
    private final DiagnosisCodeRepository diagnosisCodeRepository;
    private final PatientRepository patientRepository;
    private final MedicalStaffRepository medicalStaffRepository;

    @Override
    public DiagnosisResponseDto addDiagnosis(DiagnosisRequestDto dto) {
        try {
            DiagnosisCode code = diagnosisCodeRepository.findById(dto.getDiagnosisCode())
                    .orElseThrow(() -> new RuntimeException("Өвчний код олдсонгүй"));

            Patient patient = patientRepository.findById(dto.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Өвчтөн олдсонгүй"));

            MedicalStaff staff = medicalStaffRepository.findById(dto.getMedicalStaffId())
                    .orElseThrow(() -> new RuntimeException("Ажилтан олдсонгүй"));

            Examination exam = examinationRepository.findById(dto.getExaminationId())
                    .orElseThrow(() -> new RuntimeException("Шинжилгээ олдсонгүй"));

            ExaminationHelper.updateDiagnosis(exam, code, patient, staff);

            Examination savedExam = examinationRepository.save(exam);
            Diagnosis diagnosis = savedExam.getDiagnosis();

            return new DiagnosisResponseDto(
                    diagnosis.getId(),
                    diagnosis.getDiagnosisCode().getValue(),
                    diagnosis.getPatient().getSisiID(),
                    savedExam.getId(),
                    diagnosis.getMedicalStaff().getId(),
                    diagnosis.getCreatedAt().toString(),
                    diagnosis.getUpdatedAt().toString()
            );
        } catch (RuntimeException e) {
            throw new RuntimeException("Онош тавихад алдаа гарлаа: " + e.getMessage(), e);
        }
    }


    @Override
    public DiagnosisCodeResponseDto addDiagnosisCode(DiagnosisCodeRequestDto dto) {
        try {
            DiagnosisCode diagnosisCode = new DiagnosisCode();
            diagnosisCode.setName(dto.getName());
            diagnosisCode.setDescription(dto.getDescription());
            diagnosisCode.setValue(dto.getValue());

            diagnosisCode.setCreatedAt(LocalDateTime.now());
            diagnosisCode.setUpdatedAt(LocalDateTime.now());

            DiagnosisCode saved = diagnosisCodeRepository.save(diagnosisCode);

            return new DiagnosisCodeResponseDto(
                    saved.getId(),
                    saved.getName(),
                    saved.getDescription(),
                    saved.getValue(),
                    saved.getCreatedAt().toString(),
                    saved.getUpdatedAt().toString()
            );

        } catch (RuntimeException e) {
            throw new RuntimeException("Оношны код нэмэхэд алдаа гарлаа: " + e.getMessage(), e);
        }
    }
}
