package com.weslaine.avaliacao_n3.controllers;


import com.weslaine.avaliacao_n3.dtos.PatientRequestDto;
import com.weslaine.avaliacao_n3.dtos.PatientResponseDto;
import com.weslaine.avaliacao_n3.services.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public PatientResponseDto create(@RequestBody @Valid PatientRequestDto patientRequestDto){
        return patientService.create(patientRequestDto);
    }

    @GetMapping
    public Page<PatientResponseDto> read(Pageable pageable){
        return patientService.read(pageable);
    }

    @GetMapping("{id}")
    public PatientResponseDto readById(@PathVariable Long id){
        return patientService.readById(id);
    }


    @PutMapping("{id}")
    public PatientResponseDto update(@PathVariable Long id, @RequestBody @Valid PatientRequestDto patientRequestDto){
        return patientService.update(id, patientRequestDto);
    }

    @DeleteMapping("{id}")
    public PatientResponseDto delete(@PathVariable Long id){
        return patientService.delete(id);
    }
}

