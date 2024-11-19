package com.weslaine.avaliacao_n3.dtos;

import jakarta.validation.constraints.NotBlank;

public record PatientRequestDto(
        @NotBlank(message = "O Campo nome não pode estar vazio")
        String name,
        @NotBlank(message = "O Campo descrição não pode estar vazio")
        String age,
        @NotBlank(message = "O Campo descrição não pode estar vazio")
        String medicalHistory
) {
}
