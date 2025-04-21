package com.example.examinationservice.controller;

import com.example.examinationservice.dto.request.PrescriptionRequestDto;
import com.example.examinationservice.dto.response.PrescriptionResponseDto;
import com.example.examinationservice.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ------------- ЭМИЙН ЖОР БИЧИХ -------------

@RestController
@AllArgsConstructor
@RequestMapping("/api/examination/prescription")
public class PrescriptionController {

    private final PrescriptionService service;

    @PostMapping("/add")
    public ResponseEntity<PrescriptionResponseDto> addPrescription(@RequestBody PrescriptionRequestDto dto) {
        PrescriptionResponseDto response = service.addPrescription(dto);
        return ResponseEntity.ok(response);
    }
}

