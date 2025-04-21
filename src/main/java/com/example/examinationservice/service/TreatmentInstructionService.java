package com.example.examinationservice.service;

import com.example.examinationservice.dto.request.TreatmentRequestDto;
import com.example.examinationservice.dto.response.TreatmentResponseDto;

public interface TreatmentInstructionService {
    TreatmentResponseDto addInstruction(TreatmentRequestDto dto);
}
