package com.example.examinationservice.controller;

import com.example.examinationservice.dto.request.DiagnosisCodeRequestDto;
import com.example.examinationservice.dto.request.DiagnosisRequestDto;
import com.example.examinationservice.dto.response.DiagnosisCodeResponseDto;
import com.example.examinationservice.dto.response.DiagnosisResponseDto;
import com.example.examinationservice.service.DiagnosisService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ------------- ОНОШ ТАВИХ -------------

@RestController
@AllArgsConstructor
@RequestMapping("/api/examination/diagnosis")
public class DiagnosisController {

    private final DiagnosisService service;

    @PostMapping("/addDiagnosis")
    public ResponseEntity<DiagnosisResponseDto> addDiagnosis(@RequestBody DiagnosisRequestDto dto) {
        DiagnosisResponseDto response = service.addDiagnosis(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addDiagnosisCode")
    public ResponseEntity<DiagnosisCodeResponseDto> addDiagnosisCode(@RequestBody DiagnosisCodeRequestDto dto) {
        DiagnosisCodeResponseDto response = service.addDiagnosisCode(dto);
        return ResponseEntity.ok(response);
    }
}
