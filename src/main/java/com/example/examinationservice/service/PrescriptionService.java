package com.example.examinationservice.service;

import com.example.examinationservice.dto.request.PrescriptionRequestDto;
import com.example.examinationservice.dto.response.PrescriptionResponseDto;

public interface PrescriptionService {
    PrescriptionResponseDto addPrescription(PrescriptionRequestDto dto);
}
