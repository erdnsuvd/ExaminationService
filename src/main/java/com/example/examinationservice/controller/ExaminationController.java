package com.example.examinationservice.controller;

import com.example.examinationservice.dto.request.ExaminationRequestDto;
import com.example.examinationservice.dto.response.ExaminationResponseDto;
import com.example.examinationservice.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/examination")
public class ExaminationController {

    private final ExaminationService service;

    @PostMapping("/create")
    public ResponseEntity<ExaminationResponseDto> create(@RequestBody ExaminationRequestDto dto) {
        ExaminationResponseDto response = service.createExamination(dto);
        return ResponseEntity.ok(response);
    }
}
