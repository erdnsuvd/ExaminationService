package com.example.examinationservice.service;

import java.util.List;

import com.example.examinationservice.dto.request.ExaminationRequestDto;
import com.example.examinationservice.dto.response.ExaminationResponseDto;
import com.example.examinationservice.entity.Examination;

public interface ExaminationService {
    ExaminationResponseDto createExamination(ExaminationRequestDto dto);
    Examination getExaminationById(String id);
    List<Examination> getExaminationsByUserId(String userId);
}
