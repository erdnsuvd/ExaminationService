package com.example.examinationservice.service;

import com.example.examinationservice.dto.request.QuestionnaireRequestDto;
import com.example.examinationservice.dto.response.QuestionnaireResponseDto;

public interface QuestionnareService {
    QuestionnaireResponseDto submitQuestion(QuestionnaireRequestDto dto);
}

