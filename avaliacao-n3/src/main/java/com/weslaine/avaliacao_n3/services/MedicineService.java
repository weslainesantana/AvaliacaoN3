package com.weslaine.avaliacao_n3.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.weslaine.avaliacao_n3.dtos.MedicineRequestDto;
import com.weslaine.avaliacao_n3.dtos.MedicineResponseDto;
import com.weslaine.avaliacao_n3.mappers.MedicineMapper;
import com.weslaine.avaliacao_n3.models.MedicineEntity;
import com.weslaine.avaliacao_n3.repositories.MedicineRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicineService {
    private final MedicineMapper medicineMapper;
    private final MedicineRepository medicineRepository;

    public MedicineResponseDto create(MedicineRequestDto medicineRequestDto){
        return medicineMapper.toDto(medicineRepository.save(medicineMapper.toEntity(medicineRequestDto)));
    }

    public Page<MedicineResponseDto> read(Pageable pageable){
        Page<MedicineEntity> medicine = medicineRepository.findAll(pageable);
        return medicine.map(medicineMapper::toDto);
    }

    public MedicineResponseDto readById(Long id){
        Optional<MedicineEntity> medicine = medicineRepository.findById(id);
        if(medicine.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicamento não encontrado");
        return medicineMapper.toDto(medicine.get());
    }

    public MedicineResponseDto update(Long id, MedicineRequestDto medicineRequestDto){
        Optional<MedicineEntity> medicine = medicineRepository.findById(id);
        if (medicine.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicamente não encontrado");
        
        MedicineEntity medicineEntity = medicineMapper.toEntity(medicineRequestDto);
        medicineEntity.setId(id);
        return medicineMapper.toDto(medicineRepository.save(medicineEntity));
    }

}   

