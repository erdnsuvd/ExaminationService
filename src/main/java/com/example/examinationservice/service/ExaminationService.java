package com.example.examinationservice.service;

import com.example.examinationservice.dto.request.ExaminationRequestDto;
import com.example.examinationservice.dto.response.ExaminationResponseDto;

public interface ExaminationService {
    ExaminationResponseDto createExamination(ExaminationRequestDto dto);
}
