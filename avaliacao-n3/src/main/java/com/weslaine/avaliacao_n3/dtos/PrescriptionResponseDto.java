package com.weslaine.avaliacao_n3.dtos;

import java.time.LocalDate;

public record PrescriptionResponseDto(
    Long id,
    int quantity,
    String frequency,
    LocalDate startDate,
    LocalDate endDate,
    PatientResponseDto patient,
    MedicineResponseDto medicine
) {

}
    