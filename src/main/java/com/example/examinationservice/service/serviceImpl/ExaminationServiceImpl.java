package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.request.ExaminationRequestDto;
import com.example.examinationservice.dto.response.ExaminationResponseDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.entity.MedicalStaff;
import com.example.examinationservice.entity.Patient;
import com.example.examinationservice.entity.enums.DoctorsExamination;
import com.example.examinationservice.entity.enums.Status;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ExaminationServiceImpl implements ExaminationService {

    private final ExaminationRepository examinationRepository;

    @Override
    public ExaminationResponseDto createExamination(ExaminationRequestDto dto) {
        try {
            Examination examination = new Examination();
            examination.setExamDate(dto.getExamDate());
            examination.setExamType(dto.getExamType());
            examination.setIllness(dto.getIllness());
            examination.setSurgery(dto.isSurgery());
            examination.setCallback(dto.isCallback());
            examination.setReason(dto.getReason());
            examination.setSendToHigherLevel(dto.isSendToHigherLevel());
            examination.setViolated(dto.isViolated());
            examination.setSickDays(dto.getSickDays());
            examination.setCreatedAt(LocalDateTime.now());
            examination.setUpdatedAt(LocalDateTime.now());

            Status status = dto.getStatus() != null ? Status.valueOf(dto.getStatus()) : Status.ONGOING;
            examination.setStatus(status);

            Patient patient = new Patient();
            patient.setSisiID(dto.getPatientId());
            examination.setPatient(patient);

            MedicalStaff staff = new MedicalStaff();
            staff.setId(dto.getMedicalStaffId());
            examination.setMedicalStaff(staff);

            DoctorsExamination doctorsExamination = DoctorsExamination.valueOf(dto.getDoctorsExamination());
            examination.setDoctorsExamination(doctorsExamination);

            Examination savedExam = examinationRepository.save(examination);

            return new ExaminationResponseDto(
                    savedExam.getId(),
                    savedExam.getExamDate(),
                    savedExam.getDoctorsExamination().name(),
                    savedExam.getExamType(),
                    savedExam.getIllness(),
                    savedExam.isSurgery(),
                    savedExam.isCallback(),
                    savedExam.getReason(),
                    savedExam.isSendToHigherLevel(),
                    savedExam.isViolated(),
                    savedExam.getSickDays(),
                    savedExam.getStatus().name(),
                    savedExam.getPatient().getSisiID(),
                    savedExam.getMedicalStaff().getId(),
                    savedExam.getCreatedAt().toString(),
                    savedExam.getUpdatedAt().toString());

        } catch (Exception e) {
            throw new RuntimeException("Үзлэг нэмэхэд алдаа гарлаа: " + e.getMessage());
        }
    }

    @Override
    public Examination getExaminationById(String id) {
        return examinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Үзлэгийн мэдээлэл олдсонгүй. ID: " + id));
    }

    @Override
    public List<Examination> getExaminationsByUserId(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new RuntimeException("Хэрэглэгчийн ID хоосон байна");
        }
        List<Examination> exams = examinationRepository.findByUserId(userId);
        if (exams.isEmpty()) {
            throw new RuntimeException(
                    "Хэрэглэгчийн үзлэгийн мэдээлэл олдсонгүй. ID: " + userId);
        }
        return exams;
    }
}
