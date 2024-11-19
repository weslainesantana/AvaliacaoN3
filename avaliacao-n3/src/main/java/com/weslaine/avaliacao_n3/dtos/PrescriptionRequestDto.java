package com.weslaine.avaliacao_n3.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PrescriptionRequestDto(
    @NotNull(message = "O campo quantidade não pode ser nulo")
    int quantity,
    @NotBlank(message = "O campo frequência não pode estar vazio")
    String frequency,
    @NotNull(message = "O campo inicio não pode ser nulo")
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate startDate,
    @NotNull(message = "O campo fim não pode ser nulo")
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate endDate,
    @NotNull(message = "O campo paciente não pode ser nulo")
    Long patientId,
    @NotNull(message = "O campo medicamento não pode ser nulo")
    Long medicineId
) {
    
}
