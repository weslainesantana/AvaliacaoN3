package com.weslaine.avaliacao_n3.dtos;

public record PatientResponseDto(
        Long id,
        String name,
        String age,
        String medicalHistory) {
}
