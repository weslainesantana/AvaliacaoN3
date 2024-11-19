package com.weslaine.avaliacao_n3.mappers;


import com.weslaine.avaliacao_n3.dtos.PatientRequestDto;
import com.weslaine.avaliacao_n3.dtos.PatientResponseDto;
import com.weslaine.avaliacao_n3.models.PatientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientResponseDto toDto(PatientEntity patientEntity);
    @Mapping(target = "id", ignore = true)
    PatientEntity toEntity(PatientRequestDto patientRequestDto);
}
