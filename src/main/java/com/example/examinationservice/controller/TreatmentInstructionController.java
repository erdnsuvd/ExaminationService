package com.example.examinationservice.controller;

import com.example.examinationservice.dto.request.TreatmentRequestDto;
import com.example.examinationservice.dto.response.TreatmentResponseDto;
import com.example.examinationservice.service.TreatmentInstructionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ------------- ЭМЧИЛГЭЭНИЫ ЗААВАР БИЧИХ -------------

@RestController
@AllArgsConstructor
@RequestMapping("/api/examination/instruction")
public class TreatmentInstructionController {
    private final TreatmentInstructionService treatmentInstructionService;

    @PostMapping("/add")
    public ResponseEntity<TreatmentResponseDto> addInstruction(@RequestBody TreatmentRequestDto dto) {
        TreatmentResponseDto response = treatmentInstructionService.addInstruction(dto);
        return ResponseEntity.ok(response);
    }

}
