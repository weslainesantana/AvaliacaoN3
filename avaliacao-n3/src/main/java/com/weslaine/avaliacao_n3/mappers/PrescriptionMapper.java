package com.weslaine.avaliacao_n3.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.weslaine.avaliacao_n3.dtos.PrescriptionRequestDto;
import com.weslaine.avaliacao_n3.dtos.PrescriptionResponseDto;
import com.weslaine.avaliacao_n3.models.PrescriptionEntity;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {
    @Mapping(target = "patient", source = "patientEntity")
    @Mapping(target = "medicine", source = "medicineEntity")
    PrescriptionResponseDto toDto(PrescriptionEntity prescriptionEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patientEntity.id", source = "patientId")
    @Mapping(target = "medicineEntity.id", source = "medicineId")
    PrescriptionEntity toEntity(PrescriptionRequestDto prescriptionRequestDto);
}
