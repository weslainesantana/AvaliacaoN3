package com.weslaine.avaliacao_n3.dtos;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicineRequestDto(
    @NotBlank(message = "O Campo nome não pode estar vazio")
    String name,
    @NotBlank(message = "O Campo descrição não pode estar vazio")
    String description, 
    @NotBlank(message = "O campo dose não pode estar vazio")
    String dose, 
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "O campo Data de validade não pode estar nula")
    LocalDate expirationDate
) {
    
}
