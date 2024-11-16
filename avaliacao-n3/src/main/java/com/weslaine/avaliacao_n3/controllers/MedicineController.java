package com.weslaine.avaliacao_n3.controllers;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.weslaine.avaliacao_n3.dtos.MedicineRequestDto;
import com.weslaine.avaliacao_n3.dtos.MedicineResponseDto;

import com.weslaine.avaliacao_n3.services.MedicineService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medicine")
public class MedicineController {
    private final MedicineService medicineService;

    @PostMapping
    public MedicineResponseDto create(@RequestBody @Valid MedicineRequestDto medicineRequestDto){
        return medicineService.create(medicineRequestDto);
    }

    @GetMapping
    public Page<MedicineResponseDto> read(Pageable pageable){
        return medicineService.read(pageable);
    }
    
    @GetMapping("{id}")
    public MedicineResponseDto readById(@PathVariable Long id){
        return medicineService.readById(id);
    }


    @PutMapping("{id}")
    public MedicineResponseDto update(@PathVariable Long id, @RequestBody @Valid MedicineRequestDto medicineRequestDto){
        return medicineService.update(id, medicineRequestDto);
    }

    @DeleteMapping("{id}")
    public MedicineResponseDto delete(@PathVariable Long id){
        return medicineService.delete(id);
    }
}
