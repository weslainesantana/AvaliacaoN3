package com.weslaine.avaliacao_n3.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.weslaine.avaliacao_n3.dtos.PrescriptionRequestDto;
import com.weslaine.avaliacao_n3.dtos.PrescriptionResponseDto;
import com.weslaine.avaliacao_n3.mappers.PrescriptionMapper;
import com.weslaine.avaliacao_n3.models.MedicineEntity;
import com.weslaine.avaliacao_n3.models.PatientEntity;
import com.weslaine.avaliacao_n3.models.PrescriptionEntity;
import com.weslaine.avaliacao_n3.repositories.MedicineRepository;
import com.weslaine.avaliacao_n3.repositories.PatientRepository;
import com.weslaine.avaliacao_n3.repositories.PrescriptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrescriptionService {
    private final PrescriptionMapper prescriptionMapper;
    private final PrescriptionRepository prescriptionRepository;
    private final PatientRepository patientRepository;
    private final MedicineRepository medicineRepository;

    public PrescriptionResponseDto create(PrescriptionRequestDto prescriptionRequestDto) {
        Optional<PatientEntity> patient = patientRepository.findById(prescriptionRequestDto.patientId());
        Optional<MedicineEntity> medicine = medicineRepository.findById(prescriptionRequestDto.medicineId());
        if(patient.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Paciente não encontrado");
        if(medicine.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Medicamento não encontrado");
        return prescriptionMapper.toDto(prescriptionRepository.save(prescriptionMapper.toEntity(prescriptionRequestDto)));
    }

    public Page<PrescriptionResponseDto> read(Pageable pageable) {
        Page<PrescriptionEntity> prescription = prescriptionRepository.findAll(pageable);
        return prescription.map(prescriptionMapper::toDto);
    }

    public PrescriptionResponseDto readById(Long id) {
        Optional<PrescriptionEntity> prescription = prescriptionRepository.findById(id);
        if(prescription.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhuma prescrição encontrada");
        return prescriptionMapper.toDto(prescription.get());
    }

    public PrescriptionResponseDto updateById(Long id, PrescriptionRequestDto prescriptionRequestDto) {
        Optional<PrescriptionEntity> prescription = prescriptionRepository.findById(id);
        if(prescription.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhuma prescrição encontrada");
        PrescriptionEntity prescriptionEntity = prescriptionMapper.toEntity(prescriptionRequestDto);
        prescriptionEntity.setId(id);
        return prescriptionMapper.toDto(prescriptionRepository.save(prescriptionEntity));
    }

    public PrescriptionResponseDto deleteById(Long id) {
        Optional<PrescriptionEntity> prescription = prescriptionRepository.findById(id);
        if(prescription.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhuma prescrição encontrada");
        prescriptionRepository.delete(prescription.get());
        return prescriptionMapper.toDto(prescription.get());
    }
}
