package com.example.examinationservice.service;

import com.example.examinationservice.dto.request.DiagnosisCodeRequestDto;
import com.example.examinationservice.dto.request.DiagnosisRequestDto;
import com.example.examinationservice.dto.response.DiagnosisCodeResponseDto;
import com.example.examinationservice.dto.response.DiagnosisResponseDto;

public interface DiagnosisService {
    DiagnosisResponseDto addDiagnosis(DiagnosisRequestDto dto);
    DiagnosisCodeResponseDto addDiagnosisCode(DiagnosisCodeRequestDto dto);
}
