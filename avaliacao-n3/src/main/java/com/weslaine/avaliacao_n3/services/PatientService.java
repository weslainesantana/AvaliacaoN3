package com.weslaine.avaliacao_n3.services;

import com.weslaine.avaliacao_n3.dtos.PatientRequestDto;
import com.weslaine.avaliacao_n3.dtos.PatientResponseDto;
import com.weslaine.avaliacao_n3.mappers.PatientMapper;
import com.weslaine.avaliacao_n3.models.PatientEntity;
import com.weslaine.avaliacao_n3.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class PatientService {

    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public PatientResponseDto create(PatientRequestDto patientRequestDto) {
        PatientEntity patientEntity = patientMapper.toEntity(patientRequestDto);
        PatientEntity savedPatient = patientRepository.save(patientEntity);
        return patientMapper.toDto(savedPatient);
    }

    public Page<PatientResponseDto> read(Pageable pageable) {
        Page<PatientEntity> patients = patientRepository.findAll(pageable);
        return patients.map(patientMapper::toDto);
    }

    public PatientResponseDto readById(Long id) {
        Optional<PatientEntity> patient = patientRepository.findById(id);
        if (patient.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }
        return patientMapper.toDto(patient.get());
    }

    public PatientResponseDto update(Long id, PatientRequestDto patientRequestDto) {
        Optional<PatientEntity> patient = patientRepository.findById(id);
        if (patient.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }

        PatientEntity patientEntity = patientMapper.toEntity(patientRequestDto);
        patientEntity.setId(id);
        PatientEntity updatedPatient = patientRepository.save(patientEntity);
        return patientMapper.toDto(updatedPatient);
    }

    public PatientResponseDto delete(Long id) {
        Optional<PatientEntity> patient = patientRepository.findById(id);
        if (patient.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }
        patientRepository.delete(patient.get());
        return patientMapper.toDto(patient.get());
    }
}
