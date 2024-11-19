package com.weslaine.avaliacao_n3.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.weslaine.avaliacao_n3.dtos.PrescriptionRequestDto;
import com.weslaine.avaliacao_n3.dtos.PrescriptionResponseDto;
import com.weslaine.avaliacao_n3.services.PrescriptionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prescription")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrescriptionResponseDto create(@RequestBody @Valid PrescriptionRequestDto prescriptionRequestDto) {
        return prescriptionService.create(prescriptionRequestDto);
    }

    @GetMapping
    public Page<PrescriptionResponseDto> read(Pageable pageable) {
        return prescriptionService.read(pageable);
    }

    @GetMapping("{id}")
    public PrescriptionResponseDto readById(@PathVariable Long id) {
        return prescriptionService.readById(id);
    }

    @PutMapping("{id}")
    public PrescriptionResponseDto updateById(@PathVariable Long id,@RequestBody @Valid PrescriptionRequestDto prescriptionRequestDto) {
        return prescriptionService.updateById(id, prescriptionRequestDto);
    }

    @DeleteMapping("{id}")
    public PrescriptionResponseDto deleteById(@PathVariable Long id) {
        return prescriptionService.deleteById(id);
    }
}
