package com.example.examinationservice.controller;

import com.example.examinationservice.dto.request.QuestionnaireRequestDto;
import com.example.examinationservice.dto.response.QuestionnaireResponseDto;
import com.example.examinationservice.service.QuestionnareService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ------------- АСУУМЖ БӨГЛӨХ -------------

@RestController
@AllArgsConstructor
@RequestMapping("/api/examination/survey")
public class QuestionnaireController {

    private final QuestionnareService service;

    @PostMapping("/submit")
    public ResponseEntity<QuestionnaireResponseDto> submitSurvey(@RequestBody QuestionnaireRequestDto dto) {
        QuestionnaireResponseDto response = service.submitQuestion(dto);
        return ResponseEntity.ok(response);
    }
}
