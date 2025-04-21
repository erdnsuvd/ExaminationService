package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.request.PrescriptionRequestDto;
import com.example.examinationservice.dto.response.PrescriptionResponseDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.entity.MedicalStaff;
import com.example.examinationservice.entity.Patient;
import com.example.examinationservice.entity.Prescription;
import com.example.examinationservice.helper.ExaminationHelper;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.repository.MedicalStaffRepository;
import com.example.examinationservice.repository.PatientRepository;
import com.example.examinationservice.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {
    private final ExaminationRepository examinationRepository;
    private final PatientRepository patientRepository;
    private final MedicalStaffRepository medicalStaffRepository;

    @Override
    public PrescriptionResponseDto addPrescription(PrescriptionRequestDto dto) {
        try {
            Patient patient = patientRepository.findById(dto.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Өвчтөн олдсонгүй"));

            MedicalStaff staff = medicalStaffRepository.findById(dto.getPrescribedBy())
                    .orElseThrow(() -> new RuntimeException("Ажилтан олдсонгүй"));

            Examination exam = examinationRepository.findById(dto.getExaminationId())
                    .orElseThrow(() -> new RuntimeException("Шинжилгээ олдсонгүй"));

            ExaminationHelper.updatePrescription(exam, patient, staff, dto);

            Examination savedExam = examinationRepository.save(exam);
            Prescription prescription = savedExam.getPrescription();

            if (prescription == null) {
                throw new RuntimeException("Жорын мэдээлэл хадгалагдаагүй байна");
            }

            return new PrescriptionResponseDto(
                    prescription.getId(),
                    prescription.getDate().toString(),
                    prescription.getPrescribedBy().getId(),
                    prescription.getPatient().getId(),
                    savedExam.getId(),
                    prescription.getMedicineName(),
                    prescription.getDose(),
                    prescription.getFrequency(),
                    prescription.getDuration(),
                    prescription.getCreatedAt().toString(),
                    prescription.getUpdatedAt().toString()
            );
        } catch (RuntimeException e) {
            throw new RuntimeException("Жор нэмэхэд алдаа гарлаа: " + e.getMessage(), e);
        }
    }
}




