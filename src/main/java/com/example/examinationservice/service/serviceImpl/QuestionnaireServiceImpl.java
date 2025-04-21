package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.request.QuestionnaireRequestDto;
import com.example.examinationservice.dto.response.QuestionnaireResponseDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.entity.MedicalStaff;
import com.example.examinationservice.entity.Patient;
import com.example.examinationservice.entity.Questionnaire;
import com.example.examinationservice.helper.ExaminationHelper;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.repository.MedicalStaffRepository;
import com.example.examinationservice.repository.PatientRepository;
import com.example.examinationservice.service.QuestionnareService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnareService {
    private final ExaminationRepository examinationRepository;
    private final PatientRepository patientRepository;
    private final MedicalStaffRepository medicalStaffRepository;

    @Override
    public QuestionnaireResponseDto submitQuestion(QuestionnaireRequestDto dto) {
        try {
            Patient patient = patientRepository.findById(dto.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Өвчтөн олдсонгүй"));

            MedicalStaff staff = medicalStaffRepository.findById(dto.getMedicalStaffId())
                    .orElseThrow(() -> new RuntimeException("Ажилтан олдсонгүй"));

            Examination exam = examinationRepository.findById(dto.getExaminationId())
                    .orElseThrow(() -> new RuntimeException("Эмчилгээний мэдээлэл олдсонгүй"));

            ExaminationHelper.updateQuestionnaire(exam, patient, staff);

            Examination savedExam = examinationRepository.save(exam);
            Questionnaire questionnaire = savedExam.getQuestionnaire();

            return new QuestionnaireResponseDto(
                    questionnaire.getId(),
                    questionnaire.getPatient().getId(),
                    savedExam.getId(),
                    savedExam.getMedicalStaff().getId(),
                    questionnaire.getCreatedAt().toString(),
                    questionnaire.getUpdatedAt().toString()
            );
        } catch (RuntimeException e) {
            throw new RuntimeException("Судалгаа илгээх үед алдаа гарлаа: " + e.getMessage(), e);
        }
    }
}
