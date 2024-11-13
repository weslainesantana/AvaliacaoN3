package com.weslaine.avaliacao_n3.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.weslaine.avaliacao_n3.dtos.MedicineRequestDto;
import com.weslaine.avaliacao_n3.dtos.MedicineResponseDto;
import com.weslaine.avaliacao_n3.models.MedicineEntity;

@Mapper
public interface MedicineMapper {
    MedicineResponseDto toDto(MedicineEntity medicineEntity);
    @Mapping(target = "id", ignore = true)
    MedicineEntity toEntity(MedicineRequestDto medicineRequestDto);
}
